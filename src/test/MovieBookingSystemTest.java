package Test;

import BookingSystem.Customer;
import BookingSystem.Schedule;
import BookingSystem.Screening;
import BookingSystem.Theater;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dennis on 14.04.2017.
 */
public class MovieBookingSystemTest {

    Customer c1 = new Customer("Dennis Loska", 03033352351);
    Customer c2 = new Customer("Max Mustermann", 030745366);
    Customer c3 = new Customer("Martin Muster", 030125432);
    Customer c4 = new Customer("Friedrich d. Große", 0307645);
    Customer c5 = new Customer("Markus Müller", 0302343253);
    Customer c6 = new Customer("Peter Herrmann", 0305566);

    Theater theater_1 = new Theater("Theater 1",40, 2);
    Theater theater_2 = new BookingSystem.Theater("Theater 2",50, 2);
    Theater theater_3 = new BookingSystem.Theater("Theater 3",300, 2);

    Date date1 = new Date(Calendar.DAY_OF_YEAR);

    Screening s1 = new Screening("GoodFilm", theater_1, date1);
    Screening s2 = new BookingSystem.Screening("BadFilm", theater_2, date1);
    Screening s3 = new BookingSystem.Screening("IntermediateFilm", theater_3, date1);

    @Test
    public void createCustomers() throws Exception {
        Customer c1 = new Customer("Dennis Loska", 03033352351);

        assertEquals("Dennis Loska", c1.getCustomerName());
        assertEquals(03033352351, c1.getCustomerPhnNumber());
    }

    @Test
    public void createTheaters() throws Exception {
        Theater theater_1 = new Theater("Theater 1",40, 2);

        assertEquals(40, theater_1.getSeatAmount());
        assertEquals(2, theater_1.getRowAmount());
        assertEquals("Theater 1", theater_1.getTheaterName());
    }

    @Test public void fillSchedule(){
        Schedule schedule = new Schedule();

        schedule.getScreenings().put(s1.getMovie(), s1);
        schedule.getScreenings().put(s2.getMovie(), s2);
        schedule.getScreenings().put(s3.getMovie(), s3);

        assertEquals(3, schedule.getScreenings().size());
    }

    @org.junit.Before
    public void setUp() throws Exception {

    }

}