package week3.day2;

public class SubClass extends SuperClass{
	
	public void MethodOverride() {
		System.out.println("super class method");
	}

	public void Operation(int a, int b)
	{
		System.out.println(a*b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass SC=new SubClass();
		SC.MethodOverride();
		SC.Operation(10, 8);

	}

}
