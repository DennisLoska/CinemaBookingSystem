package BookingSystem;

import java.util.Date;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Booking {

    private double price;
    private Customer customer;
    private Schedule schedule;

    public Booking(Customer customer, Schedule schedule) {
        this.customer = customer;
        this.schedule = schedule;
    }

    private double calcPrice(Schedule schedule) {
        double price = 0;
        this.price = price;
        return price;
    }

    public boolean findScreening(String movieName, String rowLetter, int seatNumber, Date date) {
        //TODO if-else mit datum und uhrzeit
        Screening screening = schedule.getScreenings().get(movieName);
        return screening.reserveSeats(rowLetter, seatNumber);
    }

    public double getPrice() {
        double price = 0;
        this.price = price;
        return price;
    }

}