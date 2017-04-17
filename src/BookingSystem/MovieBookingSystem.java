package BookingSystem;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dennis on 11.04.2017.
 */
public class MovieBookingSystem {

    private Customer customer = new Customer();
    private Schedule schedule = new Schedule();
    private Booking booking = new Booking(customer, schedule);
    private String movieName;
    private String date;
    private String rowLetter;
    private int seatNumber;
    private List<Integer> reservedSeats = new ArrayList<>();
    private boolean adjoined = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieBookingSystem system = new MovieBookingSystem();
        system.createSystem();
        system.mainMenu();
    }

    private void createSystem() {
        Theater theater_1 = new Theater("Theater 1", 40, 2);
        Theater theater_2 = new Theater("Theater 2", 150, 9);
        Theater theater_3 = new Theater("Theater 3", 100, 8);
        Theater theater_4 = new Theater("Theater 4", 65, 5);
        Theater theater_5 = new Theater("Theater 5", 280, 15);
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
        }
        printSelectSeatAndRow();
        prepareReservation(sc);
        backToMainMenu();
    }

    private void printWelcome(Scanner sc) {
        System.out.println("Willkommen im Buchungssystem. Für welchen Film möchten Sie Plätze reservieren (\"Filmname\")?\n");
        showScreenings();
        sc.nextLine();
        setMovieName(sc.nextLine());
        System.out.println("\nBitte geben Sie das gewünschte Datum mit Uhrzeit an (\"dd.MM.yyyy HH:mm\"): \n");
        setDate(sc.nextLine());
        System.out.println("\nSie haben sich für \"" + getMovieName() + "\" entschieden.\nMöchten sie sich den Sitzplan anzeigen lassen? (J/N): ");
    }

    private void printSeatingPlan() {
        Screening screening = schedule.getScreenings().get(getMovieName() + getDate());
        int i = 1;
        if (!(screening == null))
            for (Map.Entry<String, ?> entry : screening.getTheater().getSeats().entrySet()) {
                Seat seat = screening.getTheater().getSeats().get(entry.getKey());
                System.out.print(seat.getRowLetter() + seat.getSeatNumber() + " " + seat.isReserved() + "  ");
                if (i % 20 == 0) {
                    System.out.println("\n");
                }
                i++;
            }
        else {
            System.out.println("Sie haben noch keinen Film ausgewählt!\n");
        }
        backToMainMenu();
    }

    private void printSelectSeatAndRow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihre gewünschte Sitzreihe an (A-O): ");
        setRowLetter(sc.next().toUpperCase());
        System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
        setSeatNumber(sc.nextInt());
        sc.nextLine();
        reservedSeats.add(seatNumber);
        System.out.println("Bitte geben Sie Ihren vollständigen Namen an (\"Max Mustermann\"): ");
        getCustomer().setCustomerName(sc.nextLine());
        System.out.println("Bitte geben Sie Ihre Telefonnummer an (0303322345): ");
        getCustomer().setCustomerPhnNumber(sc.nextInt());
        sc.reset();
    }

    private void prepareReservation(Scanner sc) {
        int i = 1;
        while (i <= 20) {
            System.out.println("Möchten Sie einen weiteren Sitz wählen? (J/N): ");
            if (sc.next().toUpperCase().equals("J")) {
                i = reserveManySeats(sc, i);
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

    private int reserveManySeats(Scanner sc, int i) {
        System.out.println("Bitte geben Sie nun die gewünschte Sitznummer an (1-20): ");
        int nextSeat = sc.nextInt();
        i++;
        if (nextSeat == getSeatNumber() + 1 || nextSeat == getSeatNumber() - 1) {
            setAdjoined(true);
            setSeatNumber(nextSeat);
            reservedSeats.add(nextSeat);
        } else System.out.println("Sie können nur weitere benachbarte Sitze reservieren!");
        return i;
    }

    private boolean bookMovie() {
        if (isAdjoined() && getReservedSeats().size() > 1) {
            boolean reservationSuccessful = booking.findScreening(getMovieName(), getRowLetter(), getReservedSeats(), getDate());
            booking.calcPrice(getReservedSeats().size());
            System.out.println("Die Reservierung kostet " + booking.getPrice() + " Euro.");
            return reservationSuccessful;
        } else if (getReservedSeats().size() == 1) {
            boolean reservationSuccessful = booking.findScreening(getMovieName(), getRowLetter(), getSeatNumber(), getDate());
            booking.calcPrice(1);
            showReservationCost(booking);
            return reservationSuccessful;
        } else return false;
    }

    private void showScreeningsMenu() {
        for (String key : schedule.getScreenings().keySet()) {
            System.out.println("Name: " + schedule.getScreenings().get(key).getMovie() + "\t\t\tDatum: " + schedule.getScreenings().get(key).getDateText());
        }
        System.out.println("");
        backToMainMenu();
    }

    private void showScreenings() {
        for (String key : schedule.getScreenings().keySet()) {
            System.out.println("Name: " + schedule.getScreenings().get(key).getMovie() + "\t\t\tDatum: " + schedule.getScreenings().get(key).getDateText());
        }
        System.out.println("");
    }

    private void showReservationCost(Booking booking) {
        if (booking.getPrice() == 0)
            System.out.println("Sie haben noch nichts reserviert!\n");
        else System.out.println("Die Reservierung kostet " + booking.getPrice() + " Euro");
        backToMainMenu();
    }

    private void backToMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Möchten Sie zurück in das Hauptmenü? (J/N)");
        if (sc.next().toUpperCase().equals("J")) {
            mainMenu();
        } else System.exit(0);
    }

    private void mainMenu() {
        System.out.println("\nHauptmenü - Bitte wählen Sie eine Funktion:");
        System.out.println("(1) Reservierung tätigen \n(2) Filmtermine anzeigen" +
                "\n(3) Sitzplan anzeigen \n(4) Reservierung löschen \n(5) Reservierungskosten anzeigen ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                printQuestionsToCustomer(sc);
                break;
            case 2:
                showScreeningsMenu();
                break;
            case 3:
                printSeatingPlan();
                break;
            case 4:
                booking.deleteReservation();
                break;
            case 5:
                showReservationCost(booking);
                break;
        }
    }

    //einfache Getter- und Setter-Methoden
    private String getMovieName() {
        return movieName;
    }

    private void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    private String getDate() {
        return date + ":00";
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

    private List<Integer> getReservedSeats() {
        return reservedSeats;
    }

}
