
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Main {

	
	
	public static boolean isAnagram(String str , String word)
	{
		if(str.length() != word.length())
			return false;

		str = str.toLowerCase();
		word  = word.toLowerCase();
		
		
		
		Map<Character , Integer> mapStr = new HashMap<Character , Integer>();
		Map<Character , Integer> mapWord = new HashMap<Character , Integer>();

		for(int i = 0 ; i< str.length() ; i++)
	   {
		
		
		mapStr.compute(str.charAt(i), (k ,v) ->(v == null) ? 1 :  v + 1);
		mapWord.compute(word.charAt(i), (k ,v) ->(v==null) ? 1 :  v + 1);
		
		
		
     	}

		 
		
		return mapStr.equals(mapWord);
	}
	
	
	
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		String str = null;
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> ananagrams = new ArrayList<String>();

		Map<String , ArrayList<String>> maps =  new HashMap<String, ArrayList<String>>();

		while(!(str =  in.next()).equals("#"))
		{
			words.add(str.trim());

		}
		
					
		while(!words.isEmpty())
		{
			String s = words.remove(0);
			boolean hasAnagram = false;
			for( Iterator<String> it = maps.keySet().iterator() ;it.hasNext();)
			{
				String key = it.next();
			if( Main.isAnagram(key, s))
			{
				hasAnagram = true;
				maps.get(key).add(s);

			}
			
	
			
				
			}
			
					if(!hasAnagram)
					maps.put(s, new ArrayList<String>());
		}
		
		for(String key : maps.keySet())
		{
			if(maps.get(key).isEmpty())
				ananagrams.add(key);			
		}
		
		Collections.sort(ananagrams);
	    for (String s : ananagrams) {
	    	System.out.println(s);
	    				
		}
		
		
		


	
	}
}
