
import java.util.ArrayList;
import java.util.Arrays;
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
		//System.out.println( mapStr.toString());
	//	System.out.println( mapWord.toString());
		 
		
		return mapStr.equals(mapWord);
	}
	
	public static void removeAnagrame(String str , ArrayList<String> words)
	{
		boolean anagramExist = false;
		String s = null;
		int i = 1;
		while(!words.isEmpty() && i < words.size())
		{
			s = words.get(i);
			if(Main.isAnagram(str, s))
			{
				words.remove(i);
				anagramExist = true;
			}
			else
				i++;
			
			
			
		}
		
		if(anagramExist)
			words.remove(0);

	}
	
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		String str = null;
		ArrayList<String> words = new ArrayList<String>();
		Map<String , ArrayList<String>> maps =  new HashMap<String, ArrayList<String>>();

		while(!(str =  in.next()).equals("#"))
		{
			words.add(str.trim());

		}
		
		System.out.println(words.toString());
					
		while(!words.isEmpty())
		{
			String s = words.remove(0);
			if(maps.isEmpty())
			{
			maps.put(s, null);

			}
			else
			{
			for( int i = 0 ;i < 1 ; i++)
			{
			
			
			}
				
			}
			
			
		}
		
		System.out.println(words.toString());
		//System.out.println(Main.isAnagram("derail", "dealer"));
			
		
		


	
	}
}
