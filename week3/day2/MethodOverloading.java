package week3.day2;

public class MethodOverloading {
public void reportStep(String msg,String status) {
	System.out.println("two arguments method message is " +msg+ " status is " +status);
}

public void reportStep(String msg,String status,boolean snap) {
	System.out.println("three arguments method  message is " +msg+ " status is " +status+ " snap is  "+snap);
	}


public static void main(String[] args) {
	MethodOverloading obj = new MethodOverloading();
	obj.reportStep("Report1", "Inactive");
	obj.reportStep("Report2", "Active", false);
}
}
