package tg.voyage_pro.reservation_pro.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AgentDTO {


    private Long idAgent ;

    private String nomAgent ;

    private String prenomAgent ;

    private String sexeAgent ;

    private Date dateNaiss ;

    private String  telAgent ;
}
