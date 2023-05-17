package br.com.dnl.agrogpt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnl_tb_empresa")
public class Empresa {

    @Column(name = "id_empresa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_empresa", length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "nm_fantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "nr_cnpj", nullable = false)
    @NotNull
    private Long cnpj;

    @Column(name = "ds_email", length = 200, nullable = false)
    @NotBlank @Email
    private String email;

    @Column(name = "ds_descricao", length = 150, nullable = false)
    @NotBlank
    private String descricao;

    @Column(name = "st_empresa", length = 20, nullable = false)
    @NotBlank
    private String status;

    //private Empresa empresa;
    //private Pagamento pagamento;

}
