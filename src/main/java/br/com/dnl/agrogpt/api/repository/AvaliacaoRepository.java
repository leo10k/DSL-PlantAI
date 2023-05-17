package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
