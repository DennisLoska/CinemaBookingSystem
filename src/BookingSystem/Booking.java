package BookingSystem;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Booking {

    private double price;
    private final double PRICE_PER_SEAT = 8.99;
    private Customer customer;
    private Schedule schedule;
    private Screening screening;

    public Booking(Customer customer, Schedule schedule) {
        this.customer = customer;
        this.schedule = schedule;
    }

    public void calcPrice(int seatAmount) {
        this.price = seatAmount * PRICE_PER_SEAT;
    }

    public boolean findScreening(String movieName, String rowLetter, int seatNumber, String date) {
        Screening screening = schedule.getScreenings().get(movieName + date);
        this.screening = screening;
        return screening.reserveSeats(rowLetter, seatNumber);
    }

    public boolean findScreening(String movieName, String rowLetter, List<Integer> seatNumbers, String date) {
        Screening screening = schedule.getScreenings().get(movieName + date);
        for (int i = 0; i < seatNumbers.size(); i++) {
            screening.reserveSeats(rowLetter, seatNumbers.get(i));
        }
        this.screening = screening;
        return true;
    }

    public void deleteReservation(String rowLetter, List<Integer> seatNumbers) {
        //TODO Reservierungen wieder löschen
        System.out.println("Möchten Sie alle Reservierungen löschen? (J/N):\n");
        Scanner sc = new Scanner(System.in);
        if (sc.next().toUpperCase().equals("J")) {
            deleteAll(rowLetter, seatNumbers);
        } else {
            System.out.println("Bitte geben Sie die Sitzreihe des zu löschenden Platzes an:\n ");
            rowLetter = sc.nextLine();
            sc.nextLine();
            System.out.println("Bitte geben Sie auch die Sitznummer an: \n");
            int seatNumber = sc.nextInt();
            screening.unReserveSeat(rowLetter, seatNumber);
            System.out.println("Ihre Reservierung für den Platz " + rowLetter + seatNumber + " wurde erfolgreich gelöscht.\n");
        }
    }

    public void deleteAll(String rowLetter, List<Integer> seatNumbers) {
        for (int i = 0; i < seatNumbers.size(); i++) {
            screening.unReserveSeat(rowLetter, seatNumbers.get(i));
        }
        System.out.println("Ihre Reservierungen wurden erfolgreich gelöscht.\n");
    }

    public void showReservedSeats() {
        //TODO Liste von reservierten Sitzen printen
    }

    public double getPrice() {
        return price;
    }

}