package br.com.seguros.seguros.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APOLICE")
public class Apolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "SITUACAO")
    private String situacao;

    @Column(name = "PREMIO_TOTAL")
    private BigDecimal premioTotal;

    @Column(name = "USUARIO_CRIACAO_REGISTRO")
    private Integer usuarioCriacaoRegistro;

    @Column(name = "USUARIO_ALTERACAO_REGISTRO")
    private Integer usuarioAlteracaoRegistro;

    @Column(name = "DATA_CRIACAO_REGISTRO")
    private Date dataCriacaoRegistro;

    @Column(name = "DATA_ALTERACAO_REGISTRO")
    private Date dataAlteracaoRegistro;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Parcela> parcelas;

}
