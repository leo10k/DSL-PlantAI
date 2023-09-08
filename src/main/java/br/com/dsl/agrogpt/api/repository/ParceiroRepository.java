package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Parceiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {

    Page<Parceiro> findByNameContaining(String nome, Pageable pageable);

}
