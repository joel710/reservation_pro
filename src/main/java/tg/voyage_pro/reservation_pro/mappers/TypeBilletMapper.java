package tg.voyage_pro.reservation_pro.mappers;

import java.util.List;

import tg.voyage_pro.reservation_pro.Model.TYPE_BILLET;
import tg.voyage_pro.reservation_pro.dto.TypeBilletDTO;

public interface TypeBilletMapper {
    TYPE_BILLET toEntity(TypeBilletDTO  dto);
    TypeBilletDTO toDto(TYPE_BILLET  entity);
   List<TypeBilletDTO> toListDto(List<TYPE_BILLET> list) ;

}
