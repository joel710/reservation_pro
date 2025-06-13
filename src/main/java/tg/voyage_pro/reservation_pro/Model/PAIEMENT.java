package tg.voyage_pro.reservation_pro.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "paiement")
@Setter
@Getter

public class PAIEMENT implements Serializable {

    @Id
    @Column(name = "code_paiement" , nullable = false , length = 10)
    private  String codePaiement ;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation"  , nullable = false)
    private RESERVATION reservation ;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent" , nullable = false)
    private AGENT agent ;

    @Column(name = "date_paiement" , nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "UTC")
    private Date datePaiement ;


}
