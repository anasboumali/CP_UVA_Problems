import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.ValidationEvent;




public class Main {


	
	
	 static class KWIC implements Comparable<KWIC>
	{
		 
		 
		 String title ;
		 String tag ;
		 int order ;
		 
		 
		 
		




		@Override
		public String toString() {
			return title;
		}





		public KWIC(String title, String tag, int order) {
			this.title = title;
			this.tag = tag;
			this.order = order;
		}





		@Override
		public int compareTo(KWIC kwic) {
			
			if( tag.compareTo(kwic.tag) < 0)
				return -1 ;
			
			if( tag.compareTo(kwic.tag) > 0)
				return 1 ;
			
			
			
			return order - kwic.order;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  int counter = 1;
		  String area ;
		  String line ;
		  
		  Set<String> ignoredWords = new HashSet<>();
		  
		  while(!(line = reader.readLine()).equals("::"))
		  {
  
			  ignoredWords.add(line);
			  
		  }

//		  System.out.println(ignoredWords);
		  
		  StringBuilder title = null;
		  PriorityQueue<KWIC> pq = new PriorityQueue<>();
		  
		  int order = 0;
		  while((line = reader.readLine()) != null)
		  {
			  title = new StringBuilder(line.toLowerCase());
			  StringTokenizer sToken = new StringTokenizer(line.toLowerCase());
			  
			  int fromIndex = 0;

			  while (sToken.hasMoreTokens()) {
				
				  String word = sToken.nextToken();
				  StringBuilder original = new StringBuilder(title) ;
				  if(!ignoredWords.contains(word.toLowerCase()))
				  {
					  fromIndex = title.indexOf(word , fromIndex);
					  
					  KWIC k = new KWIC(title.replace(fromIndex, fromIndex + word.length(), word.toUpperCase()).toString(),
							  word.toLowerCase(), order++); 
					  pq.add(k);
					  title = new StringBuilder(original);
					  fromIndex += word.length() ;
				  }
			}
			  
		  }		  
		  
		  
		  while(!pq.isEmpty())
			  System.out.println(pq.poll());
		  
		  
		  
			  
		  }
		


	

}
