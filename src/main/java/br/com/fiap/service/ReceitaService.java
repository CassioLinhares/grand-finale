package br.com.fiap.service;

import br.com.fiap.model.Receita;
import br.com.fiap.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita cadastrar(Receita receita){
        if (receita.getConta() == null) {
            throw new RuntimeException("A conta é obrigatória!");
        }

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

            if (receita.getValorReceita() <= 0) {
                throw new RuntimeException("A receita precisa ter valor positivo!");
            }

            receitaAtual.setValorReceita(receita.getValorReceita());

            if (receita.getTipoReceita() != null) {
                receitaAtual.setTipoReceita(receita.getTipoReceita());
            }

            if (receita.getDescricao() != null) {
                receitaAtual.setDescricao(receita.getDescricao());
            }

            if (receita.getDataEmissao() != null) {
                receitaAtual.setDataEmissao(receita.getDataEmissao());
            }

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
