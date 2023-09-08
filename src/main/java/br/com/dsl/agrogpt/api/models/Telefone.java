package br.com.dsl.agrogpt.api.models;

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
@Table(name = "dsl_tb_telefone")
@Builder
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
    private Long telefone;

    @OneToOne
    private Cliente cliente;

}
