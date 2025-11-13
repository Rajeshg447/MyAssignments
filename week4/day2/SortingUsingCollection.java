package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		//Declare an Array
		String array[]= {"HCL", "Wipro", "Aspire Systems", "CTS"};
		//Declare a List
		List<String> company = new ArrayList<String>();
		//Add the array values into List through for loop with add method
		for (int i = 0; i < array.length; i++) {
			company.add(array[i]);
		}
		//Print the List
		System.out.println(company);
		//Sort the collection
		Collections.sort(company);
		//Print the List
		System.out.println(company);
		
		//Declare the empty List
		List<String> list2 = new ArrayList<String>();
		//Reverse the values in the collection company through for loop and add the values in list2
		for (int i = company.size()-1; i>=0; i--) {
			
			list2.add(company.get(i));
			
			
		}
		//Print the list2
		System.out.println(list2);
	}

}
