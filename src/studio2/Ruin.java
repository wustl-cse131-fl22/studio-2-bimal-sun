package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("How much are you starting with?");
		double startAmount = in.nextDouble();
		System.out.println("What are the chances of winning today?");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit?");
		int winLimit = in.nextInt();
		double originalMoney = startAmount;
		
		double expectedRuin;
		double alpha = (1.0-winChance)/winChance;
		if(winChance == 0.5)
		{
			expectedRuin = (1.0 - (startAmount/winLimit));
		} else 
		{
			expectedRuin = ((Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1.0-Math.pow(alpha, winLimit)));
		}
		
		int countLoss = 0;
		for(int i = 0; i < 500; i++)
		{
			int count = 0;
			
		while((startAmount > 0) && (startAmount < winLimit))
		{
			double comp = Math.random();
			if(comp > (1.0 - winChance))
			{
				startAmount = startAmount + 1;
				
			} else 
			{
				startAmount = startAmount - 1;
				
			}
			count = count + 1;
	}
		if(startAmount <= 0)
		{
			System.out.println("Simulation " + (i+1) + ": " + count + " LOSE");
			countLoss = countLoss + 1;
			
		}
		if(startAmount >= winLimit)
		{
			System.out.println("Simulation " + (i+1) + ": " + count + " WIN");
		}
		startAmount = originalMoney;

		
	
}
		System.out.println("Ruin Rate from Simulation: " + countLoss/500.0 + " Expected Ruin Rate" + expectedRuin);
}
	
}