package tg.voyage_pro.reservation_pro.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 



@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class RESERVATION implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation ; 

    @ManyToOne 
    @JoinColumn(name="client_id")
    private CLIENT client ; 

    @ManyToOne 
    @JoinColumn(name = "voyage_id")
    private VOYAGE voyage ; 

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateReservation ; 

    @ManyToOne
    @JoinColumn(name = "type_billet_id" )
    private TYPE_BILLET typeBillet ;

    private List<PAIEMENT> paiementList ;






    

}
