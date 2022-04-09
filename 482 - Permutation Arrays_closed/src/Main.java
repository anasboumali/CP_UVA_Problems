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
		while(T-- > 0)
			
		{
			reader.readLine();
			String[] nbr = reader.readLine().split("\\s+");
			int[] permutation = new int[nbr.length];

			for (int i = 0; i < nbr.length; i++) {
				permutation[i] = Integer.parseInt( nbr[i]);
			}
			
			 nbr = reader.readLine().split("\\s+");
			float[] list  = new float[nbr.length];
			
			for (int i = 0; i < nbr.length; i++) {
				list[i] = Integer.parseInt( nbr[i]);
			}
			
			float[] newList  = new float[nbr.length];

			
			for (int i = 0; i < newList.length; i++) {
				
				newList[permutation[i]] = list[i]; 
			}
			
			
			
			System.out.println(Arrays.toString(newList));

		}
		
		
		//writer.close();
	
		
	}

}
