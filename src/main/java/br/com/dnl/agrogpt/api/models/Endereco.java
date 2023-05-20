package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_endereco")
@Builder
public class Endereco {

    @Column(name = "id_endereco")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_rua" ,nullable = false)
    @NotNull
    private Integer numero;

    @Column(name = "nm_rua", length = 150, nullable = false)
    @NotBlank
    private String rua;

    @Column(name = "nm_bairro", length = 80, nullable = false)
    @NotBlank
    private String bairro;

    @Column(name = "sg_estado", length = 2, nullable = false)
    @NotBlank
    private String estado;

    @Column(name = "nm_pais", length = 50, nullable = false)
    @NotBlank
    private String pais;

    @Column(name = "nr_cep", length = 8, nullable = false)
    @NotNull
    private Integer cep;

    @Column(name = "ds_complemento", length = 70)
    private String complemento;

    //private Propriedade propriedade;
}
