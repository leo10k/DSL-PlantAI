package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findByNameContaining(String nome, Pageable pageable);
}
