package br.com.dsl.agrogpt.api.models;

import br.com.dsl.agrogpt.api.controllers.AvaliacaoController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dsl_tb_avaliacao")
@Builder
public class Avaliacao {

    @Column(name = "id_avaliacao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_avaliacao", length = 80, nullable = false)
    @NotNull
    private LocalDate dataAvaliacao;

    //@Lob
    @NotNull
    @Column(name = "img_avaliacao", nullable = false)
    //private byte[] imagem;
    private String imagem;

    @Column(name = "st_avaliacao", length = 30, nullable = false)
    @NotBlank
    private String status;

    @Column(name = "ds_solucao", length = 150, nullable = false)
    @NotBlank
    private String solucao;

    @Column(name = "ds_porcentagem", length = 150, nullable = false)
    @NotBlank
    private String porcentagem;

    @OneToOne
    private Parceiro parceiro;

    public EntityModel<Avaliacao> toEntityModel() {
        return EntityModel.of(
                this,
                //WebMvcLinkBuilder.linkTo(methodOn(AvaliacaoController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(AvaliacaoController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(AvaliacaoController.class).delete(id)).withRel("delete")
        );
    }
}
