package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initializing the string name to variable
		String test="changeme";
		//To convert the string into the characters
		char[] charArray = test.toCharArray();
		//traverse through for loop and change the odd index to uppercase
		for(int i=0;i<charArray.length-1;i++)
		{
			if(i%2!=0) {
				charArray[i]= Character.toUpperCase(charArray[i]);
		}
			

	}
		System.out.println(charArray);

}
}
