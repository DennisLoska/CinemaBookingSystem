package Test;

import BookingSystem.*;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dennis on 14.04.2017.
 */
public class MovieBookingSystemTest {

    MovieBookingSystem m1 = new MovieBookingSystem();
    Customer c1 = new Customer("Dennis Loska", 03033352351);
    Customer c2 = new Customer("Max Mustermann", 030745366);
    Customer c3 = new Customer("Martin Muster", 030125432);
    Customer c4 = new Customer("Friedrich d. Große", 0307645);
    Customer c5 = new Customer("Markus Müller", 0302343253);
    Customer c6 = new Customer("Peter Herrmann", 0305566);
    Theater theater_1 = new Theater("Theater 1", 40, 2);
    Theater theater_2 = new Theater("Theater 2", 150, 9);
    Theater theater_3 = new Theater("Theater 3", 100, 8);
    Theater theater_4 = new Theater("Theater 4", 65, 5);
    Screening s1 = new Screening("GoodFilm" + "01.05.2017 18:00:00", theater_1, "01.05.2017 18:00:00");
    Screening s2 = new Screening("BadFilm" + "02.05.2017 19:00:00", theater_2, "02.05.2017 19:00:00");
    Screening s3 = new Screening("EduFilm" + "03.05.2017 20:30:00", theater_3, "03.05.2017 20:30:00");
    Screening s4 = new Screening("NewFilm" + "04.05.2017 17:30:00", theater_4, "04.05.2017 17:30:00");
    Schedule schedule = new Schedule();
    Booking booking = new Booking(c1, schedule);

    @Test
    public void createCustomers() throws Exception {
        assertEquals("Dennis Loska", c1.getCustomerName());
        assertEquals(03033352351, c1.getCustomerPhnNumber());
    }

    @Test
    public void createTheaters() throws Exception {
        assertEquals(40, theater_1.getSeatAmount());
        assertEquals(2, theater_1.getRowAmount());
        assertEquals("Theater 1", theater_1.getTheaterName());
    }

    @Test
    public void fillSchedule() {
        assertEquals(4, schedule.getScreenings().size());
    }

    @Test
    public void makeReservation() {
        assertTrue(m1.bookMovie());
    }

    @Test
    public void deleteAllReservations() {
        makeReservation();
        booking.deleteAll("B", m1.getReservedSeats());
        assertEquals(0, m1.getReservedSeats().size());
    }

    @Test
    public void deleteONEReservation() {
        makeReservation();
        s4.unReserveSeat("B", 13);
        assertFalse(theater_4.getSeats().get("B13").isReserved());
    }

    @org.junit.Before
    public void setUp() throws Exception {
        m1.setDate("04.05.2017 17:30");
        m1.setMovieName("NewFilm");
        m1.setRowLetter("B");
        m1.setSeatNumber(12);
        m1.getReservedSeats().add(12);
        m1.getReservedSeats().add(13);
        m1.getReservedSeats().add(14);
        m1.setAdjoined(true);
        schedule.getScreenings().put(s1.getMovie(), s1);
        schedule.getScreenings().put(s2.getMovie(), s2);
        schedule.getScreenings().put(s3.getMovie(), s3);
        schedule.getScreenings().put(s4.getMovie(), s4);
        m1.setSchedule(schedule);
        m1.setBooking(booking);
    }

}