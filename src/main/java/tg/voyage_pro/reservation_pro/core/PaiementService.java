package tg.voyage_pro.reservation_pro.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import tg.voyage_pro.reservation_pro.database.AgentRepository;
import tg.voyage_pro.reservation_pro.database.PaiementRepository;
import tg.voyage_pro.reservation_pro.database.ReservationRepository;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository pr ;

    @Autowired
    private AgentRepository ar ;

    @Autowired
    private ReservationRepository rr ;


    /* public PAIEMENT makePaiement(PAIEMENT paiement){
         var agent = this.ar.findById(paiement.getAgent().getIdAgent()).orElseThrow(()-> new RuntimeException("agent not found")) ;
         var reservation = this.reservtion
     }*/

}
