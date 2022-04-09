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
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;






public class Main {




		
	


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


		reader.readLine();
		String line = null;
		while(!(line = reader.readLine()).equals("___________"))
		{
			int ascii = 0;
			//System.out.println(line);
			boolean afterPoint = false;
			for (int i = 2; line.charAt(i) != '|' ; i++) {
				
				if(line.charAt(i) == '.')
					afterPoint = true;
					
				if(line.charAt(i) == 'o')		
				{
					ascii += Math.pow(2, 8 - (afterPoint ? i - 1 : i) );
				}
				

			}
			
			System.out.print((char)ascii);
		}
		



			

		

		reader.close();
		//writer.close();
	}

}
