package week4.day1;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
public class PrintIntersectionthroughList {

	public static void main(String[] args) {
		//declare first array
		int array1[]= {3, 2, 11, 4, 6, 7};
		
		//declare second array
		int array2[]= {1, 2, 8, 4, 9, 7};
		
		//declare the first list for first array values
		List<Integer> list1=new ArrayList<Integer>();
		
		//declare the second list for second  array values
		List<Integer> list2=new ArrayList<Integer>();
		
		//iteration to add the values into the list1 from firstarray
		for(int i=0;i<array1.length;i++)
		{
			list1.add(array1[i]);
		}
		//iteration to add the values into the list1 from firstarray
		for(int j=0;j<array2.length;j++)
		{
			list2.add(array2[j]);
		}
	System.out.println("common values present in both the arrays are");
	
	//iterate the first array values one by one
		for (int i = 0; i < list1.size(); i++) {
			//iterate the second array values one by one
			for (int j = 0; j < list2.size(); j++) {
				//check both values are same
				if(list1.get(i)==list2.get(j))
				{
					//if condition is true , it will print the below statement
					System.out.println(list1.get(i));
				}
				
			}
	}
	}

}
