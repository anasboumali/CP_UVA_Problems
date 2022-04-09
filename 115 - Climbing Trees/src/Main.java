import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;




public class Main {

	static  Scanner in  ;
	static String currentToken ;
	static HashSet<Integer> sumPathsSet ;
	static boolean isCharInAdvance;
	static String charInadvance;
	static String nextToken()
	{
		String c = "";
		
		if(isCharInAdvance)
		{
			c = charInadvance;
			isCharInAdvance = false;
		}
		else
		{
			if(in.hasNext())
			c = in.next();
			
		}
		
			
		while(in.hasNext() && ( c.matches("\\s+")))
			c = in.next();
		
		if(c.equals("(") || c.equals(")"))
			return c;
		
		String number = c;
		while( in.hasNext() && ( Character.isDigit((c = in.next()).charAt(0)) || c.equals("-") ))
			number += c;
		
		charInadvance = c;
		isCharInAdvance = true;
		
		return number ;
		
		
	}
	
	static boolean tree(int cumul)
	{
		//read (
		nextToken();
		currentToken = nextToken();
		if(currentToken.equals(")"))
		{
//			currentToken = nextToken();
			return true;
				
		}
		else
		{
			int nodeValue = Integer.parseInt(currentToken);
//			currentToken = nextToken();
			boolean left = tree(cumul + nodeValue);
			boolean right = tree(cumul + nodeValue);
			nextToken();//consume )
			if(left && right)
				sumPathsSet.add(cumul+ nodeValue);
			
			return false;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

//			 reader = new BufferedReader(new InputStreamReader(inputStream));
		
		 in  = new Scanner(inputStream);
		int I ;
		 in.useDelimiter("");

		while(in.hasNext())
		{
			
			 
			sumPathsSet = new HashSet<>();
			try {
				I = Integer.parseInt(nextToken()) ;

			} catch (Exception e) {
break;			}
//			System.out.println(I);
			
//			while(in.hasNext())
//			System.out.print(nextToken());
//			 currentToken = nextToken();
			tree(0);
			
			System.out.println(sumPathsSet.contains(I) ? "yes" : "no");
			
		}
		
		
		
		
		


	}

}
