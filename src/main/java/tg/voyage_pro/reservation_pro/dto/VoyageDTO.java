package tg.voyage_pro.reservation_pro.dto;

 
import lombok.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageDTO {
    private Long idVoyage ;
    private String  departVoyage ;
    private String arriveVoyage ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateVoyage ;
}
