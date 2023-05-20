package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.ProducaoCultivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoCultivoRepository extends JpaRepository<ProducaoCultivo, Long> {
    Page<ProducaoCultivo> findByNomeContaining(String nome, Pageable pageable);
}
