package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Problema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {
    Page<Problema> findByNameContaining(String nome, Pageable pageable);
}
