package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
}
