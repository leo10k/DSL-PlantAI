package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.ProblemaController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "dnl_tb_problema")
@Builder
public class Problema {

    @Column(name = "id_problema")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_problema", length = 100, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "ds_problema", length = 100, nullable = false)
    @NotBlank
    private String descricao;

    @ManyToOne
    private Empreendedor empreendedor;

    @OneToOne
    private Avaliacao avaliacao;

    public EntityModel<Problema> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ProblemaController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ProblemaController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ProblemaController.class).delete(id)).withRel("delete")
        );
    }

}
