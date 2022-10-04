package br.com.seguros.seguros.service;

import br.com.seguros.seguros.entity.Apolice;
import br.com.seguros.seguros.entity.Parcela;
import br.com.seguros.seguros.entity.dto.PagamentoDto;
import br.com.seguros.seguros.repository.ApoliceRepository;
import br.com.seguros.seguros.util.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
@Service
public class PagamentoService {


    public static final double JUROS_CARTAO = 3;
    public static final double JUROS_BOLETO = 1;
    public static final double JUROS_DINHEIRO = 5;
    @Autowired
    ApoliceRepository apoliceRepository;

    public void calcularPagamento(PagamentoDto pagamentoDto) throws ParseException {
        Optional<Apolice> apolice = Optional.of(new Apolice());
        apolice = apoliceRepository.findById(pagamentoDto.getIdApolice());

        if(apolice.isPresent()) {
            for (Parcela parcela : apolice.get().getParcelas()){
                String dataAtual = String.valueOf(LocalDate.now());
                parcela.getDataPagamento();

                int diasVencidos = (int) ChronoUnit.DAYS.between(parcela.getDataPagamento().toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.parse(dataAtual));

                if(diasVencidos == 0 ) {
                    parcela.setDataPago(ConvertDate.convertStringToDate(dataAtual));

                }else {
                    if(parcela.getFormaPagamento().equalsIgnoreCase("CARTAO")){
                        parcela.setJuros(BigDecimal.valueOf(diasVencidos * JUROS_CARTAO));
                        parcela.setPremio(parcela.getPremio().add(parcela.getJuros()));
                    }
                    if(parcela.getFormaPagamento().equalsIgnoreCase("DINHEIRO")){
                        parcela.setJuros(BigDecimal.valueOf(diasVencidos * JUROS_DINHEIRO));
                        parcela.setPremio(parcela.getPremio().add(parcela.getJuros()));
                    }
                    if(parcela.getFormaPagamento().equalsIgnoreCase("BOLETO")){
                        parcela.setJuros(BigDecimal.valueOf(diasVencidos * JUROS_BOLETO));
                        parcela.setPremio(parcela.getPremio().add(parcela.getJuros()));
                    }
                }
            }
            apoliceRepository.save(apolice.get());
        }
    }
}
