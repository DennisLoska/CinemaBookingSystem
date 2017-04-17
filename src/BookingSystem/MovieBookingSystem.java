package BookingSystem;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dennis on 11.04.2017.
 */
public class MovieBookingSystem {

    private Customer customer = new Customer();
    private Schedule schedule = new Schedule();
    private String movieName;
    private String date;
    private String rowLetter;
    private int seatNumber;
    private int[] reservedSeats = new int[20];
    private boolean adjoined = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieBookingSystem system = new MovieBookingSystem();
        system.createSystem();
        system.printQuestionsToCustomer(sc);
        system.prepareReservation(sc);
    }

    private void createSystem() {
        Theater theater_1 = new Theater("Theater 1", 40, 2);
        Theater theater_2 = new Theater("Theater 2", 150, 9);
        Theater theater_3 = new Theater("Theater 3", 100, 8);
        Theater theater_4 = new Theater("Theater 4", 65, 5);
        Theater theater_5 = new Theater("Theater 5", 340, 15);
        Theater theater_6 = new Theater("Theater 6", 200, 13);
        Screening s1 = new Screening("GoodFilm", theater_1, "01.05.2017 18:00:00");
        Screening s2 = new Screening("BadFilm", theater_2, "02.05.2017 19:00:00");
        Screening s3 = new Screening("EduFilm", theater_3, "03.05.2017 20:30:00");
        Screening s4 = new Screening("NewFilm", theater_4, "04.05.2017 17:30:00");
        Screening s5 = new Screening("OldFilm", theater_5, "05.05.2017 16:00:00");
        Screening s6 = new Screening("ThisFilm", theater_6, "01.05.2017 18:45:00");
        Screening s7 = new Screening("ThatFilm", theater_1, "02.05.2017 19:30:00");
        Screening s8 = new Screening("HappyFilm", theater_2, "02.05.2017 20:00:00");
        Screening s9 = new Screening("SadFilm", theater_3, "03.05.2017 21:45:00");
        Screening s10 = new Screening("GoodFilm", theater_4, "04.05.2017 22:45:00");
        Screening s11 = new Screening("BadFilm", theater_5, "05.05.2017 20:30:00");
        Screening s12 = new Screening("EduFilm", theater_6, "06.05.2017 21:00:00");
        schedule.getScreenings().put(s1.getMovie() + s1.getDateText(), s1);
        schedule.getScreenings().put(s2.getMovie() + s2.getDateText(), s2);
        schedule.getScreenings().put(s3.getMovie() + s3.getDateText(), s3);
        schedule.getScreenings().put(s4.getMovie() + s4.getDateText(), s4);
        schedule.getScreenings().put(s5.getMovie() + s5.getDateText(), s5);
        schedule.getScreenings().put(s6.getMovie() + s6.getDateText(), s6);
        schedule.getScreenings().put(s7.getMovie() + s7.getDateText(), s7);
        schedule.getScreenings().put(s8.getMovie() + s8.getDateText(), s8);
        schedule.getScreenings().put(s9.getMovie() + s9.getDateText(), s9);
        schedule.getScreenings().put(s10.getMovie() + s10.getDateText(), s10);
        schedule.getScreenings().put(s11.getMovie() + s11.getDateText(), s11);
        schedule.getScreenings().put(s12.getMovie() + s12.getDateText(), s12);
    }

    private void printQuestionsToCustomer(Scanner sc) {
        printWelcome(sc);
        if (sc.next().toUpperCase().equals("J")) {
            printSeatingPlan();
        } else {
            printSelectSeatAndRow();
        }
        //weiter geht es in der Methode "prepareReservation()"
    }

    private void printWelcome(Scanner sc) {
        System.out.println("Willkommen im Buchungssystem. Für welchen Film möchten Sie Plätze reservieren (\"Filmname\")?\n");
        //System.out.println("\nGoodFilm, BadFilm, NormalFilm, NewFilm, OldFilm, ThisFilm, ThatFilm, HappyFilm, SadFilm ");
        for (String key : schedule.getScreenings().keySet()) {
            System.out.println("Name: " + schedule.getScreenings().get(key).getMovie() + "\t\t\tDatum: " + schedule.getScreenings().get(key).getDateText());
        }
        setMovieName(sc.nextLine());
        System.out.println("Bitte geben Sie das gewünschte Datum mit Uhrzeit an (\"dd.MM.yyyy HH:mm:ss\"): ");
        setDate(sc.nextLine());
        System.out.println("Sie haben sich für \"" + getMovieName() + "\" entschieden.\nMöchten sie sich den Sitzplan anzeigen lassen? (J/N): ");
    }

    private void printSeatingPlan() {
        Screening screening = schedule.getScreenings().get(getMovieName() + getDate());
        int i = 1;
        for (Map.Entry<String, ?> entry : screening.getTheater().getSeats().entrySet()) {
            Seat seat = screening.getTheater().getSeats().get(entry.getKey());
            System.out.print(seat.getRowLetter() + seat.getSeatNumber() + " " + seat.isReserved() + "  ");
            if (i % 20 == 0) {
                System.out.println("\n");
            }
            i++;
        }
    }

    private void printSelectSeatAndRow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihre gewünschte Sitzreihe an (A-O): ");
        setRowLetter(sc.next().toUpperCase());
        System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
        setSeatNumber(sc.nextInt());
        sc.nextLine();
        System.out.println("Bitte geben Sie Ihren vollständigen Namen an (\"Max Mustermann\"): ");
        getCustomer().setCustomerName(sc.nextLine());
        System.out.println("Bitte geben Sie Ihre Telefonnummer an (0303322345): ");
        getCustomer().setCustomerPhnNumber(sc.nextInt());
        sc.reset();
    }

    private void prepareReservation(Scanner sc) {
        int i = 1;
        while (i <= 300) {
            System.out.println("Möchten Sie einen weiteren Sitz wählen? (J/N): ");
            if (sc.next().toUpperCase().equals("J")) {
                reserveManySeats(sc, i);
                sc.reset();
            } else {
                System.out.println("Ihre Reservierung wird bearbeitet...");
                if (bookMovie())
                    System.out.println("Die Reservierung war erfolgreich. Vielen Dank für Ihre Reservierung.");
                else
                    System.out.println("Leider war die Reservierung nicht erfolgreich. Bitte probieren Sie es noch einmal.");
                break;
            }
        }
    }

    private void reserveManySeats(Scanner sc, int i) {
        System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
        int nextSeat = sc.nextInt();
        i++;
        if (nextSeat == getSeatNumber() + 1 || nextSeat == getSeatNumber() - 1)
            setAdjoined(true);
        reservedSeats[0] = seatNumber;
        reservedSeats[i] = nextSeat;
    }

    private boolean bookMovie() {
        //TODO adjoined überprüfen seatNumber oder reservedSeats
        Booking booking;
        if (isAdjoined()) {
            booking = new Booking(getCustomer(), getSchedule());
            return booking.findScreening(getMovieName(), getRowLetter(), getReservedSeats(), getDate());
        } else
            booking = new Booking(getCustomer(), getSchedule());
        return booking.findScreening(getMovieName(), getRowLetter(), getSeatNumber(), getDate());
    }

    //einfache Getter- und Setter-Methoden
    private String getMovieName() {
        return movieName;
    }

    private void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

    private String getRowLetter() {
        return rowLetter;
    }

    private void setRowLetter(String rowLetter) {
        this.rowLetter = rowLetter;
    }

    private int getSeatNumber() {
        return seatNumber;
    }

    private void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    private boolean isAdjoined() {
        return adjoined;
    }

    private void setAdjoined(boolean adjoined) {
        this.adjoined = adjoined;
    }

    private Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private int[] getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int[] reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    private Schedule getSchedule() {
        return schedule;
    }
}
