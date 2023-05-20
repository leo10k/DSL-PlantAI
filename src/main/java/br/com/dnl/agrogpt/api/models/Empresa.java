package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.EmpresaController;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dnl_tb_empresa")
public class Empresa {

    @Column(name = "id_empresa")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_empresa", length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "nm_fantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "nr_cnpj", nullable = false)
    @NotNull
    private Long cnpj;

    @Column(name = "ds_email", length = 200, nullable = false)
    @NotBlank @Email
    private String email;

    @Column(name = "ds_descricao", length = 150, nullable = false)
    @NotBlank
    private String descricao;

    @Column(name = "st_empresa", length = 20, nullable = false)
    @NotBlank
    private String status;

    @OneToOne
    private Empreendedor empreendedor;

    @OneToOne
    private Pagamento pagamento;


    public EntityModel<Empresa> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(EmpresaController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(EmpresaController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(EmpresaController.class).delete(id)).withRel("delete")

        );
    }
}
