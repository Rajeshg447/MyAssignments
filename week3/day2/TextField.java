package week3.day2;
//creating a subclass TextField
public class TextField extends WebElement{
	//creating a method getText();
	public void getText() {
		System.out.println("get text----Text field class");
	}
public static void main(String[] args) {
	//creating a subclick object and calling the superclass and subclass methods
	TextField t1=new TextField();
	t1.getText();
	t1.click();
	t1.setText("Text field class");
}
}
