package tg.voyage_pro.reservation_pro.mapperImpl;

import tg.voyage_pro.reservation_pro.Model.VOYAGE;
import tg.voyage_pro.reservation_pro.dto.VoyageDTO;
import tg.voyage_pro.reservation_pro.mappers.VoyageMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VoyageMapperImpl  implements VoyageMapper {
    @Override
    public VOYAGE toEntity(VoyageDTO voyage) {
        return  VOYAGE.builder()
                .departVoyage( voyage.getDepartVoyage())
                .arriveVoyage(voyage.getArriveVoyage())
                .dateVoyage(voyage.getDateVoyage())

                .build();
    }

    @Override
    public VoyageDTO toDto(VOYAGE voyage) {
        return  VoyageDTO.builder()
                .idVoyage(voyage.getIdVoyage())
                .departVoyage( voyage.getDepartVoyage())
                .arriveVoyage(voyage.getArriveVoyage())
                .dateVoyage(voyage.getDateVoyage())

                .build();
    }

    @Override
    public List<VoyageDTO> toDtos(List<VOYAGE> listeVoyage) {
        return  listeVoyage.stream().map(voyage->
                VoyageDTO.builder()
                        .idVoyage(voyage.getIdVoyage())
                        .departVoyage( voyage.getDepartVoyage())
                        .arriveVoyage(voyage.getArriveVoyage())
                        .dateVoyage(voyage.getDateVoyage())

                        .build()
        ).collect(Collectors.toList());
    }
}
