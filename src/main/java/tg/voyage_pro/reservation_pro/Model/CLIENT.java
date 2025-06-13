package tg.voyage_pro.reservation_pro.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CLIENT implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long  idClient ;
    @Column(name = "nom_client", nullable = false , length = 100)
    private String nomClient ;
    @Column(name="prenom_client"  ,  nullable = false , length = 100)
    private String prenomClient ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy", timezone = "UTC")
    @Column(name = "date_naiss" , nullable = false)
    private Date dateNaiss ;
    @Column( name="mail_client" , nullable = false , length = 100)
    private String mailClient ;
    @Column(name="tel_client"  , nullable = false , length = 50)
    private String telClient ;
    @Column(name="sexe_client" , nullable = false)
    private String sexeClient ;
    @Column(name = "login" , nullable = false ,  length = 100)
    private String login ;
    @Column(name="password" , nullable = false , length = 50)
    private String password ;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private List<RESERVATION> reservations ; 






}
