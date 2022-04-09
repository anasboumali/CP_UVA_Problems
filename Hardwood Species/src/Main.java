
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] arg) throws IOException {

		// Scanner in = new Scanner(System.in);
		


//		Scanner in = null;
//
//		try {
//			in = new Scanner(new FileReader("in.txt"));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
		Locale.setDefault(new Locale("en", "US"));

		BufferedReader buffer = new BufferedReader( new  InputStreamReader(System.in));
		
		Map<String , Integer> map ; 
		
		int T = Integer.parseInt(buffer.readLine());
		buffer.readLine();

		int nbrTree;
		while(buffer.ready())
		{
			map = new TreeMap<>();
			String key ;
			nbrTree = 0;
			while(buffer.ready() && !(key = buffer.readLine().trim()).equals(""))
			{
				nbrTree++;
				if(map.containsKey(key))
				{
					map.compute(key, (k,v) -> v + 1);
					
					
				}else
					map.put(key, 1);
				
				
				
			}
	for (Entry<String, Integer> entry : map.entrySet()) {
		
		System.out.println(entry.getKey() + " " + String.format ("%.4f" , ((double)entry.getValue()/nbrTree)*100));
	}
			
	if( T > 1)
		System.out.println();
		
	T--;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
