package tg.voyage_pro.reservation_pro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
 
import tg.voyage_pro.reservation_pro.Model.AGENT;
import tg.voyage_pro.reservation_pro.Model.RESERVATION;

import java.util.Date;

public class PaiementDTO {



    private  String codePaiement ;

    private RESERVATION reservation ;

    private AGENT agent ;

 
    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "UTC")
    private Date datePaiement ;

}
