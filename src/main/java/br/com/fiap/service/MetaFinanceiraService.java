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

    public MetaFinanceira cadastrar(MetaFinanceira metaFinanceira, Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findByNameMetaFinanceiraAndIdUsuario(metaFinanceira.getNomeMetaFinanceira(), id);
        if (metaFinanceiraOptional.isPresent()){
            throw new RuntimeException("Este nome de orçamento já esta em uso!");
        }

        if (metaFinanceira.getValorObjetivo() <= 0) {
            throw new RuntimeException("O valor da metaFinanceira precisa ser acima de zero!");
        }

        return metaFinanceiraRepository.save(metaFinanceira);
    }

    public MetaFinanceira atualizar(MetaFinanceira metaFinanceira, Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findById(id);
        if (metaFinanceiraOptional.isPresent()){
            MetaFinanceira metaFinanceiraAtual = metaFinanceiraOptional.get();

            String novoNome = metaFinanceira.getNomeMetaFinanceira();
            String nomeAtual = metaFinanceiraAtual.getNomeMetaFinanceira();
            if (novoNome != null && !novoNome.equals(nomeAtual)){
                if (metaFinanceiraRepository.findByNameMetaFinanceiraAndIdUsuario(novoNome, id).isPresent()){
                    throw new RuntimeException("Nome de orçamento já esta em uso!");
                }
                metaFinanceiraAtual.setNomeMetaFinanceira(metaFinanceira.getNomeMetaFinanceira());
            }
            metaFinanceiraAtual.setTipoMetaFinanceira(metaFinanceira.getTipoMetaFinanceira());
            metaFinanceiraAtual.setDataCriacao(metaFinanceira.getDataCriacao());
            metaFinanceiraAtual.setDataConclusao(metaFinanceira.getDataConclusao());
            metaFinanceiraAtual.setValorObjetivo(metaFinanceira.getValorObjetivo());
            metaFinanceiraAtual.setValorAtual(metaFinanceira.getValorAtual());
            metaFinanceiraAtual.setDescricao(metaFinanceira.getDescricao());

            return metaFinanceiraRepository.save(metaFinanceiraAtual);
        } else {
            throw new RuntimeException("MetaFinanceira não encontrada!");
        }
    }

    public MetaFinanceira buscarPorId(MetaFinanceira metaFinanceira, Long id){
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

    public void excluirMetaFinanceira(MetaFinanceira metaFinanceira, Long id){
        Optional<MetaFinanceira> metaFinanceiraOptional = metaFinanceiraRepository.findById(id);
        if (metaFinanceiraOptional.isPresent()){
            metaFinanceiraRepository.deleteById(id);
        } else {
            throw new RuntimeException("MetaFinanceira não encontrado!");
        }
    }
}


