import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {




		
	


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		
		
		Set<String> dico = new HashSet<String>();
		String line = null;
		while(!(line = reader.readLine()).equals("#"))
		{
		dico.add(line);
		}
		int maxMatches  = Integer.MIN_VALUE;
		String message = null;
		String cipher = reader.readLine();
		StringBuilder sb = null ;
		for (int i = 0; i < 27; i++) {
			sb = new StringBuilder(cipher);
			for (int j = 0; j < sb.length(); j++) {
				
				int newchar = ((int)(sb.charAt(j) == ' ' ? 'A' - 1 : sb.charAt(j) ) + i) ;
				
			
				newchar = (char)('A' + (newchar  - 'A')%27);
				if(newchar > 'Z')
					newchar = ' ';
					
				sb.setCharAt(j,(char)newchar);
			}
			
			int matches = 0;
			
			for (String word : sb.toString().split("\\s+")) {
				
				if(dico.contains(word))
					matches++;
				
			}
			
			
			
			
			if(matches > maxMatches )
			{
				maxMatches = matches ;
				message = sb.toString();
			}
			
		} 
			String[] words  = message.split(" ");
		
			
		
				
				String result = "";
				int k = 0;
				while(k < words.length)
				{
							String ln = "";
							for (int len = words[k].length(); k < words.length && len <= 60; len += words[k].length()) {
							
								ln += words[k++] + " ";
					len++;
					if(k == words.length)
						break;
					
				}
					
						result += ln.trim() + ((k == words.length) ? "" : "\n" ) ;
							
				}
		
				System.out.println(result);

			
				
				
			
			
			
			
			
		

		
	//	


		

		reader.close();
		//writer.close();
	}

}
