package br.com.dsl.agrogpt.api.models;

import br.com.dsl.agrogpt.api.controllers.ParceiroController;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "dsl_tb_parceiro")
@Builder
public class Parceiro {

    @Column(name = "id_parceiro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_parceiro", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "ds_parceiro", nullable = false)
    @NotBlank
    @Size(max = 255)
    private String descricao;

    @Column(name = "ds_email", length = 150, nullable = false)
    @NotBlank @Email
    @Size(max = 150)
    private String email;

    @Column(name = "ds_site", nullable = false)
    @NotBlank
    @Size(max = 255)
    private String site;

    @OneToOne(mappedBy = "parceiro")
    private Avaliacao avaliacao;

    public EntityModel<Parceiro> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ParceiroController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ParceiroController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ParceiroController.class).delete(id)).withRel("delete")
        );
    }

}
