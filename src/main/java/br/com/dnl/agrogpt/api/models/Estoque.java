package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_estoque")
public class Estoque {

    @Column(name = "id_estoque")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qtd_produzida", nullable = false)
    @NotNull
    private Integer qtd_produzida;

    @Column(name = "qtd_exportada", nullable = false)
    @NotNull
    private Integer qtd_exportada;

    @Column(name = "qtd_perdida", nullable = false)
    @NotNull
    private Integer qtd_perdida;

    //private Propriedade propriedade;

}
