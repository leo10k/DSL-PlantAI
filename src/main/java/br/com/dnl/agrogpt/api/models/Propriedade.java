package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "dnl_tb_propriedade")
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
    private Integer loteInicial;

    @Column(name = "lt_atual")
    private Integer loteAtual;

    @Column(name = "ds_solo", length = 200, nullable = false)
    @NotBlank
    private String descricaoSolo;

    @Column(name = "ds_clima", length = 100, nullable = false)
    @NotBlank
    private String descricaoClima;

    //private Empreendedor empreendedor;
    //private Endereco endereco;
    //private ProducaoCultivo producaoCultivo;
    //private Estoque;
}
