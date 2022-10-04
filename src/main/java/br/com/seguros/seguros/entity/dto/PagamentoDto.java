package br.com.seguros.seguros.entity.dto;

import br.com.seguros.seguros.entity.Parcela;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDto {

    private Long idApolice;
    private List<Parcela> idParcela;


}
