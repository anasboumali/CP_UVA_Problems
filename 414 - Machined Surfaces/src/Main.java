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
		
		int n ;
		while(true)
		{
			n = Integer.parseInt(reader.readLine());
			if(n == 0)
				break;
			
			int[] space = new int[n];
			int min = 100;
			for (int i = 0; i < space.length; i++) {
				int l = 0 ,r = 0 ;
				boolean closeL = false , closeR = false;
				char[] line = reader.readLine().toCharArray();
				for (int j = 1; j < line.length-1; j++) {
					
					if(!closeL && line[j] == ' ')
					{
						l = j;
						closeL = true;
					}
					
					
					if( !closeR && line[line.length - j-1] == ' ')
					{
						r = line.length - j;
						closeR  = true;
					}
					
			
					if( closeL && closeR)
						break;
					
				}
//				System.out.println("r  : " + r + " , l : " + l);
				space[i] = r - l;
				if( r - l < min )
					min = r - l;
				
				
				
				
				
			}
			
			int ans = 0;
			
			for (int i = 0; i < space.length; i++) 
				ans += space[i] - min ;
				
			System.out.println(ans);

				
			
			
			
		}

		
			
			
			
		

		
	//	


		

		reader.close();
		//writer.close();
	}

}
