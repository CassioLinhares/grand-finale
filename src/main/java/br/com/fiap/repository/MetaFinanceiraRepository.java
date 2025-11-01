package br.com.fiap.repository;

import br.com.fiap.model.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaFinanceiraRepository extends JpaRepository<MetaFinanceira, Long> {
}
