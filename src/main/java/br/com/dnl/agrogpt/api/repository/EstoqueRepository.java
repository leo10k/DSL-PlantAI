package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
