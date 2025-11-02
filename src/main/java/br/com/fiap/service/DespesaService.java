package br.com.fiap.service;

import br.com.fiap.model.Despesa;
import br.com.fiap.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesasRepository despesaRepository;

    public Despesa cadastrar(Despesa despesa){
        if (despesa.getConta() == null) {
            throw new RuntimeException("A conta é obrigatória!");
        }

        if (despesa.getValor() > 0.0){
            return despesaRepository.save(despesa);
        } else {
            throw new RuntimeException("A despesa precisa ter o valor positivo!");
        }
    }

    public Despesa atualizar(Long id, Despesa despesa) {
        Optional<Despesa> despesaOptional = despesaRepository.findById(id);

        if (!despesaOptional.isPresent()) {
            throw new RuntimeException("Despesa não encontrada!");
        }

        Despesa despesaAtual = despesaOptional.get();

        if (despesa.getValor() <= 0.0) {
            throw new RuntimeException("A despesa precisa ter valor positivo!");
        }
        despesaAtual.setValor(despesa.getValor());

        if (despesa.getTipoDespesa() != null) {
            despesaAtual.setTipoDespesa(despesa.getTipoDespesa());
        }

        if (despesa.getNomeDespesa() != null) {
            despesaAtual.setNomeDespesa(despesa.getNomeDespesa());
        }

        if (despesa.getDataGasto() != null) {
            despesaAtual.setDataGasto(despesa.getDataGasto());
        }

        return despesaRepository.save(despesaAtual);
    }

    public Despesa buscarPorId(Long id){
        Optional<Despesa> despesaOptional = despesaRepository.findById(id);
        if (despesaOptional.isPresent()){
            return despesaOptional.get();
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }

    public List<Despesa> buscarTodasDespesas(){
        return despesaRepository.findAll();
    }

    public void excluirDespesas(Long id){
        Optional<Despesa> despesaOptional = despesaRepository.findById(id);
        if (despesaOptional.isPresent()){
            despesaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Despesa não encontrada!");
        }
    }
}
