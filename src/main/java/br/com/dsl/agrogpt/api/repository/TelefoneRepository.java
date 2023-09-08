package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
