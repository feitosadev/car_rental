package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner entry = new Scanner(System.in);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel.");
		System.out.print("Modelo do carro. ");
		String carModel = entry.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy HH:mm");
		LocalDateTime start = LocalDateTime.parse(entry.nextLine(), dateTimeFormatter);
		
		System.out.print("Retorno (dd/MM/yyyy HH:mm");
		LocalDateTime finish = LocalDateTime.parse(entry.nextLine(), dateTimeFormatter);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Entre com o preço por hora.");
		double pricePerHour = entry.nextDouble();
		
		System.out.print("Entre com o preço por dia.");
		double pricePerDay = entry.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento básico: " +String.format("%.2f", carRental.getInvoice().getBasicPayment()) );
		System.out.println("Imposto: " +String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Pagamento total: " +String.format("%.2f", carRental.getInvoice().getTotalPaymente()));
		
		entry.close();
	}
}