package br.com.seguros.seguros.service;

import br.com.seguros.seguros.entity.Apolice;
import br.com.seguros.seguros.entity.Parcela;
import br.com.seguros.seguros.entity.dto.ApoliceDto;
import br.com.seguros.seguros.entity.dto.ParcelaDto;
import br.com.seguros.seguros.repository.ApoliceRepository;
import br.com.seguros.seguros.util.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApoliceService {

    @Autowired
    ApoliceRepository apoliceRepository;

    public void salvarApoliceService(ApoliceDto apoliceDto) throws ParseException {
        Apolice apolice = new Apolice();
        apolice.setId(apoliceDto.getId());
        apolice.setCpf(apoliceDto.getCpf());
        apolice.setDescricao(apoliceDto.getDescricao());
        apolice.setPremioTotal(apoliceDto.getPremioTotal());
        apolice.setSituacao(apoliceDto.getSituacao());
        apolice.setDataCriacaoRegistro(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        apolice.setUsuarioAlteracaoRegistro(apoliceDto.getUsuarioAlteracaoRegistro());
        apolice.setDataAlteracaoRegistro(ConvertDate.convertStringToDate(apoliceDto.getDataAlteracaoRegistro()));

        List<Parcela> parcelaList = new ArrayList<>();


        for (ParcelaDto parcelaDto : apoliceDto.getParcelas()) {
            Parcela parcela = new Parcela();
            parcela.setId(parcelaDto.getId());
            parcela.setPremio(parcelaDto.getPremio());
            parcela.setFormaPagamento(parcelaDto.getFormaPagamento());
            parcela.setDataPagamento(ConvertDate.convertStringToDate(parcelaDto.getDataPagamento()));
            parcela.setDataPago(ConvertDate.convertStringToDate(parcelaDto.getDataPago()));
            parcela.setJuros(parcelaDto.getJuros());
            parcela.setSituacao(parcelaDto.getSituacao());
            parcela.setDataCriacaoRegistro(ConvertDate.convertStringToDate(parcelaDto.getDataCriacaoRegistro()));
            parcela.setUsuarioAlteracaoRegistro(parcelaDto.getUsuarioAlteracaoRegistro());
            parcela.setUsuarioCriacaoRegistro(parcelaDto.getUsuarioCriacaoRegistro());
            parcelaList.add(parcela);
        }

        apolice.setParcelas(parcelaList);

        apoliceRepository.save(apolice);
    }

    public List<Apolice> buscarApoliceService() {
        return (List<Apolice>) apoliceRepository.findAll();
    }
}
