package week3.day2;

public class LoginPage extends BasePage{
	@Override
	public void performCommonTasks() {
		System.out.println("Common tasks are not performed");
	}

	public static void main(String[] args) {
		LoginPage L1= new LoginPage();
		L1.performCommonTasks();
		L1.clickElement();
		L1.findElement();
		L1.enterText();
		
	}

}
