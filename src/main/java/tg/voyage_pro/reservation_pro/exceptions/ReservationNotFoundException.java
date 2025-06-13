package tg.voyage_pro.reservation_pro.exceptions;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message){
        super(message);
    }

}
