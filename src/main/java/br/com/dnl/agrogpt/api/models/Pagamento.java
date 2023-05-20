package br.com.dnl.agrogpt.api.models;

import br.com.dnl.agrogpt.api.controllers.AvaliacaoController;
import br.com.dnl.agrogpt.api.controllers.PagamentoController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_pagamento")
public class Pagamento {

    @Column(name = "id_pagamento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_pagamento", nullable = false)
    @NotNull
    private LocalDate data;

    @Column(name = "preco_pagamento", nullable = false)
    @NotNull
    private Double preco;

    //private Empresa empresa;

    public EntityModel<Pagamento> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(PagamentoController.class).listAll(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(PagamentoController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(PagamentoController.class).delete(id)).withRel("delete")
        );
    }
}
