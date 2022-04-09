import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.xml.bind.ValidationEvent;




public class Main {

	 

	

	
	public static void main(String[] args) throws IOException {

//		 InputStream inputStream = System.in;
		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  int T  = Integer.parseInt(reader.readLine()) ;
		  
		  String area ;
		  while(T-- > 0)
		  {
			  
			  StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			  
			  area = tokenizer.nextToken();
			  N  = Integer.parseInt(tokenizer.nextToken());
			  M  = Integer.parseInt(tokenizer.nextToken());
	
			  
			  
		
		  }


		reader.close();
	}

}
