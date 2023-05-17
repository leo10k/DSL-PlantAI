package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_prod_cultivo")
public class ProducaoCultivo {

    @Column(name = "id_prod_cultivo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_prod_cultivo", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "ds_prod_cultivo", nullable = false)
    @NotNull
    private String descricao;

    @Column(name = "qnt_prod_cultivo")
    private Integer quantidade;

    //private Propriedade propriedade;
}
