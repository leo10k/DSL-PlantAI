package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Propriedade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
    Page<Propriedade> findByNameContaining(String nome, Pageable pageable);
}
