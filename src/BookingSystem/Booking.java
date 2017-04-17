package BookingSystem;

import java.util.Date;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Booking {

    private double price;
    private Customer customer;

    public Booking(Customer customer) {
        this.customer = customer;
    }
    /* geplante Methoden - Teilimplementiert
    private double calcPrice(Schedule schedule){
        double price = 0;
        this.price = price;
        return price;
    }

    public Screening getScreening(String movieName, Date date, String rowLetter, int seatNumber ){
        Screening screening = new Screening();
        return screening;
    }

    public double getPrice(){
        double price = 0;
        this.price = price;
        return price;
    }
    */
}