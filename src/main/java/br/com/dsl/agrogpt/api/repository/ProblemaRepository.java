package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Problema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {
    Page<Problema> findByNomeContaining(String nome, Pageable pageable);
}
