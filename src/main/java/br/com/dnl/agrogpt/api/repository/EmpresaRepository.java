package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
