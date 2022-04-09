import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.security.auth.kerberos.KeyTab;


public class Main {
	
	static class Index 
	{
		public int i ;
		public int j;
		@Override
		public String toString() {
			return "Index [i=" + i + ", j=" + j + "]";
		}
		public Index(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	
	static char[][] tabKey ; 
	static Map<Character  ,Index > map ;
	
	static String  encrypted(String pair)
	{
		String strEncrypted ;
		if(map.get(pair.charAt(0)).i ==  map.get(pair.charAt(1)).i )
		{
	
			strEncrypted = String.valueOf(  tabKey[map.get(pair.charAt(0)).i][(map.get(pair.charAt(0)).j + 1)%5]);
			strEncrypted += String.valueOf(  tabKey[map.get(pair.charAt(1)).i][(map.get(pair.charAt(1)).j + 1)%5]);
			
		}	
		else if(map.get(pair.charAt(0)).j ==  map.get(pair.charAt(1)).j )
		{
		
			strEncrypted = String.valueOf(  tabKey[(map.get(pair.charAt(0)).i + 1)%5][map.get(pair.charAt(0)).j]);
			strEncrypted += String.valueOf(  tabKey[(map.get(pair.charAt(1)).i + 1)%5][map.get(pair.charAt(1)).j]);
			
		}
		else 
		{
			strEncrypted = String.valueOf(  tabKey[map.get(pair.charAt(0)).i][map.get(pair.charAt(1)).j]);
			strEncrypted += String.valueOf(  tabKey[map.get(pair.charAt(1)).i][map.get(pair.charAt(0)).j]);
		}
		
		return strEncrypted ;
		
		
		
	}

	public static void main(String[] args) throws IOException {

		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


	
		int T = Integer.parseInt(reader.readLine());
		String key , encrypt ;
		
		while(T--  > 0)
			
		{
			tabKey = new char[5][5];
			map = new HashMap<>();
			key = reader.readLine().replaceAll("\\s+", "").toUpperCase();
			int k = 0;
			char c = 0 ;
			char first = 'A';
			
			//creating "playfair example" table
			for (int i = 0; i < tabKey.length; i++) {
				for (int j = 0; j < tabKey.length; j++) {
					
					
					while(k < key.length() &&  map.containsKey(( c = key.charAt(k))) )
						k++;
					
					if( k < key.length())
					{
						tabKey[i][j] = c;
						map.put(c, new Index(i, j));
					}
					else
					{
						

						while(map.containsKey(first) || first == 'Q') first++;
						
						tabKey[i][j] = first;
						map.put(first, new Index(i, j));
					}
					
				}
			}
			

			
			
//			System.out.println(Arrays.deepToString(tabKey));
//			System.out.println(map);
			
			encrypt = reader.readLine().replaceAll("\\s+", "").toUpperCase();
			
			StringBuilder sb = new  StringBuilder(encrypt);
			
			String pair ;
			for (int i = 0; i < sb.length() ; i+=2) {
				
				
				 pair = sb.substring(i ,  i+ 2 > sb.length() ? i+1 : i+2);
				 if(pair.length() == 1)
				 	pair += 'X';
				 			 
				 else if(pair.charAt(0) == pair.charAt(1))
				 {
					 sb.insert(i+1, 'X');
					 pair = pair.charAt(0) + "X";
				 }
				 

				 System.out.print(encrypted( pair));
				 
				
				
			}
			System.out.println();
			

			
			
			
			
			

			
			
			
			
		}

			

		

		reader.close();
		//writer.close();
	}

}
