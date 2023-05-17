package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "dnl_tb_pagamento")
public class Pagamento {

    @Column(name = "id_pagamento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_pagamento", nullable = false)
    @NotBlank
    private Date pagamento;

    @Column(name = "preco_pagamento", nullable = false)
    @NotBlank
    private Double preco;

    //private Empresa empresa;
}
