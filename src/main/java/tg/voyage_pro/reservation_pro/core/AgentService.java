package tg.voyage_pro.reservation_pro.core;



import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tg.voyage_pro.reservation_pro.Model.AGENT;
import tg.voyage_pro.reservation_pro.database.AgentRepository;

import java.util.List;
 

@Service
public class AgentService {


    private AgentRepository repo ;


    public  AGENT create( AGENT agent){
       return   this.repo.save(agent);
    }

    public List<AGENT>   all(){
        return this.repo.findAll()  ;
    }


    public AGENT update(Long id , AGENT agent){
        var a = this.repo.findById(id).orElse(null);
        if(a==null){
            return null ;
        }
        BeanUtils.copyProperties(agent , a);
        a.setIdAgent(id);
        return    this.repo.save(a);

    }



    public boolean delete(Long id){
        if(this.repo.existsById(id)){
                this.repo.deleteById(id) ;
                return true ;
        }
        return  false ;
    }
    public AGENT get(Long id){
        return this.repo.findById(id).orElse(null);
    }
}
