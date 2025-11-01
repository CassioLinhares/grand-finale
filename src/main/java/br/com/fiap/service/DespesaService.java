package br.com.fiap.service;

import br.com.fiap.model.Despesas;
import br.com.fiap.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesasRepository despesasRepository;

    public Despesas cadastrar(Despesas despesas){
        if (despesas.getValor() > 0.0){
            return despesasRepository.save(despesas);
        } else {
            throw new RuntimeException("A despesa precisa ter o valor positivo!");
        }
    }

    public Despesas atualizar(Despesas despesas, Long id){
        Optional<Despesas> despesasOptional = despesasRepository.findById(id);
        if (despesasOptional.isPresent()){
            Despesas despesasAtual = despesasOptional.get();

            despesasAtual.setTipo_despesas(despesas.getTipo_despesas());
            despesasAtual.setNome_despesa(despesas.getNome_despesa());
            despesasAtual.setDataGasto(despesas.getDataGasto());
            despesasAtual.setValor(despesas.getValor());

            return despesasRepository.save(despesasAtual);
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }

    public Despesas buscarPorId(Despesas despesas, Long id){
        Optional<Despesas> despesasOptional = despesasRepository.findById(id);
        if (despesasOptional.isPresent()){
            return despesasOptional.get();
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }

    public List<Despesas> buscarTodasDespesas(){
        return despesasRepository.findAll();
    }

    public void excluirDespesas(Despesas despesas, Long id){
        Optional<Despesas> despesasOptional = despesasRepository.findById(id);
        if (despesasOptional.isPresent()){
            despesasRepository.deleteById(id);
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }
}
