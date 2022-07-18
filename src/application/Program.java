package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-ou date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());	
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-ou date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());	
			
			String error = reservation.updateDate(checkin, checkout);
			if(error != null) {
				System.out.println("Erro in reservation: "+error);
			}else {	
				System.out.println("Reservation: "+reservation);
			}
		}
		
		
		sc.close();
		

	}

}
