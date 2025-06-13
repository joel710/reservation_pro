package tg.voyage_pro.reservation_pro.mappers;

import java.util.List;

 
import tg.voyage_pro.reservation_pro.Model.CLIENT;
import tg.voyage_pro.reservation_pro.dto.ClientDTO;



public interface ClientMapper {
    CLIENT toEntity(ClientDTO clientDto);
    ClientDTO toDto(CLIENT client); 
    List<ClientDTO> toListDto(List<CLIENT> list) ; 

    ClientDTO toCustomDto(CLIENT c)   ;

    List<ClientDTO> toCustomDtos(List<CLIENT> list) ; 
    

}
