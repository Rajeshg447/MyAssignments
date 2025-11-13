package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementinList {

	public static void main(String[] args) {
		
		//Declare an array
		int array[]= {1, 2, 3, 4, 10, 6, 8};
		//Declare a list
		List<Integer> list= new ArrayList<Integer>();
		//add the elements in the array to the List through for loop
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		//print the list
		System.out.println(list);
		//sort the list
		Collections.sort(list);
		//print the list
		System.out.println(list);
		
		int number=1;
		
		for (int i = 0; i < list.size(); i++) {
			while (list.get(i)!=number) {
				//print the missing number
				System.out.println("Missing Element Is : "+number);
				//increment the number value by one 
				number++;
			}
			//increment the number value by one
			number++;
		}
	}

}
