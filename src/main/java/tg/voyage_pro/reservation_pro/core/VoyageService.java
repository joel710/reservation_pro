package tg.voyage_pro.reservation_pro.core;

import java.util.List;
 
 

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
 
import tg.voyage_pro.reservation_pro.Model.VOYAGE;
import tg.voyage_pro.reservation_pro.database.VoyageRepository;
import tg.voyage_pro.reservation_pro.dto.VoyageDTO;
import tg.voyage_pro.reservation_pro.exceptions.VoyageNotFoundException;
import tg.voyage_pro.reservation_pro.mapperImpl.VoyageMapperImpl;


@Service
@Transactional
 
public class VoyageService {

    @Autowired
    private VoyageRepository vr ;

     private VoyageMapperImpl mapper = new VoyageMapperImpl() ;


 

   


    public VoyageDTO create(VoyageDTO voyage){
        return this.mapper.toDto(
                this.vr.save(this.mapper.toEntity(voyage)));
    }



    public List<VoyageDTO> getAll(){
        return this.mapper.toDtos(this.vr.findAllByOrderByDateVoyageDesc()) ;
    }
        


    public VoyageDTO update(Long idVoyage ,   VoyageDTO voyage){

        if(!this.vr.existsById(idVoyage)){
            throw new VoyageNotFoundException("Aucun voyage n 'a ce numéro");
        }

        VOYAGE v = this.vr.findById(idVoyage).get() ;
         
        v.setDateVoyage(voyage.getDateVoyage());
        v.setDepartVoyage(voyage.getDepartVoyage());
        v.setArriveVoyage(voyage.getArriveVoyage());
        v.setIdVoyage(idVoyage);
        return this.mapper.toDto(this.vr.save(v)) ; 
        

        
 
    }

    public boolean delete(Long idVoyage){
        if(this.vr.existsById(idVoyage)){
            this.vr.deleteById(idVoyage);
            return true ; 
        }
        return false ; 
    }


    public  VOYAGE get(Long idVoyage){
        return this.vr.findById(idVoyage).orElse(null);

    }
}
