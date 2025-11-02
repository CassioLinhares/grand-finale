package br.com.fiap.service;

import br.com.fiap.model.Orcamento;
import br.com.fiap.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public Orcamento cadastrar(Orcamento orcamento) {
        if (orcamento.getConta().getIdConta() == null) {
            throw new RuntimeException("A conta é obrigatória!");
        }

        Optional<Orcamento> orcamentoOptional = orcamentoRepository
                .findByNomeOrcamentoAndConta_IdConta(orcamento.getNomeOrcamento(), orcamento.getConta().getIdConta());

        if (orcamentoOptional.isPresent()) {
            throw new RuntimeException("Este nome de orçamento já está em uso para esta conta!");
        }

        if (orcamento.getValorOrcamento() <= 0) {
            throw new RuntimeException("O orçamento precisa ter o valor acima de zero!");
        }

        return orcamentoRepository.save(orcamento);
    }

    public Orcamento atualizar(Long id, Orcamento orcamento) {
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);

        if (!orcamentoOptional.isPresent()) {
            throw new RuntimeException("Orçamento não encontrado!");
        }

        Orcamento orcamentoAtual = orcamentoOptional.get();
        String novoNome = orcamento.getNomeOrcamento();
        String nomeAtual = orcamentoAtual.getNomeOrcamento();
        Long idConta = orcamentoAtual.getConta().getIdConta();

        if (novoNome != null && !novoNome.equals(nomeAtual)) {
            if (orcamentoRepository.findByNomeOrcamentoAndConta_IdConta(novoNome, idConta).isPresent()) {
                throw new RuntimeException("Nome de orçamento já está em uso para esta conta!");
            }
            orcamentoAtual.setNomeOrcamento(novoNome);
        }

        if (orcamento.getValorOrcamento() <= 0) {
            throw new RuntimeException("O orçamento precisa ter o valor acima de zero!");
        }

        if (orcamento.getTipoOrcamento() != null) {
            orcamentoAtual.setTipoOrcamento(orcamento.getTipoOrcamento());
        }

        if (orcamento.getDataInicio() != null) {
            orcamentoAtual.setDataInicio(orcamento.getDataInicio());
        }

        if (orcamento.getDataFim() != null) {
            orcamentoAtual.setDataFim(orcamento.getDataFim());
        }

        orcamentoAtual.setValorOrcamento(orcamento.getValorOrcamento());

        return orcamentoRepository.save(orcamentoAtual);
    }

    public Orcamento buscarPorId(Long id){
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);
        if (orcamentoOptional.isPresent()){
            return orcamentoOptional.get();
        } else {
            throw new RuntimeException("Orçamento não encontrado!");
        }
    }

    public List<Orcamento> buscarTodasOrcamentos(){
        return orcamentoRepository.findAll();
    }

    public void excluirOrcamento(Long id){
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);
        if (orcamentoOptional.isPresent()){
            orcamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }
}