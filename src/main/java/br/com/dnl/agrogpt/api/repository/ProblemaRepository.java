package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Problema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {
}
