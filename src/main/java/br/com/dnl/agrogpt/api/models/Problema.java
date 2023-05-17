package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_problema")
public class Problema {

    @Column(name = "id_problema")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_problema", length = 100, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "ds_problema", length = 100, nullable = false)
    @NotBlank
    private String descricao;

    //private Empreendedor empreendedor;
    //private Avaliacao avaliacao;
}
