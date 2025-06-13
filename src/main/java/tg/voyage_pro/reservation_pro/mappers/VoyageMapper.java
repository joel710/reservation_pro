package tg.voyage_pro.reservation_pro.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import tg.voyage_pro.reservation_pro.Model.VOYAGE;
import tg.voyage_pro.reservation_pro.dto.VoyageDTO;

@Mapper(componentModel = "spring")
public interface VoyageMapper {

    VOYAGE toEntity(VoyageDTO voyage);

    VoyageDTO toDto(VOYAGE voyage);

    List<VoyageDTO> toDtos(List<VOYAGE> listeVoyage);
}
