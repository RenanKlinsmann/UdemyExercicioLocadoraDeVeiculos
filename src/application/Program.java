package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelDeCarros;
import model.entities.Veiculos;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Digite os dados para o Aluguel");
		System.out.print("Modelo do Carro : ");
		String carModel = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		AluguelDeCarros cr = new AluguelDeCarros(start, finish, new Veiculos(carModel));
		
		System.out.print("Digite o pre�o por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Digite o pre�o por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento Basico: " + String.format("%.2f", cr.getFatura().getBasicPayment()));
		System.out.println("Taxa: " + String.format("%.2f", cr.getFatura().getTax()));
		System.out.println("Pagamento Total: " + String.format("%.2f", cr.getFatura().getTotalPayment()));
		
		sc.close();

	}

}
