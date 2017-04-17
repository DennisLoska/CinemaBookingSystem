package BookingSystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dennis on 11.04.2017.
 * <p>
 * Diese Klasse ist dafür zuständig, Theater-Objekte anhand von bestimmten Parametern wie etwa der Anzahl der Sitze und Reihen
 * zu erstellen, wobei hierbei die maximale Anzahl an verfügbaren Reihen und Sitzen für einen Theater-Rauzm berücksichtigt werden.
 * Im for-Loop des Konstruktors wird deshalb darauf geachtet, bei zuviel angegebenen Reihen nicht zu viele Sitze zu erstellen, sondern
 * sich an die seatAmount und rowAmount zu halten.
 * <p>
 * Die erstellten Sitze werden als Seat-Objekte in einer ArrayList seats gespeichert, von wo aus die Reihe und die Sitznummer
 * abegerufen werden können. Dies geschieht Hauptsächlich die die Screening-Klasse.
 */
public class Theater {

    private String theaterName;
    private int seatAmount;
    private int rowAmount;
    private int seatsPerRow = 20;
    private final int MAX_ROWAMOUNT = 15;
    private final int MAX_SEATAMOUNT = 300;

    private String[] rowLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};

    private HashMap<String,Seat> seats = new HashMap<>();

    public Theater(String theaterName, int seatAmount, int rowAmount) {
        this.theaterName = theaterName;
        //Prüft, ob die Parameter mit der maximalen verfügbaren Anzahl von Sitzen und Reihen übereinstimmen
        if (seatAmount <= MAX_SEATAMOUNT)
            this.seatAmount = seatAmount;
        else System.out.println("The limit of seats is: " + MAX_SEATAMOUNT);
        if (rowAmount <= MAX_ROWAMOUNT)
            this.rowAmount = rowAmount;
        else System.out.println("The limit of rows is: " + MAX_ROWAMOUNT);

        //Prüft im äußeren Loop zunächst, ob es weitere Reihen gibt
        for (int j = 1; j <= rowAmount; j++) {
            //Wenn nächste Reihe vorhanden, werden solange Sitz-Objekte pro Reihe erstellt,
            // bis "seatsPerRow" erreicht ist
            for (int k = 1; k <= seatsPerRow; k++) {
                Seat seat;
                seat = new Seat(k, rowLetters[j - 1]);
                seats.put(rowLetters[j - 1]+k,seat);
                //System.out.println(seat.getRowLetter() + seat.getSeatNumber());
            }
            int seatCounter = seatsPerRow * j;
            //Beendet den Loop sofort, wenn die im Parameter angegebene Sitzanzahl erreicht wird
            if (seatCounter >= seatAmount)
                break;
        }
    }

    //einfache Getter- und Setter-Methoden
    public String getTheaterName() {
        return theaterName;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        if (seatAmount <= MAX_SEATAMOUNT)
            this.seatAmount = seatAmount;
        else System.out.println("The limit of seats is: " + MAX_SEATAMOUNT);
    }

    public int getRowAmount() {
        return rowAmount;
    }

    public void setRowAmount(int rowAmount) {
        if (rowAmount <= MAX_ROWAMOUNT)
            this.rowAmount = rowAmount;
        else System.out.println("The limit of rows is: " + MAX_ROWAMOUNT);
    }

    public HashMap<String,Seat> getSeats() {
        return seats;
    }
}