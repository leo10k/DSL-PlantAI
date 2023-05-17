package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Empreendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Long> {
}
