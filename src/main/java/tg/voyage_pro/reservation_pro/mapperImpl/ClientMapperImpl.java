package tg.voyage_pro.reservation_pro.mapperImpl;

import tg.voyage_pro.reservation_pro.Model.CLIENT;
import tg.voyage_pro.reservation_pro.dto.ClientDTO;
import tg.voyage_pro.reservation_pro.mappers.ClientMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapperImpl implements ClientMapper {
    public List<ClientDTO> toListDtos(List<CLIENT> list){

        return  list.stream().map(x->
                ClientDTO.builder().idClient(x.getIdClient())
                        .nomClient(x.getNomClient())
                        .prenomClient(x.getPrenomClient())
                        .dateNaiss(x.getDateNaiss())
                        .mailClient(x.getMailClient())
                        .sexeClient(x.getSexeClient())
                        .telClient(x.getTelClient())
                        .build()
        ).collect(Collectors.toList());
    }


    @Override
    public CLIENT toEntity(ClientDTO  x) {
        return  CLIENT.builder()
                .idClient(x.getIdClient())
                .nomClient(x.getNomClient())
                .prenomClient(x.getPrenomClient())
                .dateNaiss(x.getDateNaiss())
                .mailClient(x.getMailClient())
                .sexeClient(x.getSexeClient())
                .telClient(x.getTelClient())
                .build();
    }

    @Override
    public ClientDTO toDto(CLIENT  x) {
        return  ClientDTO.builder()
                .idClient(x.getIdClient())
                .nomClient(x.getNomClient())
                .prenomClient(x.getPrenomClient())
                .dateNaiss(x.getDateNaiss())
                .mailClient(x.getMailClient())
                .sexeClient(x.getSexeClient())
                .telClient(x.getTelClient())
                .build() ;
    }

    @Override
    public List<ClientDTO> toListDto(List<CLIENT> list) {
        return null;
    }

    @Override
    public ClientDTO toCustomDto(CLIENT c) {
        return null;
    }

    @Override
    public List<ClientDTO> toCustomDtos(List<CLIENT> list) {
        return null;
    }
}
