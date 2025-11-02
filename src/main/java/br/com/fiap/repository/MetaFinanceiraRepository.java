package br.com.fiap.repository;

import br.com.fiap.model.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetaFinanceiraRepository extends JpaRepository<MetaFinanceira, Long> {
        Optional<MetaFinanceira> findByNameMetaFinanceiraAndIdUsuario(String nome, Long id);
}
