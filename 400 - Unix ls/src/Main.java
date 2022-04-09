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


	

	
	
	
	
	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  String line ;
		  

		  
		  int order = 0;
		  while((line = reader.readLine()) != null)
		  {
			  
			  
			  int N = Integer.parseInt(line);
			  String[] files = new String[N];
			  int max = 0;
			  for (int i = 0; i < files.length; i++) {
				files[i] = reader.readLine();
				
				if(files[i].length() > max)
					max = files[i].length();
			}
			  
			  int C = (int) (60 - max)/(max + 2) + 1;
//			  if(60%(max + 2) <= max) C++;
			  
			  if(C == 0) C++;
			  
//			  System.out.println("C : " + C);
			  Arrays.sort(files);
			  
			  
//			  System.out.println(Arrays.toString(files));
			  int R = (int) Math.ceil( files.length/(float)C);


			  for (int i = 0; i < 60; i++) {
				System.out.print("-");
			}
			  System.out.println();
			  
//			  System.out.println(R + " " + C);
			  for (int i = 0; i < R; i++) {
				  
				for (int j = 0; j < C; j++) {
					
//					System.out.println("j : " + j + " R : " + R);
					if(j*R + i < files.length)
						
					System.out.print(files[j*R + i]);
					
//					if(j*R + i != files.length -1 && j >= C - 1)
						if(j*R + i < files.length)
						{
							for (int k = 0; k < max - files[j*R + i].length(); k++) {
								System.out.print(" ");
							}
													
							if(((j+1)*R + i < files.length))
								System.out.print("  ");
							
						}

				}
				
				System.out.println();
				
				
			}
			  
			  
			  
			  
			  
		  }
		  
		  
			  
		  }
		


	

}
