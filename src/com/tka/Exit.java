package com.tka;

public class Exit {
public static void exit()throws InterruptedException{
	
	System.out.print("Exiting System");
	int i=5;
	while(i!=0) {
		System.out.print(".");
		Thread.sleep(200);
		i--;
	}
	System.out.println();
	System.out.println("ThankYou For using Hotel Reservation System!!!");
}
}
