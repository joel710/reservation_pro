package tg.voyage_pro.reservation_pro.controllers;

import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tg.voyage_pro.reservation_pro.Model.VOYAGE;
import tg.voyage_pro.reservation_pro.core.VoyageService;
import tg.voyage_pro.reservation_pro.dto.VoyageDTO;




@RestController
@RequestMapping(value = "/tg/voyage_pro/reservation/auth/voyage")
@CrossOrigin("*")
public class VoyageController {


    @Autowired
    private VoyageService vs ; 

    @PostMapping(value="/create")
    public ResponseEntity<?>  create(@RequestBody VoyageDTO voyage){
        var v = this.vs.create(voyage);
        return new ResponseEntity<>(v , HttpStatus.CREATED) ; 
    }

    @GetMapping(value = "/getAll")
    public  ResponseEntity<?> getAll(){

        List<VoyageDTO> listVoyage = this.vs.getAll() ;
        return new ResponseEntity<>( listVoyage , HttpStatus.OK) ; 
    }

    @GetMapping(value="/get/{idVoyage}")
    public ResponseEntity<?> get(@PathVariable Long idVoyage){
         VOYAGE v = this.vs.get(idVoyage);
        return new ResponseEntity<>(v , HttpStatus.FOUND);
    }

    @DeleteMapping(value="/delete/{idVoyage}")
    public ResponseEntity<?> delete(@PathVariable Long idVoyage){
        var response = this.vs.delete(idVoyage);
        return new ResponseEntity<>(response , HttpStatus.OK) ; 
    }


    @PutMapping(value="/update/{idVoyage}")
    public ResponseEntity<?> update(  @PathVariable Long idVoyage ,   @RequestBody   VoyageDTO voyage){
        var v = this.vs.update(idVoyage ,  voyage);
        return new ResponseEntity<>(v , HttpStatus.OK);
    }
}
