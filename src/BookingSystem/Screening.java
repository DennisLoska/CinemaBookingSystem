package BookingSystem;

import java.util.Date;

/**
 * Created by Dennis on 11.04.2017.
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

    public String getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public Date getDate() {
        return date;
    }
}
