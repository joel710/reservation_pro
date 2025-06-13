package tg.voyage_pro.reservation_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import tg.voyage_pro.reservation_pro.Model.RESERVATION;
import tg.voyage_pro.reservation_pro.core.ReservationService;
import tg.voyage_pro.reservation_pro.dto.ReservationDTO;

@RestController
@RequestMapping(path = "/tg/voyage_pro/reservation/auth/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service ; 


    @PostMapping(path="/create")
    public RESERVATION create(@RequestBody ReservationDTO reservation){
        return this.service.create(reservation) ; 
    }


    @GetMapping(path = "/all")
    public List<ReservationDTO> all(){
        return this.service.getAll() ;
    }

    @GetMapping(path = "/update")
    public ReservationDTO update(@RequestBody ReservationDTO reservation){
        return this.service.update(reservation) ; 
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.service.delete(id);
    }

}
