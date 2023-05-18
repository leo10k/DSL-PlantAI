package br.com.dnl.agrogpt.api.repository;


import br.com.dnl.agrogpt.api.models.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Page<Pagamento> findByDataContaining(Date data, Pageable pageable);
}
