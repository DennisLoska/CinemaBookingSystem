package BookingSystem;

/**
 * Created by Dennis on 14.04.2017.
 *
 * Diese Klasse wird lediglich von der Theater-Klasse verwendet. Es werden viele Seat-Objekte in Theater-Objekten gespeichert, da ein Theater
 * mehrere Sitzplätze haben kann
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
