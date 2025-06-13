package tg.voyage_pro.reservation_pro.core;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import tg.voyage_pro.reservation_pro.Model.CLIENT;
import tg.voyage_pro.reservation_pro.Model.RESERVATION;
import tg.voyage_pro.reservation_pro.Model.TYPE_BILLET;
import tg.voyage_pro.reservation_pro.Model.VOYAGE;
import tg.voyage_pro.reservation_pro.database.*;
import tg.voyage_pro.reservation_pro.dto.ReservationDTO;
import tg.voyage_pro.reservation_pro.exceptions.ClientNotFoundException;
import tg.voyage_pro.reservation_pro.exceptions.NullValueException;
import tg.voyage_pro.reservation_pro.exceptions.ReservationNotFoundException;
import tg.voyage_pro.reservation_pro.exceptions.VoyageNotFoundException;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository rsr ;

    @Autowired
    private ClientRepository cr ; 

    @Autowired
    private VoyageRepository vr ; 

    private TypeBilletRepository tbr;

    public  RESERVATION create(ReservationDTO reservation){

       CLIENT client = this.cr.findById(reservation.getIdClient()).orElseThrow(()-> new NullValueException("Either client is not found or null value")) ; 
       VOYAGE voyage = this.vr.findById( reservation.getIdVoyage()).orElseThrow(()-> new NullValueException( "Either voyage is not found or null value"));
       TYPE_BILLET type = this.tbr.findById(reservation.getIdTypeBillet()).orElseThrow( ()-> new NullValueException("Either type is not found or null value"));

       if(reservation.getDateReservation() == null){
            throw new NullValueException("Date must not be null") ; 
       }


        return  this.rsr.save(
            RESERVATION.builder()
            .client(client)
            .voyage(voyage)
            .typeBillet(type)
            .dateReservation(reservation.getDateReservation())
        
            .build()
        );
        

        
    }

    public boolean delete(Long IdReservation){

        if(!this.rsr.existsById(IdReservation)){
            return false ;
        }
        
        this.rsr.deleteById(IdReservation);
        return true ; 
    }


    
    
    public List<ReservationDTO> getAll(){
        return this.rsr.findAll().stream().map( x->
                ReservationDTO.builder()
                .build()
        ).collect(Collectors.toList());
    }

    public ReservationDTO get(Long idReservation){
        RESERVATION r =  this.rsr.findById(idReservation).orElseThrow(()-> new RuntimeException("Reservation not found")) ; 
        
        return ReservationDTO.builder()
            .idClient(r.getClient().getIdClient())
            .idVoyage(r.getVoyage().getIdVoyage())
            .idReservation(r.getIdReservation())
            .nomClient( r.getClient().getNomClient())
            .libelleVoyage(r.getVoyage().getDepartVoyage() +" - "+ r.getVoyage().getArriveVoyage())

            .mailClient(r.getClient().getMailClient())
            .dateReservation(r.getDateReservation()) 
            .idTypeBillet(r.getTypeBillet().getIdTypeBillet())
            .libelleTypeBillet(r.getTypeBillet().getIdTypeBillet())
            .build() ; 
    }


    public ReservationDTO update(ReservationDTO r){
        RESERVATION res =  this.rsr.findById(r.getIdReservation()).orElseThrow(()-> new  ReservationNotFoundException("Reservation not found")) ; 

        VOYAGE v = this.vr.findById(r.getIdVoyage()).orElseThrow(()-> new VoyageNotFoundException("voyage not found"));

        CLIENT c = this.cr.findById(r.getIdClient()).orElseThrow(()-> new ClientNotFoundException("Client not found"));

        res.setDateReservation(r.getDateReservation());
        res.setClient(c);
        res.setVoyage(v);

        this.rsr.save(res) ; 


        return ReservationDTO.builder()
            .idClient(c.getIdClient())
            .idReservation(res.getIdReservation())
            .idVoyage(v.getIdVoyage())
            .nomClient( res.getClient().getNomClient())
            .libelleVoyage(res.getVoyage().getDepartVoyage() +" - "+ res.getVoyage().getArriveVoyage())
            .mailClient(res.getClient().getMailClient())
            .dateReservation(res.getDateReservation()) 
            .idTypeBillet(res.getTypeBillet().getIdTypeBillet())
            .libelleTypeBillet(res.getTypeBillet().getIdTypeBillet())
            .build() ; 




    }
    
   
}
