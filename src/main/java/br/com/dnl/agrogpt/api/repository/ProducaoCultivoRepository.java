package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.ProducaoCultivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoCultivoRepository extends JpaRepository<ProducaoCultivo, Long> {
}
