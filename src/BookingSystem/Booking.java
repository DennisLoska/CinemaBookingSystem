package BookingSystem;

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

    private double calcPrice(String movieName, String date) {
        return price;
    }

    public boolean findScreening(String movieName, String rowLetter, int seatNumber, String date) {
        //TODO if-else mit datum und uhrzeit und key in movieName+date ändern bzw +uhrzeit
        Screening screening = schedule.getScreenings().get(movieName + date);
        return screening.reserveSeats(rowLetter, seatNumber);
    }

    public boolean findScreening(String movieName, String rowLetter, int[] seatNumbers, String date) {
        //TODO if-else mit datum und uhrzeit und key in movieName+date ändern bzw +uhrzeit
        Screening screening = schedule.getScreenings().get(movieName + date);
        return screening.reserveSeats(rowLetter, seatNumbers[0]);
    }

    public double getPrice() {
        double price = 0;
        this.price = price;
        return price;
    }

}