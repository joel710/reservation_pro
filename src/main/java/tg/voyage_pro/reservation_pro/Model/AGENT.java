package tg.voyage_pro.reservation_pro.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="agent")
public class AGENT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agent")
    private Long idAgent ;
    @Column(name = "nom_agent" , length = 75 , nullable = false)
    private String nomAgent ;
    @Column(name = "prenom_agent" , length = 75)
    private String prenomAgent ;
    @Column(name = "sexe_agent" , nullable = false , length = 1)
    private String sexeAgent ;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/mm/yyyy" , timezone = "UTC")
    @Column(name = "date_naiss" , nullable = false)
    private Date dateNaiss ;
    @Column(name = "tel_agent" , nullable = false , length = 20)
    private String  telAgent ;
    @Column(name = "mail_agent" , nullable = false , length = 20)
    private String  mailAgent ;
    @OneToMany(mappedBy = "agent" , cascade = CascadeType.ALL)
    private List<PAIEMENT> paiementList ;

}
