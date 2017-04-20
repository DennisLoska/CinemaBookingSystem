package BookingSystem;

import java.util.ArrayList;
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
        System.out.println("Möchten Sie alle Reservierungen löschen? (J/N):\n");
        Scanner sc = new Scanner(System.in);
        if (sc.next().toUpperCase().equals("J")) {
            deleteAll(rowLetter, seatNumbers);
        } else {
            deleteOneReservation(rowLetter);
        }
    }

    public void deleteAll(String rowLetter, List<Integer> seatNumbers) {
        for (int i = 0; i <= seatNumbers.size(); i++) {
            if (seatNumbers.size() == 0) break;
            for (int seat : seatNumbers) {
                screening.unReserveSeat(rowLetter, seat);
            }
            seatNumbers.remove(i);
            i--;
        }
        System.out.println("Ihre Reservierungen wurden erfolgreich gelöscht.\n");
    }

    public void deleteOneReservation(String rowLetter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Sitzreihe des zu löschenden Platzes an:\n ");
        rowLetter = sc.nextLine();
        System.out.println("Bitte geben Sie auch die Sitznummer an: \n");
        int seatNumber = sc.nextInt();
        screening.unReserveSeat(rowLetter, seatNumber);
        System.out.println("Ihre Reservierung für den Platz " + rowLetter + seatNumber + " wurde erfolgreich gelöscht.\n");
    }

    public void showOwnReservedSeats(List<Integer> customersReservedSeats, String rowLetter) {
        //TODO Liste von reservierten Sitzen printen
        if (customersReservedSeats.size() == 0) {
            System.out.println("Sie haben noch nichts reserviert!");
        } else {
            System.out.println("Sie haben folgende Sitze Reserviert: ");
            for (int i = 0; i < customersReservedSeats.size(); i++) {
                System.out.print(rowLetter + " " + customersReservedSeats.get(i) + "\t");
            }
        }
    }

    public double getPrice() {
        return price;
    }

}