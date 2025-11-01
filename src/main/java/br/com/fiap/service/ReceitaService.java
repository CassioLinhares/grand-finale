package br.com.fiap.service;

import br.com.fiap.model.Receita;
import br.com.fiap.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita cadastrar(Receita receita){
        if (receita.getValorReceita() > 0.0){
            return receitaRepository.save(receita);
        } else {
            throw new RuntimeException("A receita precisa ter o valor positivo!");
        }
    }

    public Receita atualizar(Receita receita, Long id){
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        if (receitaOptional.isPresent()){
            Receita receitaAtual = receitaOptional.get();

            receitaAtual.setTipoReceita(receita.getTipoReceita());
            receitaAtual.setDescricao(receita.getDescricao());
            receitaAtual.setDataEmissao(receita.getDataEmissao());
            receitaAtual.setValorReceita(receita.getValorReceita());

            return receitaRepository.save(receitaAtual);
        } else {
            throw new RuntimeException("Receita não encontrada!");
        }
    }

    public Receita buscarPorId(Receita receita, Long id){
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        if (receitaOptional.isPresent()){
            return receitaOptional.get();
        } else {
            throw new RuntimeException("Receita não encontrada!");
        }
    }

    public List<Receita> buscarTodasReceitas(){
        return receitaRepository.findAll();
    }

    public void excluirReceita(Receita receita, Long id){
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        if (receitaOptional.isPresent()){
            receitaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Receita não encontrada!");
        }
    }
}
