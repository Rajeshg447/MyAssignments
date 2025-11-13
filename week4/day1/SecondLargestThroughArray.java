package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargestThroughArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare an Array
		int array[]= {3, 2, 11, 4, 6, 7};
		//Declare a List
		List<Integer> list = new ArrayList<Integer>();
		//Add the elements from the array to the list using for loop
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		//Print the List values
		System.out.println(list);
		//sort the values in the List
		Collections.sort(list);
		//find the size of the list
		int size = list.size();
		//print the size of the list
		System.out.println("Size of the list is "+size);
		
		//now print the second largest number using size-2 , Since the List size is 6 and the index starts for List from 0
		System.out.println(list.get(size-2));
	}

}
