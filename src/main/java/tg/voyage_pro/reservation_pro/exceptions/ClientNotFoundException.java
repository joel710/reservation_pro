package tg.voyage_pro.reservation_pro.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String msg){
        super(msg);
    }
}
