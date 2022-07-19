package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-ou date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-ou date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
	
			reservation.updateDate(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
		}catch(ParseException e) {
			System.out.println("Invalid date format!");
		}catch(DomainException e) {
			System.out.println("Error in reservatin: "+e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("unexpected error!");
		}
		
		sc.close();

	}
}
