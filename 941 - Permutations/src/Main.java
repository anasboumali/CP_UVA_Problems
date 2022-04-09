import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;






public class Main {

	
	static void swap(StringBuilder str , int i , int j)
	{
		char temp = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, temp);
	}
	 
	static void permute (StringBuilder str , int l , int r)
	{
		
		if(l == r)
			System.out.println(str);
		
		for (int i = l; i < r; i++) {
			
			swap(str ,l , i);
			permute(str, l+1, r);
			swap(str , l , i);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {

//		 InputStream inputStream = System.in;
		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  
		
		
			 String str_n;

			 
			permute(new StringBuilder("ABC"), 0, 3);
			 while((str_n = reader.readLine()) != null)
			 {
				// 	n = Integer.parseInt(str_n);
				 	
				 	
				 	
				 	
		

			 }
		
		
		
		


		reader.close();
	}

}
