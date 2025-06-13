package tg.voyage_pro.reservation_pro.dto;

import java.sql.Date;

 
import lombok.*;
 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationDTO {
    private Long idReservation ; 
    private Long idClient ; 
    private Long idVoyage ; 
    private Long idTypeBillet ; 
    private Long libelleTypeBillet ; 
    private String libelleVoyage; 
    private String nomClient ; 
    private String prenomClient ; 
    private String mailClient ; 
    private Date dateReservation ; 
}
