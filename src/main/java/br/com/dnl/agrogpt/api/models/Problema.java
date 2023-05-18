package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.PagamentoController;
import br.com.dnl.agrogpt.api.controllers.ProblemaController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@Entity
@Table(name = "dnl_tb_problema")
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

    public EntityModel<Problema> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ProblemaController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ProblemaController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ProblemaController.class).delete(id)).withRel("delete")
        );
    }

    //private Empreendedor empreendedor;
    //private Avaliacao avaliacao;
}
