package tg.voyage_pro.reservation_pro.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;
 
 
import tg.voyage_pro.reservation_pro.Model.TYPE_BILLET;
import tg.voyage_pro.reservation_pro.dto.TypeBilletDTO;
import tg.voyage_pro.reservation_pro.mappers.TypeBilletMapper;


 
public class TypeBilletImpl implements TypeBilletMapper {

    @Override
    public TYPE_BILLET toEntity( TypeBilletDTO type) {
        return TYPE_BILLET.builder()
        .idTypeBillet(type.getIdTypeBillet())
        .libelleTypeBillet(type.getLibelleTypeBillet())
        .prixTypeBillet(type.getPrixTypeBillet())
        .build();
    }

    @Override
    public TypeBilletDTO toDto(TYPE_BILLET entity) {
        return TypeBilletDTO.builder()
        .idTypeBillet(entity.getIdTypeBillet())
        .libelleTypeBillet(entity.getLibelleTypeBillet())
        .prixTypeBillet(entity.getPrixTypeBillet())
        .build() ; 
    }

    @Override
    public List<TypeBilletDTO> toListDto(List<TYPE_BILLET> list) {
        return list.stream().map(x->
                TypeBilletDTO.builder()
                .idTypeBillet(x.getIdTypeBillet())
                .libelleTypeBillet(x.getLibelleTypeBillet())
                .prixTypeBillet(x.getPrixTypeBillet())
                .build()
        ).collect(Collectors.toList()) ; 
    }

}
