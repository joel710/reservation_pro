package tg.voyage_pro.reservation_pro.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
 
import lombok.*;
 

import java.util.Date;
 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientDTO {
    private Long  idClient ;

    private String nomClient ;
    private String prenomClient ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateNaiss ;
    private String mailClient ;
    private String telClient ;
    private String sexeClient ;
    private String login ;
    private String password ;



}
