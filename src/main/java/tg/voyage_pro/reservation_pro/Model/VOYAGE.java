package tg.voyage_pro.reservation_pro.Model;

 
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="voyage")
public class VOYAGE implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voyage")
    private Long idVoyage ;
    @Column(name = "depart_voyage" , length = 100  , nullable = false)
    private String departVoyage  ;
    @Column(name = "arrive_voyage" , length = 100  , nullable = false)
    private String arriveVoyage ;
    @Column(name = "date_voyage" , nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateVoyage ;

    @OneToMany(mappedBy = "voyage" , cascade = CascadeType.ALL)
    private List<RESERVATION> reservations ; 


}
