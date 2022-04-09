import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;







public class Main {
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		

		
//		InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

//		Scanner in  = new Scanner(inputStream);
		
	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T  = Integer.parseInt(reader.readLine()) ;
		
		boolean first = true ;
		while(T-- > 0)
			
		{
			if(!first)
			{
				System.out.println();
			}

			reader.readLine();
			String[] nbr = reader.readLine().split("\\s+");
			int N = nbr.length;
			
			int[] permutation = new int[N];

			for (int i = 0; i < N ; i++) {
				
				permutation[i] = Integer.parseInt( nbr[i]);
			}
			
			String[] list  = new String[N];
			list = reader.readLine().split("\\s+");
		
			
			String[] newList  = new String[N];

			
			for (int i = 0; i < N; i++) {
				
				newList[permutation[i] - 1] = list[i]; 
			}
			
			
			
			
			for (int i = 0; i < newList.length; i++) {
				System.out.println(newList[i]);
				
			}
			first = false;

		}
		
		
		//writer.close();
	
		
	}

}
