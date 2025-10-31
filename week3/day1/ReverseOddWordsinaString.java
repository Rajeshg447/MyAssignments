package week3.day1;

public class ReverseOddWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize the variable to a String
		String test = "I am a software tester"; 
		//Split the String using split function with space
		String[] split = test.split(" ");
		//traverse through the for loop and find the odd place words and reverse the odd place words
		for(int i=0;i<split.length;i++)
		{
			if(i%2!=0)
			{
				char[] charArray = split[i].toCharArray();
				int length1= charArray.length;
				for (int j = length1-1; j>=0; j--)
				{
					System.out.print(charArray[j]);
				}
				
			}
			else
			{
				System.out.print(split[i]);
			}
			System.out.print(" ");
		}
	}

}
