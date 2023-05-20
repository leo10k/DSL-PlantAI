package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.EstoqueController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_estoque")
@Builder
public class Estoque {

    @Column(name = "id_estoque")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qtd_produzida", nullable = false)
    @NotNull
    private Integer qtdProduzida;

    @Column(name = "qtd_exportada", nullable = false)
    @NotNull
    private Integer qtdExportada;

    @Column(name = "qtd_perdida", nullable = false)
    @NotNull
    private Integer qtdPerdida;

    @ManyToOne
    private Propriedade propriedade;

    public EntityModel<Estoque> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(EstoqueController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(EstoqueController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(EstoqueController.class).delete(id)).withRel("delete")

        );
    }

}
