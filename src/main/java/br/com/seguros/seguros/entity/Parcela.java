package br.com.seguros.seguros.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PARCELA")
@Data
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PREMIO")
    private BigDecimal premio;

    @Column(name = "FORMA_PAGAMENTO")
    private String formaPagamento;

    @Column(name = "DATA_PAGAMENTO")
    private Date dataPagamento;

    @Column(name = "DATA_PAGO")
    private Date dataPago;

    @Column(name = "JUROS")
    private BigDecimal juros;

    @Column(name = "SITUACAO")
    private String situacao;

    @Column(name = "DATA_CRIACAO_REGISTRO")
    private Date dataCriacaoRegistro;

    @Column(name = "DATA_ALTERACAO_REGISTRO")
    private Date dataAlteracaoRegistro;

    @Column(name = "USUARIO_ALTERACAO_REGISTRO")
    private Integer usuarioAlteracaoRegistro;

    @Column(name = "USUARIO_CRIACAO_REGISTRO")
    private Integer usuarioCriacaoRegistro;
}
