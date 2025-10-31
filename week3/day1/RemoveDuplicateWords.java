package week3.day1;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize the given string to a variable
		String text = "We learn Java basics as part of java sessions in java week1";
		//initializing the count variable
		int count=0;
		//split the sentence into words using space
		String[] split = text.split(" ");
		//traverse through for loop and replace duplicate with space.
		for (int i = 0; i < split.length-1; i++) {
			for (int j = i+1; j < split.length-1; j++) {
				if (split[i].equalsIgnoreCase(split[j])) {
					
					split[j]= " ";
					
					count++;
				} 	
			}
		}
		//print the words if the count is greater than 1
		if (count>=1) {
			for (int i = 0; i < split.length; i++) {	
				System.out.print(split[i]+" ");					
			}
		}
	}

}
