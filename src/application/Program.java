package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = scan.nextInt();
	
		for(int i=1;i<=n;i++) {
			System.out.println("Product #"+i+" data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = scan.next().charAt(0);
			
			System.out.print("Name: ");
			String name = scan.next();
			System.out.print("Price: ");
//			scan.nextLine();
			double price = scan.nextDouble();
			
			if(type == 'i') {
				
				System.out.print("Customs fee: ");
				double cf = scan.nextDouble();
				
				Product p = new ImportedProduct(name, price, cf);
				list.add(p);
				
			}else if(type == 'u') {
				
				System.out.print("Manufactura date (DD/MM/YYYY): ");
				Date date = sdf.parse(scan.next());
				
				Product p = new UsedProduct(name, price, date);
				list.add(p);
				
			}else {
				
				Product p = new Product(name, price);
				list.add(p);
			}
		}
		
		System.out.println();
		
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
			
		scan.close();
	}
}
