package Test;

import BookingSystem.Customer;
import BookingSystem.Schedule;
import BookingSystem.Screening;
import BookingSystem.Theater;

import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dennis on 14.04.2017.
 */
public class MovieBookingSystemTest {
    @Test
    public void main() throws Exception {

    }

    @Test
    public void bookMovie() throws Exception {

    }

    @org.junit.Before
    public void setUp() throws Exception {

        Customer c1 = new Customer("Dennis Loska", 0303335235l);
        Customer c2 = new Customer("Max Mustermann", 030745366l);
        Customer c3 = new Customer("Martin Muster", 030125432l);
        Customer c4 = new Customer("Friedrich d. Große", 0307645l);
        Customer c5 = new Customer("Markus Müller", 0302343253l);
        Customer c6 = new Customer("Peter Herrmann", 0305566l);

        Theater theater_1 = new Theater(40, 15);
        //BookingSystem.Theater theater_2 = new BookingSystem.Theater();
        //BookingSystem.Theater theater_3 = new BookingSystem.Theater();

        Schedule schedule = new Schedule();
        Date date1 = new Date(Calendar.DAY_OF_YEAR);

        Screening s1 = new Screening("GoodFilm", theater_1, date1);
        //BookingSystem.Screening s2 = new BookingSystem.Screening("BadFilm", theater_2, date1);
        //BookingSystem.Screening s3 = new BookingSystem.Screening("IntermediateFilm", theater_3, date1);

        schedule.getScreenings().put(s1.getMovie(), s1);
        //schedule.getScreenings().put(s2.getMovie(), s2);
        //schedule.getScreenings().put(s3.getMovie(), s3);

    }

}