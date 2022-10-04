package br.com.seguros.seguros.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApoliceDto {

    private Long id;
    private String descricao;
    private Long cpf;
    private String situacao;
    private BigDecimal premioTotal;
    private String dataCriacaoRegistro;
    private String dataAlteracaoRegistro;
    private Integer usuarioCriacaoRegistro;
    private Integer usuarioAlteracaoRegistro;

    private List<ParcelaDto> parcelas;
}

