package br.com.seguros.seguros.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelaDto {

    private Long id;
    private BigDecimal premio;
    private String formaPagamento;
    private String dataPagamento;
    private String dataPago;
    private BigDecimal juros;
    private String situacao;
    private String dataCriacaoRegistro;
    private String dataAlteracaoRegistro;
    private Integer usuarioAlteracaoRegistro;
    private Integer usuarioCriacaoRegistro;
}
