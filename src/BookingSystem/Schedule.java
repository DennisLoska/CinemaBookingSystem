package BookingSystem;

import java.util.HashMap;

/**
 * Created by Dennis on 11.04.2017.
 * <p>
 * Die Schedule-Klasse beinhaltet eine Liste von Screenings. Die Booking-Klasse kann auf die Schedule-Liste zugreifen,
 * um eine passende Reservierung anhand übergebener Informationen zu tätigen. Bei einer erfolgreichen Reservierung wird
 * die Reservierung im entsprechenden Screening der Schedule-Liste, welche alle Screenings enthält, gespeichert.
 * <p>
 * Ein Screening kann anhand des Keys bzw. dem Filmnamen ausgesucht werden.
 */
public class Schedule {
    //Es bietet sich an als Key z.B. den Filmnamen des jeweiligen Screenings zu wählen
    private HashMap<String, Screening> screenings = new HashMap<>();

    public HashMap<String, Screening> getScreenings() {
        return screenings;
    }
}
