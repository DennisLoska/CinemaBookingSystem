package BookingSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dennis on 11.04.2017.
 */
public class MovieBookingSystem {

    private Customer customer = new Customer();
    private Schedule schedule = new Schedule();
    private Date date1 = new Date(Calendar.DAY_OF_YEAR);
    private String movieName;
    private String date;
    private String rowLetter;
    private int seatNumber;
    private int[] reservedSeats;
    private boolean adjoined = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieBookingSystem system = new MovieBookingSystem();
        system.createSystem();
        system.questionsToCustomer(sc, system);
        system.prepareReservation(sc, system);
    }

    private void createSystem() {
        Theater theater_1 = new Theater("Theater 1", 40, 2);
        Theater theater_2 = new BookingSystem.Theater("Theater 2", 150, 9);
        Theater theater_3 = new BookingSystem.Theater("Theater 3", 100, 8);
        Theater theater_4 = new Theater("Theater 4", 65, 5);
        Theater theater_5 = new BookingSystem.Theater("Theater 5", 340, 15);
        Theater theater_6 = new BookingSystem.Theater("Theater 6", 200, 13);
        Screening s1 = new Screening("GoodFilm", theater_1, date1);
        Screening s2 = new BookingSystem.Screening("BadFilm", theater_2, date1);
        Screening s3 = new BookingSystem.Screening("IntermediateFilm", theater_3, date1);
        Screening s4 = new Screening("NewFilm", theater_4, date1);
        Screening s5 = new BookingSystem.Screening("OldFilm", theater_5, date1);
        Screening s6 = new BookingSystem.Screening("ThisFilm", theater_6, date1);
        Screening s7 = new Screening("ThatFilm", theater_1, date1);
        Screening s8 = new BookingSystem.Screening("HappyFilm", theater_2, date1);
        Screening s9 = new BookingSystem.Screening("SadFilm", theater_3, date1);
        Screening s10 = new Screening("GoodFilm", theater_4, date1);
        Screening s11 = new BookingSystem.Screening("BadFilm", theater_5, date1);
        Screening s12 = new BookingSystem.Screening("IntermediateFilm", theater_6, date1);
        schedule.getScreenings().put(s1.getMovie(), s1);
        schedule.getScreenings().put(s2.getMovie(), s2);
        schedule.getScreenings().put(s3.getMovie(), s3);
        schedule.getScreenings().put(s4.getMovie(), s4);
        schedule.getScreenings().put(s5.getMovie(), s5);
        schedule.getScreenings().put(s6.getMovie(), s6);
        schedule.getScreenings().put(s7.getMovie(), s7);
        schedule.getScreenings().put(s8.getMovie(), s8);
        schedule.getScreenings().put(s9.getMovie(), s9);
        schedule.getScreenings().put(s10.getMovie(), s10);
        schedule.getScreenings().put(s11.getMovie(), s11);
        schedule.getScreenings().put(s12.getMovie(), s12);
    }

    private void questionsToCustomer(Scanner sc, MovieBookingSystem system) {
        System.out.println("Willkommen im Buchungssystem. Für welchen Film möchten Sie reservieren?");
        System.out.println("\nGoodFilm, BadFilm, IntermediateFilm, NewFilm, OldFilm, ThisFilm, ThatFilm, HappyFilm, SadFilm ");
        system.setMovieName(sc.nextLine());
        System.out.println("Bitte geben Sie das gewünschte Datum mit Uhrzeit an: ");
        system.setDate(sc.nextLine());
        System.out.println("Sie haben sich für " + system.getMovieName() + " entschieden.\nBitte geben Sie Ihre gewünschte Sitzreihe an (A-O): ");
        system.setRowLetter(sc.nextLine().toUpperCase());
        System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
        system.setSeatNumber(sc.nextInt());
        sc.nextLine();
        System.out.println("Bitte geben Sie Ihren vollständigen Namen an: ");
        system.getCustomer().setCustomerName(sc.nextLine());
        System.out.println("Bitte geben Sie Ihre Telefonnummer an (0303322345): ");
        system.getCustomer().setCustomerPhnNumber(sc.nextInt());
        sc.nextLine();
        //weiter geht es in der Methode "prepareReservation()"
    }

    private void prepareReservation(Scanner sc, MovieBookingSystem system) {
        while (true) {
            System.out.println("Möchten Sie einen weiteren Sitz buchen? (J/N): ");
            if (sc.next().toUpperCase().equals("J")) {
                System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
                int nextSeat = sc.nextInt();
                sc.nextLine();
                if (nextSeat == system.getSeatNumber() + 1 || nextSeat == system.getSeatNumber() - 1)
                    system.setAdjoined(true);
            } else if (sc.next().toUpperCase().equals("N")) {
                system.setAdjoined(false);
                if (system.bookMovie(system))
                    System.out.println("Die Reservierung war erfolgreich. Vielen Dank für Ihre Reservierung.");
                else
                    System.out.println("Leider war die Reservierung nicht erfolgreich. Bitte probieren Sie es noch einmal.");
                break;
            }
        }
    }

    private boolean bookMovie(MovieBookingSystem system) {
        //TODO adjoined überprüfen seatNumber oder reservedSeats
        Booking booking = new Booking(system.getCustomer(), system.getSchedule());
        return booking.findScreening(system.getMovieName(), system.getRowLetter(), system.getSeatNumber(), system.getDate1());
    }

    //einfache Getter- und Setter-Methoden
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(String rowLetter) {
        this.rowLetter = rowLetter;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAdjoined() {
        return adjoined;
    }

    public void setAdjoined(boolean adjoined) {
        this.adjoined = adjoined;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int[] getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int[] reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Date getDate1() {
        return date1;
    }
}
