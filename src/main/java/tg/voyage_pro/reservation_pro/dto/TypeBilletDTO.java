package tg.voyage_pro.reservation_pro.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeBilletDTO {
    private Long idTypeBillet ; 
    private String libelleTypeBillet ; 
    private Double prixTypeBillet ; 
}
