package tg.voyage_pro.reservation_pro.mappers;

 
import tg.voyage_pro.reservation_pro.Model.PAIEMENT;
 
import tg.voyage_pro.reservation_pro.dto.PaiementDTO;

import java.util.List;

public interface PaiementMapper {
     PAIEMENT toEntity( PaiementDTO  dto);
     PaiementDTO toDto( PAIEMENT  entity);
    List<PaiementDTO> toListDto(List<PAIEMENT> list) ;
}
