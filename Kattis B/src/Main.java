import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;






public class Main {





	
		
	
	static int zeros(String array )
	{
		int  count = 0;
		for (int i = array.length() - 1 ; i >= 0 && array.charAt(i) == '0' ; i--) {
			count++;
		
		}
		
		return  count ;
	}

	public static void main(String[] args) throws IOException {

//		InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


		

	

		int T = Integer.parseInt(reader.readLine());
		int max = Integer.MIN_VALUE;
		int K  = 0;

		for (int i = 1; i <= T; i++) {
			
			  String s = Integer.toString(T, i);
			  int val = zeros(s);
			  
			  if(val > max)
			  {
				  max = val ;
				  K = i;
				  
			  }
			  
				  
			  
		}

		System.out.println(K);
		
			
			 
	
		    
				
	



			
		
	
			

		

		reader.close();
		//writer.close();
	}

}
