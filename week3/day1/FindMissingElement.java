package week3.day1;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {

		//Declaring array elements by using literls
		int a[]={1,4,3,2,8,6,7};  
		//sorting the array
		Arrays.sort(a); //{1,2,3,4,6,7,8};  
		/*
		 * for(int i=0;i<a.length;i++) { System.out.println(a[i]); }
		 */
		for (int i = 0; i<a.length-1; i++) {
			//iterating the array elements to find the missing number
			if(a[i]+1!=a[i+1])             
			{
				System.out.println(a[i]+1);
				break;
			}
			
			
		}
		
	}

}
