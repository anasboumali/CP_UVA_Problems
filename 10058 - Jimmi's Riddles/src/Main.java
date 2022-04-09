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

	 

	
	

	
	public static void main(String[] args) throws IOException {

//		 InputStream inputStream = System.in;
		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		
			 String real;
			 String article = "(a|the)";
			 String noun = "(tom|jerry|goofy|mickey|jimmy|dog|cat|mouse)";
			 String verb = "(hate|love|know|like)(s?)";
			 String regex = "(" + article + "?\\s+" + noun + ")" + "\\s+" + "(and\\1)*)" ;
			 System.out.println(regex);
//			 Pattern p = Pattern.compile(regex);
//			 Matcher m = p.matcher("tom and jerry");

			 
//			 Pattern p = Pattern.compile("(\\+|-)?\\d+(((\\.\\d+)|((e|E)(\\+|-)?\\d+))|((\\.\\d+)((e|E)(\\+|-)?\\d+)))");
//			 while(!(real = reader.readLine().trim()).equals("*"))
//			 {
//				 	
//					 Matcher m = p.matcher(real);
//					 
//					 
//					 if(m.matches())	 
//				 System.out.println(real + " is legal.");
//					 else
//				 System.out.println(real + " is illegal.");
//						 
//				
//
//			 }
		
		
		
		


		reader.close();
	}

}
