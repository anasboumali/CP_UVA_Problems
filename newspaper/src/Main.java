
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Locale;

public class Main {

	

	

	
	public static void main(String[] arg) throws IOException
	{		
		

		
		BufferedReader buffer = null;
		//	buffer = new BufferedReader( new  InputStreamReader(new FileInputStream("in.txt")));
	 	buffer = new BufferedReader( new  InputStreamReader(System.in));
		
			


		Locale.setDefault(new Locale("en", "US"));
		
		int nbrChar ;
		int nbrLines ;
		Map<Character,Double> mapCost ;
		//Map<Character,Integer> mapFreq ;
				String paragraph = ""; 
				Double pay = 0.0 ;
				StringTokenizer sToken = null ;
				
			buffer.readLine();

		

			while(buffer.ready())
			{	
				mapCost = new HashMap<Character, Double>(); 
			//	mapFreq = new HashMap<Character, Integer>(); 
			    paragraph = "";
			    pay = 0.0;
			   
			
				nbrChar = Integer.parseInt(buffer.readLine());
				for (int i = 0; i < nbrChar; i++) {
				
						sToken = new StringTokenizer(buffer.readLine(), " ");
		
					
					mapCost.put(sToken.nextToken().charAt(0), Double.parseDouble(sToken.nextToken()));
					
					
				}
				//System.out.println("mapCost : "+ mapCost.toString());
				
				nbrLines = Integer.parseInt( buffer.readLine());

				for (int i = 0; i < nbrLines; i++) {
					paragraph = buffer.readLine();
					
					for (Character c : paragraph.toCharArray()) {
						
						if(mapCost.containsKey(c))
							pay += mapCost.get(c);
						
					}
				}
				
				//System.out.println("parag : " + paragraph);
				
//				for (Character c : paragraph.toCharArray()) {
//					
//					if(mapFreq.containsKey(c))
//						mapFreq.compute(c, (k, v)-> v + 1);
//					else
//						mapFreq.put(c, 1);
//					
//				
//					
//					
//					
//				}
//				
				//System.out.println(mapFreq);

//				for (Character key : mapCost.keySet()) {
//					
//					if(mapFreq.containsKey(key))
//					pay += mapFreq.get(key)*mapCost.get(key);
//					
//				}
				pay/=100;
				System.out.println(String.format("%.2f", pay)  + "$");
				
				
				
			}

		
		
		
		
		
		
	

	
	}
}
