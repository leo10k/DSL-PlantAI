package br.com.dsl.agrogpt.api.models;

import br.com.dsl.agrogpt.api.controllers.ClienteController;
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

import java.time.LocalDate;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Data
@Entity
@Table(name = "dsl_tb_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Column(name = "id_cliente")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_cliente", length = 80, nullable = false)
    @NotBlank
    @Size(max = 80)
    private String name;

    @Column(name= "ds_genero", length = 20)
    @Size(max = 20)
    private String genero;

    @Column(name = "ds_email", length = 150, nullable = false)
    @NotBlank @Email
    private String email;

    @Column(name = "nr_cpf")
    private Long cpf;

    @Column(name = "nr_cnpj")
    private Long cnpj;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "dt_cadastro", nullable = false)
    @NotNull
    private LocalDate dataCadastro;

    @Column(name = "st_cliente", nullable = false)
    @NotNull
    private char status;

    @OneToMany(mappedBy = "cliente")
    private List<Problema> problema;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Telefone telefone;


    public EntityModel<Cliente> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ClienteController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(ClienteController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).delete(id)).withRel("delete")
        );
    }
}
