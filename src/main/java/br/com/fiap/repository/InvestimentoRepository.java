package br.com.fiap.repository;

import br.com.fiap.model.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimentos, Long> {
}
