package br.com.dsl.agrogpt.api.models;

import br.com.dsl.agrogpt.api.controllers.ClienteController;
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

import java.util.List;

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

    //TODO {trocar isso e tirar duvida com samuel}
    @OneToMany(mappedBy = "parceiro")
    private List<Avaliacao> avaliacao;

    public EntityModel<Parceiro> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ClienteController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ClienteController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).delete(id)).withRel("delete")
        );
    }

}
