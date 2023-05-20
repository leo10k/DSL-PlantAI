package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_genero")
@Builder
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
