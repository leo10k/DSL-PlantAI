package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.AvaliacaoController;
import br.com.dnl.agrogpt.api.controllers.EmpreendedorController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

@Data
@Entity
@Table(name = "dnl_tb_avaliacao")
public class Avaliacao {

    @Column(name = "id_avaliacao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_emp", length = 80, nullable = false)
    @NotBlank
    private Date dataAvalicao;

    @NotNull
    @Lob
    @Column(name = "img_avaliacao", nullable = false)
    private byte[] imagem;

    @Column(name = "st_avaliacao", length = 30, nullable = false)
    @NotBlank
    private String status;

    @Column(name = "ds_solucao", length = 150, nullable = false)
    @NotBlank
    private String solucao;

    public EntityModel<Avaliacao> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(AvaliacaoController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(AvaliacaoController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(AvaliacaoController.class).delete(id)).withRel("delete")
        );
    }


    //private Problema problema;

}
