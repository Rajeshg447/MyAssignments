package week1.day2;
 
public class IsPrime {

public static void main(String[] args) {
		int number=-2;
		int factor=0;
		for(int i=1;i<=number;i++) {
		
			if(number%i==0) {
				factor++;
			}	}
		
if(number<=0) {
	System.out.println("The number is invalid");
}
if (factor==2) {
	System.out.println("It is a prime number");
	
}
else if (factor>2) {
	System.out.println("It is not a prime number");
	
}
	}

}
