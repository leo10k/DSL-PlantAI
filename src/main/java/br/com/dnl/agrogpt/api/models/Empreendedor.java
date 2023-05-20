package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.EmpreendedorController;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "dnl_tb_empreendedor")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empreendedor {

    @Column(name = "id_empreendedor")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_emp", length = 80, nullable = false)
    @NotBlank
    @Size(max = 80)
    private String name;

    @Column(name = "ds_email", length = 150, nullable = false)
    @NotBlank @Email
    private String email;

    @Column(name = "nr_cnpj", nullable = false)
    @NotNull
    private Long cnpj;

    @Column(name = "dt_nascimento", nullable = false)
    @NotNull
    private LocalDate dataNascimento;

    @Column(name = "dt_cadastro", nullable = false)
    @NotNull
    private LocalDate dataCadastro;

    @OneToOne
    private Empresa empresa;

    @OneToMany
    private List<Problema> problema;

    @OneToOne
    private Genero genero;

    @OneToOne
    private Telefone telefone;

    @OneToMany
    private List<Propriedade> propriedade;

    public EntityModel<Empreendedor> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(EmpreendedorController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(EmpreendedorController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(EmpreendedorController.class).delete(id)).withRel("delete")
        );
    }
}
