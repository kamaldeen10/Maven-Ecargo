package E2EcargoProject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class f {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		int K=1;
		for (int i =0 ; i<4 ; i++)
		{
		
		for (int j=1 ; j<5-i ; j++)
		{
		System.out.print(K);
		System.out.print('\t');
		K++;

		}
		
		System.out.println();
		
		}
		*/
		
		/*
			
		//(CAPS A to Z)	 
		for(int i = 65; i <= 90; i++)   

		{  
		System.out.println(" The ASCII value of " + (char)i + "  =  " + i);  
		} 
		*/
		
	        // Creating a list of strings
	        List<String> list = Arrays.asList("Geeks", "for", "Geeks",
	                                          "GeeksQuiz", "for", "GeeksforGeeks");
	  
	       // System.out.println("The distinct elements are :");
	  
	        // Displaying the distinct elements in the list
	        // using Stream.distinct() method
	       // Stream<String> s =list.stream().distinct();
	      
	        
	        list.stream().distinct().forEachOrdered(System.out::println);
	    }

		/*
		
		String  a ="JAVA";
		String  b ="JAVA";
		
		if (a==b)
		{
			System.out.println("equal");
		}
		else
		{	
			System.out.println("Notequal");
		}
		
		
		String  A  = new String ("JAVA");
		String  B = new String ("JAVA");
		
		if (A==B)
		{
			System.out.println("Buffer equal");
			System.out.println(A);
		}
		else
		{	
			System.out.println("Buffer Notequal");
			System.out.println(B);
			System.out.println(A);
		}
		
		*/

	}

