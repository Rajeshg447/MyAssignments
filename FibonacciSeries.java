package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=1,n=8;
		for (int i = 0; i <= n; i++) {
			 	System.out.print(a+" ");
			 	int c=a+b;
			 	a=b;
			 	b=c;
		}
	}

}
