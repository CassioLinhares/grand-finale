package br.com.fiap.repository;

import br.com.fiap.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository<Despesa, Long> {
}
