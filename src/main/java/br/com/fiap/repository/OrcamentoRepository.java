package br.com.fiap.repository;

import br.com.fiap.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    Optional<Orcamento> findByNameOrcamentoAndIdUsuario(String nome, Long id);
}
