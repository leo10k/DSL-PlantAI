package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "dnl_tb_avaliacao")
public class Avaliacao {

    @Column(name = "id_avaliacao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_emp", length = 80, nullable = false)
    @NotBlank
    private Date dataAvalicao;

    @NotNull
    @Lob
    @Column(name = "img_avaliacao", nullable = false)
    private byte[] imagem;

    @Column(name = "st_avaliacao", length = 30, nullable = false)
    @NotBlank
    private String status;

    @Column(name = "ds_solucao", length = 150, nullable = false)
    @NotBlank
    private String solucao;


    //private Problema problema;

}
