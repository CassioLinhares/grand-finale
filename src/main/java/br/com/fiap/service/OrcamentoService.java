package br.com.fiap.service;

import br.com.fiap.model.Orcamento;
import br.com.fiap.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrcamentoService {

        @Autowired
        private OrcamentoRepository orcamentoRepository;

        public Orcamento cadastrar(Orcamento orcamento, Long id){
            Optional<Orcamento> orcamentoOptional = orcamentoRepository.findByNameOrcamentoAndIdUsuario(orcamento.getNomeOrcamento(), id);
            if (orcamentoOptional.isPresent()){
                throw new RuntimeException("Este nome de orçamento já esta em uso!");
            }

            if (orcamento.getValorOrcamento() <= 0) {
                throw new RuntimeException("O orcamento precisa ter o valor acima de zero!");
            }

            return orcamentoRepository.save(orcamento);
        }

        public Orcamento atualizar(Orcamento orcamento, Long id){
            Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);
            if (orcamentoOptional.isPresent()){
                Orcamento orcamentoAtual = orcamentoOptional.get();

                String novoNome = orcamento.getNomeOrcamento();
                String nomeAtual = orcamentoAtual.getNomeOrcamento();
                if (novoNome != null && !novoNome.equals(nomeAtual)){
                    if (orcamentoRepository.findByNameOrcamentoAndIdUsuario(novoNome, id).isPresent()){
                        throw new RuntimeException("Nome de orçamento já esta em uso!");
                    }
                    orcamentoAtual.setNomeOrcamento(orcamento.getNomeOrcamento());
                }
                orcamentoAtual.setTipoOrcamento(orcamento.getTipoOrcamento());
                orcamentoAtual.setDataInicio(orcamento.getDataInicio());
                orcamentoAtual.setDataFim(orcamento.getDataFim());
                orcamentoAtual.setValorOrcamento(orcamento.getValorOrcamento());

                return orcamentoRepository.save(orcamentoAtual);
            } else {
                throw new RuntimeException("Orcamento não encontrada!");
            }
        }

        public Orcamento buscarPorId(Orcamento orcamento, Long id){
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

        public void excluirOrcamento(Orcamento orcamento, Long id){
            Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);
            if (orcamentoOptional.isPresent()){
                orcamentoRepository.deleteById(id);
            } else {
                throw new RuntimeException("Orcamento não encontrado!");
            }
        }
    }


