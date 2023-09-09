package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String username);
    Page<Cliente> findByNameContaining(String nome, Pageable pageable);
}
