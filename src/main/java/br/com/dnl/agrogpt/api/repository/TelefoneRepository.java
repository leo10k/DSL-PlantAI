package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
