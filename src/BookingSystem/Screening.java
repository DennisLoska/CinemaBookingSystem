package BookingSystem;

import java.text.SimpleDateFormat;

/**
 * Created by Dennis on 11.04.2017.
 * <p>
 * Ein Screening ist eine Vorstellung von einem Film. Jedes Screening hat somit eine bestimmte Uhrzeit bzw. Datum,
 * den Film bzw. den Filmnamen und den Theater-Raum, wo das Screening stattfindet. Jedes Screening Objekt verfügt
 * also über diese Attribute/Informationen. Zudem sind ähnlich wie bei der Assoziation zwischen der Theater- und
 * Seat-Klasse viele Screening-Objekte innerhalb eines Schedule-Objekts, bzw. Eine Schedule/Terminplan besteht aus
 * einer Liste von vielen einzelnen Screenings.
 * <p>
 * Die Informationen zu einem Screening können über das Schedule abgerufen werden.
 */
public class Screening {

    private Theater theater;
    private String movie;
    private String dateText;
    private SimpleDateFormat date;

    public Screening(String movie, Theater theater, String dateText) {
        this.movie = movie;
        this.theater = theater;
        this.dateText = dateText;
        date = new SimpleDateFormat(dateText);
    }

    //einfache Get-Methoden
    public String getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getDateText() {
        return dateText;
    }

    //TODO Datum verändern, um einem Screening Stunde und Minuten zuzuweisen.
    public SimpleDateFormat getDayHour() {
        return date;
    }

    public boolean reserveSeats(String rowLetter, int seatNumber) {
        String seatNr = Integer.toString(seatNumber);
        Seat preferedSeat = theater.getSeats().get(rowLetter+seatNr);
        System.out.println(preferedSeat.getRowLetter() + preferedSeat.getSeatNumber());
        if (!(preferedSeat.isReserved())) {
            preferedSeat.setReserved(true);
            return true;
        } else return false;
    }
}
