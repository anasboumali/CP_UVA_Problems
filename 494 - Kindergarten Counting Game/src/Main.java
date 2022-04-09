import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Main {

	static  BufferedReader reader  ;
	static String currentToken ;
	static String padd  = "";
	static StringTokenizer tokenizer;
	static int offset = 0;
	static String smeech_expr ;
	
	

	
	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

			 reader = new BufferedReader(new InputStreamReader(inputStream));

		
			 String phrase ;
			 Pattern p = Pattern.compile(".*\\w+.*");
			 while((phrase = reader.readLine()) != null)
			 {
				 int count  = 0;
				 String[] words = phrase.split("\\W|\\d+");
				 for (int i = 0; i < words.length; i++) {
					 
					 Matcher m = p.matcher(words[i]);
					 if(m.matches())
						 count++;

				}
				 
				 System.out.println(count);
				

			 }
		
		
		
		


		reader.close();
	}

}
