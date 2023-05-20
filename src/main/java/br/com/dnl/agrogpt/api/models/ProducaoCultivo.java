package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.ProblemaController;
import br.com.dnl.agrogpt.api.controllers.ProducaoCultivoController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_prod_cultivo")
@Builder
public class ProducaoCultivo {

    @Column(name = "id_prod_cultivo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_prod_cultivo", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "ds_prod_cultivo", nullable = false)
    @NotNull
    private String descricao;

    @Column(name = "qnt_prod_cultivo")
    private Integer quantidade;

    @ManyToOne
    private Propriedade propriedade;

    public EntityModel<ProducaoCultivo> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ProducaoCultivoController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ProducaoCultivoController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ProducaoCultivoController.class).delete(id)).withRel("delete")
        );
    }
}
