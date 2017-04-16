package BookingSystem;

import java.util.HashMap;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Schedule {

    private HashMap<String, Screening> screenings = new HashMap<>();

    public HashMap<String, Screening> getScreenings() {
        return screenings;
    }
}
