import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;






public class Main {





	
		
	


	public static void main(String[] args) throws IOException, ParseException {
	    //InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));




		int T = Integer.parseInt(reader.readLine());
		StringTokenizer sToken = null;
	while(T-- > 0)
	{
			
			sToken = new StringTokenizer(reader.readLine());
			String contestant = sToken.nextToken();
			
			 DateFormat formatter = new SimpleDateFormat("YYYY/MM/DD");
			 Date beganStudydate = formatter.parse(sToken.nextToken());
			 
			 Date borndate = formatter.parse(sToken.nextToken());

			System.out.println(contestant + " " + beganStudydate + " "+ borndate);

		    
				
	}

			
		

			

		

		reader.close();
		//writer.close();
	}

}
