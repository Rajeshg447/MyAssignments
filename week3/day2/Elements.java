package week3.day2;

public class Elements extends Button {
public static void main(String[] args) {
	//Creating the subclass methods and calling subclass and super class methods
	Elements e1=new Elements();
	e1.click();
	e1.setText("Elements class");
	e1.Submit();
	
	
	Button b1=new Button();
	b1.click();
	b1.setText("Button sub class");
	b1.Submit();
	
	RadioButton rb= new RadioButton();
	rb.click();
	rb.setText("Radio button object");
	rb.selectRadioButton();
	
	CheckBoxButton cBB=new CheckBoxButton();
	cBB.click();
	cBB.setText("CheckBoxButton object");
	cBB.Submit();
	cBB.clickCheckButton();
	
	TextField t1=new TextField();
	t1.click();
	t1.setText("Text field class");
	t1.getText();
	
}
}
