package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
