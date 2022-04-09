import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;






public class Main {

	

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		 // BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  
		 Scanner in  = new Scanner(inputStream);
		
		 in.nextLine();
			 int N;
			 int counter  = 1;
		
			
			 while(in.hasNext())
			 {
				 
				 List<Integer> list = new ArrayList<>();
				 N = in.nextInt();
				 
				 for (int i = 0; i < N; i++) {
					list.add(in.nextInt());
				}
					 
			
				 Collections.sort(list);	
				 
				 System.out.println("Case " +  counter++  + ": "   + list.get(list.size()/2));
			

				 	
				 	
				 	
				 	
		

			 }
		
		
		
		


	}

}
