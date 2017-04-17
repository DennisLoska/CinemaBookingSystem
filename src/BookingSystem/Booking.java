package BookingSystem;

import java.util.List;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Booking {

    private double price;
    private final double PRICE_PER_SEAT = 8.99;
    private Customer customer;
    private Schedule schedule;

    public Booking(Customer customer, Schedule schedule) {
        this.customer = customer;
        this.schedule = schedule;
    }

    public void calcPrice(int seatAmount) {
        this.price = seatAmount * PRICE_PER_SEAT;
    }

    public boolean findScreening(String movieName, String rowLetter, int seatNumber, String date) {
        //TODO if-else mit datum und uhrzeit
        Screening screening = schedule.getScreenings().get(movieName + date);
        return screening.reserveSeats(rowLetter, seatNumber);
    }

    public boolean findScreening(String movieName, String rowLetter, List<Integer> seatNumbers, String date) {
        //TODO if-else mit datum
        Screening screening = schedule.getScreenings().get(movieName + date);
        for (int i = 0; i < seatNumbers.size() ; i++) {
            //System.out.println(screening.reserveSeats(rowLetter, seatNumbers.get(i)));
            screening.reserveSeats(rowLetter, seatNumbers.get(i));
        }
        return true;
    }

    public void deleteReservation(Screening screening){
        //TODO Reservierungen wieder löschen
    }

    public void showReservedSeats(){
        //TODO Liste von reservierten Sitzen printen
    }

    public double getPrice() {
        return price;
    }

}