package tg.voyage_pro.reservation_pro.mappers;


import org.mapstruct.Mapper;
import tg.voyage_pro.reservation_pro.Model.AGENT;
import tg.voyage_pro.reservation_pro.Model.CLIENT;
import tg.voyage_pro.reservation_pro.dto.AgentDTO;
import tg.voyage_pro.reservation_pro.dto.ClientDTO;

import java.util.List;

@Mapper(componentModel="spring")
public interface AgentMapper {
    AGENT toEntity( AgentDTO clientDto);
    ClientDTO toDto(CLIENT client);
    List<ClientDTO> toListDto(List<CLIENT> list) ;
}
