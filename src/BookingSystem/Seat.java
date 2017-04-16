package BookingSystem;

/**
 * Created by Dennis on 14.04.2017.
 */
public class Seat {

    private int seatNumber;
    private String rowLetter;

    public Seat(int seatNumber, String rowLetter) {
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getRowLetter() {
        return rowLetter;
    }

}
