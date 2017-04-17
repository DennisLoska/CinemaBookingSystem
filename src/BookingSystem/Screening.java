package BookingSystem;

import java.util.Date;

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
    private Date date;

    public Screening(String movie, Theater theater, Date date) {
        this.movie = movie;
        this.theater = theater;
        this.date = date;
    }

    //einfache Get-Methoden
    public String getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public Date getDate() {
        return date;
    }

    //TODO Datum verändern, um einem Screening Stunde und Minuten zuzuweisen.
    public Date getDayHour(){
        return date;
    }
}
