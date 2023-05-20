package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_estoque")
@Builder
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
