package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Avaliacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    Page<Avaliacao> findByStatusContaining(String status, Pageable pageable);
}
