package br.com.fiap.repository;

import br.com.fiap.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
        Optional<Investimento> findByNomeInvestimentoEConta_IdConta(String nome, Long id);
}
