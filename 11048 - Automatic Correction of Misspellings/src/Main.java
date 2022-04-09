import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;




public class Main {

	 
	
	static boolean isLetterMissing(String str1 , String str2)
	{
		
		for (int i = 0; i < str1.length() -1; i++) {
			
			if(str1.charAt(i) != str2.charAt(i))

			{
			//	System.out.println(str1 + " " + str2);
				if(str1.charAt(i) == str2.charAt(i+1) && str1.charAt(i+1) == str2.charAt(i) )
					if(str1.substring(i+2).equals(str2.substring(i+2)))
						return true;
					else
						return false;
				else
					return false;
					
					
			}
		}
		
		
		
		return false;
		
	}
	
	static boolean twoAdjacentLetterWrong(String str1 , String str2)
	{
		int i;
		for ( i = 0; i < Math.min(str1.length(), str2.length()) ; i++) {
			
			if(str1.charAt(i) != str2.charAt(i))

			{
				break;

					
			}
		}

	
		String minStr = str1.length() < str2.length() ? str1 : str2;
		String maxStr = str1.length() > str2.length() ? str1 : str2;
		
		if(minStr.substring(i).equals(maxStr.substring(i+1)))
			return true;
		else
			return false;
		
		
//		for (int j = i; j < maxStr.length(); j++) {
//			
//			if(maxStr.charAt(j) != minStr.charAt(j-1))
//				return false;
//			
//		}
//		
//		return true;
		
	}
	
	static boolean oneLetterIsWrong(String str1 , String str2)
	{
		int hamm = 0;
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i))
				hamm++;
		}
		
		return hamm == 1 ? true : false;
		
	}
	
	

	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  
		
		
			 int n ,q ;
			 String str_n;
			 String[] dico ;
			 while((str_n = reader.readLine()) != null)
			 {
				 	n = Integer.parseInt(str_n);
				 	
				 	dico = new String[n];
				 	
				 	for (int i = 0; i < dico.length; i++) {
						dico[i] = reader.readLine();
					}
				 	q = Integer.parseInt(reader.readLine());
				 	
				 	int minHammingDist = Integer.MAX_VALUE;
				 	String str_minHammingDist ;
				 
				 	for (int i = 0; i < q; i++) {
				 		String word = reader.readLine();
				 		
				 		boolean misspell = false;
				 		boolean correct = false;
				 		String correctOne = "";
				 		for (int j = 0; j < dico.length; j++) {
				 			
				 			if(Math.abs(word.length() - dico[j].length()) >= 2)
				 				continue;
				 			
				 			
				 			if(word.length() == dico[j].length())
				 			{
				 				
				 				
				 				 if(word.equals(dico[j]))
				 				 {
							 			System.out.println( word + " is correct" );
							 			 correct = true;
							 			 break;
				 				 }

				 				 else if(!misspell && ( oneLetterIsWrong(word, dico[j]) || isLetterMissing(word, dico[j])) )
				 					{misspell = true;
				 					correctOne = dico[j];}	
				 				 
				 					
				 			}else
				 			{
				 				if(!misspell &&  twoAdjacentLetterWrong(word ,dico[j]))
			 					{
				 					misspell = true;
			 					    correctOne = dico[j];
			 					  }	
				 				
				 			}
				 			
							 	
							 		
						}
				 		if(!correct)
				 		if(misspell)
				 			System.out.println( word + " is a misspelling of " + correctOne );
				 		else
				 			System.out.println( word + " is unknown" );

				 		
					}
				 	
				 	

			 }
		
		
		
		


		reader.close();
	}

}
