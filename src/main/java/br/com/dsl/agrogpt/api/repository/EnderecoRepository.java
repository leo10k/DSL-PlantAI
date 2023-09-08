package br.com.dsl.agrogpt.api.repository;

import br.com.dsl.agrogpt.api.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
