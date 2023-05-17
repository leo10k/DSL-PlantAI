package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_telefone")
public class Telefone {

    @Column(name = "id_telefone")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_ddi", nullable = false)
    @NotNull
    private Integer ddi;

    @Column(name = "nr_ddd", nullable = false)
    @NotNull
    private Integer ddd;

    @Column(name = "nr_telefone", nullable = false)
    @NotNull
    private Integer telefone;

    //private Empreendedor empreendedor;

}
