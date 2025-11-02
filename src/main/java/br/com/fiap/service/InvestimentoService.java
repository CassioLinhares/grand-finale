package br.com.fiap.service;

import br.com.fiap.model.Investimento;
import br.com.fiap.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Investimento cadastrar(Investimento investimento) {
        if (investimento.getConta() == null) {
            throw new RuntimeException("A conta é obrigatória!");
        }

        Long idConta = investimento.getConta().getIdConta();
        String nomeInvestimento = investimento.getNomeInvestimento();
        Optional<Investimento> investimentoOptional = investimentoRepository
                .findByNomeInvestimentoEConta_IdConta(nomeInvestimento, idConta);

        if (investimentoOptional.isPresent()) {
            throw new RuntimeException("Nome de investimento já está em uso!");
        }

        if (investimento.getValor() <= 0) {
            throw new RuntimeException("O valor do investimento precisa ser maior que zero.");
        }

        if (investimento.getValorAtual() < 0.0) {
            throw new RuntimeException("O valor atual do investimento não pode ser negativo!");
        }

        if (investimento.getTipoInvestimento() == null || investimento.getTipoInvestimento().trim().isEmpty()) {
            throw new RuntimeException("O tipo de investimento é obrigatório!");
        }

        if (investimento.getNomeInstituicao() == null || investimento.getNomeInstituicao().trim().isEmpty()) {
            throw new RuntimeException("O nome da instituição é obrigatório!");
        }

        if (investimento.getDataAplicacao() == null) {
            throw new RuntimeException("A data da aplicação é obrigatória!");
        }

        return investimentoRepository.save(investimento);
    }

    public Investimento atualizar(Investimento investimento, Long id) {
        Optional<Investimento> investimentoOptional = investimentoRepository.findById(id);
        if (!investimentoOptional.isPresent()) {
            throw new RuntimeException("Investimento não foi encontrado!");
        }

        Investimento investimentoAtual = investimentoOptional.get();
        String novoNome = investimento.getNomeInvestimento();
        String nomeAtual = investimentoAtual.getNomeInvestimento();
        Long idConta = investimentoAtual.getConta().getIdConta();

        if (novoNome != null && !novoNome.equals(nomeAtual)) {
            if (investimentoRepository.findByNomeInvestimentoEConta_IdConta(novoNome, idConta).isPresent()) {
                throw new RuntimeException("Nome de investimento já esta em uso!");
            }
            investimentoAtual.setNomeInvestimento(novoNome);
        }

        if (investimento.getValor() <= 0.0) {
            throw new RuntimeException("O valor do investimento deve ser maior que zero");
        }
        investimentoAtual.setValor(investimento.getValor());

        if (investimento.getValorAtual() < 0.0) {
            throw new RuntimeException("O valor atual do investimento não pode ser negativo!");
        }
        investimentoAtual.setValorAtual(investimento.getValorAtual());

        if (investimento.getTipoInvestimento() != null) {
            investimentoAtual.setTipoInvestimento(investimento.getTipoInvestimento());
        }

        if (investimento.getNomeInstituicao() != null) {
            investimentoAtual.setNomeInstituicao(investimento.getNomeInstituicao());
        }

        investimentoAtual.setRentabilidade(investimento.getRentabilidade());

        if (investimento.getDataAplicacao() != null) {
            investimentoAtual.setDataAplicacao(investimento.getDataAplicacao());
        }

        if (investimento.getDataRetiradaAplicacao() != null) {
            investimentoAtual.setDataRetiradaAplicacao(investimento.getDataRetiradaAplicacao());
        }
        return investimentoRepository.save(investimentoAtual);
    }

    public List<Investimento> buscarTodosInvestimentos() {
        return investimentoRepository.findAll();
    }

    public Investimento buscarPorId(Long id) {
        Optional<Investimento> investimentoOptional = investimentoRepository.findById(id);
        if (investimentoOptional.isPresent()) {
            return investimentoOptional.get();
        } else {
            throw new RuntimeException("Investimento não encontrado!");
        }
    }

    public void excluir(Long id) {
        Optional<Investimento> investimentoOptional = investimentoRepository.findById(id);
        if (investimentoOptional.isPresent()) {
            investimentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Investimento não encontrado, não foi possível excluir!");
        }
    }
}