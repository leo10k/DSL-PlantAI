package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_genero")
public class Genero {

    @Column(name = "id_genero")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_genero", length = 20, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "ds_genero", length = 20, nullable = false)
    private String pronome;

    //private Empreendedor empreendedor;

}
