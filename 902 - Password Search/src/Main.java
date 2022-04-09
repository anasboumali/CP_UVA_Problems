
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Scanner;




public class Main
{


	

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		 Scanner in = new  Scanner(inputStream);

		StringTokenizer tokenizer = null;
		String line  = null;
		String cipher = null;
		int N ;
		
		while(in.hasNext())
		{
			N = in.nextInt();
			cipher = in.next();
			
		//	System.out.println(N  + " " + cipher);
			
			Map<String , Integer> map = new HashMap<>();
			
		
			for (int i = 0; i < cipher.length() - N + 1; i++) {
				
				String key =  cipher.substring(i , i + N);
				if(map.containsKey(key))
					map.put(key, map.get(key) + 1);
				else
					map.put(key, 1);
				
				
				
			}
			
			 
			List<Map.Entry<String, Integer>> list =  new  ArrayList<Map.Entry<String,Integer>>(map.entrySet());

			
			
			Collections.sort(list , new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					
					
						return -1*(o1.getValue() - o2.getValue());
						
				}
				
				
			});
			
			//System.out.println(list);
			System.out.println(list.get(0).getKey());
		
		}


		// writer.close();
	}

}
