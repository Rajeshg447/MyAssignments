package week3.day1;

import java.util.Arrays;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//first array elements
		  int a[]={3,2,11,4,6,7}; 
		  //second array elements
          int b[]= {1,2,8,4,9,7}; 
          //sorting first array
          Arrays.sort(a);
          //sorting second array
          Arrays.sort(b);
          System.out.println("Duplicate values are");
        //using for loop to iterate the first array value one by one
          for (int i = 0; i < a.length; i++) {
        	//using for loop to iterate the second array value one by one
        	  for (int j = 0; j < b.length; j++) {
        		//comparing array values
				if(a[i]==b[j]) {
					//printing the duplicate values
					
					System.out.println(a[i]);
				}
			}
			
		}
	}

}
