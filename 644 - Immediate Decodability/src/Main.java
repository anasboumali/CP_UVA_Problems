import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class Main {

	 
	

	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		
		
		  	 String in;
		  	 List<String> list ;
		  	 int counter = 1;
			 while((in = reader.readLine() ) != null)
			 {	
				  
				 list = new ArrayList<>();
				 list.add(in);
				 
				 while(!(in = reader.readLine()).equals("9"))
						 list.add(in);
				 
				 boolean decodable = true;
				 for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.size(); j++) {
						
						if(i != j)
						if(list.get(i).startsWith(list.get(j)))
						{
						decodable = false;
						break;
						}
						
						
					}


					if(!decodable)
						break;
				}
				 
				 if(decodable)
						System.out.println("Set " + counter++ + " is immediately decodable");

				 else
						System.out.println("Set " + counter++ + " is not immediately decodable");

				 

			 }
		
		
		
		


		reader.close();
	}

}
