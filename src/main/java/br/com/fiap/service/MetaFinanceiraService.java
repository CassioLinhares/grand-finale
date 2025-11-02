package br.com.fiap.service;

import br.com.fiap.model.MetaFinanceira;
import br.com.fiap.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaFinanceiraService {

    @Autowired
    private MetaFinanceiraRepository metaFinanceiraRepository;

    public MetaFinanceira cadastrar(MetaFinanceira metaFinanceira) {
        if (metaFinanceira.getConta() == null) {
            throw new RuntimeException("A conta é obrigatória!");
        }

        Long idConta = metaFinanceira.getConta().getIdConta();
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository
                .findByNameMetaFinanceiraAndConta_IdConta(metaFinanceira.getNomeMetaFinanceira(), idConta);

        if (metaFinanceiraOptional.isPresent()) {
            throw new RuntimeException("Este nome de meta financeira já está em uso!");
        }

        if (metaFinanceira.getValorObjetivo() <= 0) {
            throw new RuntimeException("O valor objetivo da meta financeira precisa ser acima de zero!");
        }

        if (metaFinanceira.getValorAtual() < 0) {
            throw new RuntimeException("O valor atual não pode ser negativo!");
        }

        return metaFinanceiraRepository.save(metaFinanceira);
    }

    public MetaFinanceira atualizar(MetaFinanceira metaFinanceira, Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findById(id);
        if (!metaFinanceiraOptional.isPresent()){
            throw new RuntimeException("MetaFinanceira não encontrada!");
        }

        MetaFinanceira metaFinanceiraAtual = metaFinanceiraOptional.get();
        String novoNome = metaFinanceira.getNomeMetaFinanceira();
        String nomeAtual = metaFinanceiraAtual.getNomeMetaFinanceira();
        Long idConta = metaFinanceiraAtual.getConta().getIdConta();

        if (novoNome != null && !novoNome.equals(nomeAtual)){
            if (metaFinanceiraRepository.findByNameMetaFinanceiraAndConta_IdConta(novoNome, idConta).isPresent()){
                throw new RuntimeException("Nome da Meta financeira já esta em uso!");
            }
            metaFinanceiraAtual.setNomeMetaFinanceira(novoNome);
        }
        if (metaFinanceira.getValorObjetivo() <= 0.0) {
            throw new RuntimeException("O valor objetivo da meta financeira precisa ser acima de zero!");
        }
        metaFinanceiraAtual.setValorObjetivo(metaFinanceira.getValorObjetivo());

        if (metaFinanceira.getValorAtual() < 0.0) {
                throw new RuntimeException("O valor atual não pode ser negativo!");
        }
        metaFinanceiraAtual.setValorAtual(metaFinanceira.getValorAtual());

        if (metaFinanceira.getTipoMetaFinanceira() != null) {
            metaFinanceiraAtual.setTipoMetaFinanceira(metaFinanceira.getTipoMetaFinanceira());
        }

        if (metaFinanceira.getDataCriacao() != null) {
            metaFinanceiraAtual.setDataCriacao(metaFinanceira.getDataCriacao());
        }

        if (metaFinanceira.getDataConclusao() != null) {
            metaFinanceiraAtual.setDataConclusao(metaFinanceira.getDataConclusao());
        }

        if (metaFinanceira.getDescricao() != null) {
            metaFinanceiraAtual.setDescricao(metaFinanceira.getDescricao());
        }

        return metaFinanceiraRepository.save(metaFinanceiraAtual);
    }

    public MetaFinanceira buscarPorId(Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findById(id);
        if (metaFinanceiraOptional.isPresent()){
            return metaFinanceiraOptional.get();
        } else {
            throw new RuntimeException("Orçamento não encontrado!");
        }
    }

    public List<MetaFinanceira> buscarTodasMetaFinanceiras(){
        return metaFinanceiraRepository.findAll();
    }

    public void excluirMetaFinanceira(Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findById(id);
        if (metaFinanceiraOptional.isPresent()){
            metaFinanceiraRepository.deleteById(id);
        } else {
            throw new RuntimeException("MetaFinanceira não encontrado!");
        }
    }
}


