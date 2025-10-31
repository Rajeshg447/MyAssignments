package week3.day2;

public class LoginTestData extends TestData{
	//creating enterUsername() method
	public void enterUsername(){
		System.out.println("enter the username");
	}
	//creating enterPassword() method
	public void enterPassword() {
		System.out.println("enter the password");
	}
	public static void main(String[] args) {
		//creating object for class
		LoginTestData L1= new LoginTestData();
		//calling the method of subclass and superclass using subclass object
		L1.enterCredentials();
		L1.navigateToHomePage();
		L1.enterUsername();
		L1.enterPassword();
		TestData t1=new TestData();
		t1.enterCredentials();
		t1.navigateToHomePage();

}
}
