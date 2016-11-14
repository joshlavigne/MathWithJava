package post1;
import java.math.*;

public class primeNumbers {
	public static void main(String[] args){
		//Setting variables
		int num1 = 1;
		int num2 = 15;
		boolean isPrime;
		
		//If num1 is bigger than num2, swap them
		if(num1 > num2){
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		
		//If num1 is even, add one (need to start loop with odd number)
		if(num1 % 2 == 0){
			num1 += 1;
		}
		
		//Loops to check if numbers are prime
		for(int i = num1; i < num2; i+=2){
			isPrime = true;
			//1 is not prime
			if(i == 1){
				isPrime = false;
			}
			for(int j = 3; j < (int)Math.sqrt(i); j+=2){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				System.out.println(i + " is prime!");
			}
		}
	}
}