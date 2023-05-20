package br.com.dnl.agrogpt.api.repository;

import br.com.dnl.agrogpt.api.models.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Page<Estoque> findByQtdProduzidaContaining(Integer qtdProduzida, Pageable pageable);
}
