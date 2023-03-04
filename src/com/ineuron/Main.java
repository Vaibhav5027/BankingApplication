package com.ineuron;

import java.util.Scanner;

import com.ineuron.Service.Service;
import com.ineuron.factory.ServiceFactory;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);	
		Service service=ServiceFactory.getServiceBean();
		System.out.println("\t\t\tWelcome To Bank");	
		System.out.println();
		System.out.println();
		System.out.println("\t\t\tPlease Enter a Choice for");

		System.out.println("\t\t\t 1. Check Balance");
		System.out.println("\t\t\t 2. Widraw Money");
		System.out.println("\t\t\t 3. Diposite Amount");

		int choice=sc.nextInt();
		System.out.println("\t\t\t Enter Your UserName");

		if(choice>=4 || choice<1) {
			System.out.println("\t\t\tPlease Enter Right Choice");
		}
		String userName=sc.next();
		if(service.verifyUser(userName))

		{


			switch (choice) {
			case 1: 
				float balance=service.checkBalance(userName);
				System.out.println("\t\t\tYour Available Balance is :: " +balance);
				break;

			case 2: 
				System.out.println("\t\t\tEnter Amount to Widraw");
				float amount=sc.nextFloat();
				service.widrawAmount(userName, amount);
				break;	
			case 3:
				System.out.println("\t\t\tPlease Enter Amount To Be Deposited");
				float depoAmount=sc.nextFloat();
				String message=service.depositeAmount(userName, depoAmount);
				System.out.println(message);

				break;	
			default:
				System.out.println("\t\t\tApplication Error");
				break; 
			}
		}


	}

}
