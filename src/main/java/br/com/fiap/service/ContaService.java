package br.com.fiap.service;

import br.com.fiap.model.Conta;
import br.com.fiap.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrar(Conta conta) {
        if (conta.getUsuario() == null) {
            throw new RuntimeException("A conta precisa ter um usuário!");
        }

        if (conta.getNumeroConta() == null || conta.getNumeroConta().trim().isEmpty()) {
            throw new RuntimeException("O número da conta é obrigatório!");
        }

        if (conta.getAgencia() == null || conta.getAgencia().trim().isEmpty()) {
            throw new RuntimeException("A agência é obrigatória!");
        }

        Optional<Conta> contaExistente = contaRepository
                .findByNumeroContaAndAgencia(conta.getNumeroConta(), conta.getAgencia());

        if (contaExistente.isPresent()) {
            throw new RuntimeException("Já existe uma conta com este número e agência!");
        }

        if (conta.getTipoConta() == null || conta.getTipoConta().trim().isEmpty()) {
            throw new RuntimeException("O tipo de conta é obrigatório!");
        }

        if (conta.getBanco() == null || conta.getBanco().trim().isEmpty()) {
            throw new RuntimeException("O banco é obrigatório!");
        }

        return contaRepository.save(conta);
    }

    public Conta atualizar(Long id, Conta conta) {
        Optional<Conta> contaOptional = contaRepository.findById(id);

        if (!contaOptional.isPresent()) {
            throw new RuntimeException("A conta não foi encontrada!");
        }

        Conta contaAtual = contaOptional.get();

        if (conta.getTipoConta() != null && !conta.getTipoConta().trim().isEmpty()) {
            contaAtual.setTipoConta(conta.getTipoConta());
        }

        if (conta.getBanco() != null && !conta.getBanco().trim().isEmpty()) {
            contaAtual.setBanco(conta.getBanco());
        }

        if (conta.getNumeroConta() != null && !conta.getNumeroConta().trim().isEmpty()) {
            contaAtual.setNumeroConta(conta.getNumeroConta());
        }

        if (conta.getAgencia() != null && !conta.getAgencia().trim().isEmpty()) {
            contaAtual.setAgencia(conta.getAgencia());
        }

        contaAtual.setSaldo(conta.getSaldo());

        return contaRepository.save(contaAtual);
    }

    public List<Conta> buscarTodasContas() {
        return contaRepository.findAll();
    }

    public Conta buscarPorId(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            return contaOptional.get();
        } else {
            throw new RuntimeException("Conta não encontrada!");
        }
    }

    public void excluir(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            contaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conta não encontrada, não foi possível excluir!");
        }
    }
}