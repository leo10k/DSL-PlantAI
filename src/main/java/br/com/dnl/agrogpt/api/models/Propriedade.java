package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.ProducaoCultivoController;
import br.com.dnl.agrogpt.api.controllers.PropriedadeController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_propriedade")
@Builder
public class Propriedade {

    @Column(name = "id_propriedade")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_propriedade", length = 80, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "lt_inicial", nullable = false)
    @NotNull
    private Double loteInicial;

    @Column(name = "lt_atual")
    private Double loteAtual;

    @Column(name = "ds_solo", length = 200, nullable = false)
    @NotBlank
    private String descricaoSolo;

    @Column(name = "ds_clima", length = 100, nullable = false)
    @NotBlank
    private String descricaoClima;

    @OneToOne
    private Empreendedor empreendedor;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propriedade")
    private List<ProducaoCultivo> producaoCultivo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "propriedade")
    private Estoque estoque;

    public EntityModel<Propriedade> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(PropriedadeController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(PropriedadeController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(PropriedadeController.class).delete(id)).withRel("delete")
        );
    }


}
