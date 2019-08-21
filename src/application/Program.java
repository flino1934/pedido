package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String [] args) throws HeadlessException, ParseException {
		 final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String name = JOptionPane.showInputDialog("Enter name Client");
		String email = JOptionPane.showInputDialog("E-mail: ");
		Date birthDate = sdf.parse(JOptionPane.showInputDialog("Birth date: dd/MM/yyyy"));
		
		Client client = new Client(name, email, birthDate);
		//Dados do cliente
		
		String[] select = {"PEDDING_PAYMENT","PROCESSING","SHIPPED","DELIVERED"};
		OrderStatus status = OrderStatus.valueOf((String) JOptionPane.showInputDialog(null, "Status... ","Select status ", JOptionPane.QUESTION_MESSAGE, null, select,select[0]));
		
		Order order = new Order(new Date(), status, client);
		//Status do pedido
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("How many items?"));
		
		for (int i = 1; i <=n; i++) {
			
			String productName = JOptionPane.showInputDialog("Product name:");
			double price = Double.parseDouble(JOptionPane.showInputDialog("Price: "));
			Product product = new Product(productName, price);
			int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantity: "));
			OrderItem orrderItem = new OrderItem(quantity, price, product);
			
			order.additem(orrderItem);
			//Sobre o pedido do item
		}
		
		System.out.println();
		System.out.println("Order Sumary: ");
		System.out.println(order);
		
	}

}
