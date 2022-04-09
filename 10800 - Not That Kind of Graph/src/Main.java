import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Main {

	 

	
	

	
	public static void main(String[] args) throws IOException {

//		 InputStream inputStream = System.in;
		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  		reader.readLine();
			 String serie;
			 while((serie = reader.readLine()) != null)
			 {
				 int curve  = 0;
				 char df = 0 ;
				 int maxCurve = 0;
				 char[][] graph = new char[51][51];
				 for (int i = 0; i < graph.length; i++) {
					Arrays.fill(graph[i], (char)0);
				}
				 for (int i = 0; i < serie.length(); i++) {
					
					 if(serie.charAt(i) == 'R')
					 {
						 df = '\\';
						 curve++;

					 }
					 
					 if(serie.charAt(i)== 'F')

					 {
						 df  = '/';
						 curve--;
						 
					 }
					 
					 if(serie.charAt(i) == 'C')

					 {
						 df  = '_';
						 
					 }
					 
					 
					 graph[curve][i] = df ;
					 
					 if(curve > maxCurve)
						 maxCurve = curve;
					 
					 
					 
					 
					 
				}
				 	
				 System.out.println(Arrays.deepToString(graph).replace("]", "\n"));
				 

				 for (int i = 0; i < maxCurve; i++) {
					
					 for (int j = 0; j < serie.length(); j++) {
						 
						 if(graph[i][j] == (char)0)
						System.out.print(" ");
						 else
							 System.out.print(graph[i][j]);
					}
					 System.out.println();
				 }
				 
			 }
		
		
		
		


		reader.close();
	}

}
