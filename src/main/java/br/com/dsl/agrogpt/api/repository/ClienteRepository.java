package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findByNameContaining(String nome, Pageable pageable);
}
