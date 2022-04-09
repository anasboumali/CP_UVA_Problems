import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;






public class Main {

	

	public static void main(String[] args) throws IOException {

//		 InputStream inputStream = System.in;
		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  
		
		
			 String str_n;

			 int N , R;
			 int counter  = 1;
		
			
			 while(!(str_n = reader.readLine()).equals("0 0"))
			 {
			
				 N = Integer.parseInt(str_n.split("\\s+")[0]);
				 R = Integer.parseInt(str_n.split("\\s+")[1]);
				 
				 if( (int)Math.ceil(((float)N-R)/R) <= 26)
				 System.out.println("Case " +  counter++  + ": "   + (int)Math.ceil((float)(N-R)/R));
				 else
					 System.out.println("Case " +  counter++  + ": impossible");

				 	
				 	
				 	
				 	
		

			 }
		
		
		
		


		reader.close();
	}

}
