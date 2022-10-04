package br.com.seguros.seguros.controller;

import br.com.seguros.seguros.entity.dto.ApoliceDto;
import br.com.seguros.seguros.entity.dto.PagamentoDto;
import br.com.seguros.seguros.entity.dto.ParcelaDto;
import br.com.seguros.seguros.service.ApoliceService;
import br.com.seguros.seguros.service.PagamentoService;
import br.com.seguros.seguros.util.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping(path = "/apolice")
public class ApoliceController {

    @Autowired
    ApoliceService apoliceService;

    @Autowired
    PagamentoService pagamentoService;

    @RequestMapping(path = "/incluir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void incluirApolice(@RequestBody ApoliceDto apoliceDto) throws ParseException {
        apoliceService.salvarApoliceService(apoliceDto);
    }

    @RequestMapping(path = "/alterar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void alterarApolice(@RequestBody ApoliceDto apoliceDto) throws ParseException {
        apoliceDto.setDataAlteracaoRegistro(ConvertDate.convertDateToString(Date.from(LocalDate.now()
                .atStartOfDay(ZoneId.systemDefault()).toInstant())));
        for(ParcelaDto parcelaDto : apoliceDto.getParcelas()) {
            parcelaDto.setDataAlteracaoRegistro(ConvertDate.convertDateToString(Date.from(LocalDate.now()
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())));
        }
        apoliceService.salvarApoliceService(apoliceDto);
    }

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> listarApolice() {
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.buscarApoliceService());
    }

    @RequestMapping(path = "/pagamento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Pagamento(@RequestBody PagamentoDto pagamentoDto) throws ParseException {
        pagamentoService.calcularPagamento(pagamentoDto);

    }

}
