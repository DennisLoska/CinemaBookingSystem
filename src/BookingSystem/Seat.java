package BookingSystem;

/**
 * Created by Dennis on 14.04.2017.
 * <p>
 * Diese Klasse wird lediglich von der Theater-Klasse verwendet. Es werden viele Seat-Objekte in Theater-Objekten gespeichert, da ein Theater
 * mehrere Sitzplätze haben kann
 */
public class Seat {

    private int seatNumber;
    private String rowLetter;
    private boolean reserved = false;

    public Seat(int seatNumber, String rowLetter) {
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
    }

    //einfache Get-Methoden
    public int getSeatNumber() {
        return seatNumber;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
