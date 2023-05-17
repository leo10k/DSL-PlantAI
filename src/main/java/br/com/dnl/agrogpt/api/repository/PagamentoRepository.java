package br.com.dnl.agrogpt.api.repository;


import br.com.dnl.agrogpt.api.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
