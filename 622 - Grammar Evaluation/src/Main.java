import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Main {

	static  BufferedReader reader  ;
	static String currentToken ;
	static String padd  = "";
	static StringTokenizer tokenizer;
	static int offset = 0;
	static String str_expression ;
	
	
	
	static int tryParse(String num)
	{
		int result ;
		try {
			result = Integer.parseInt(num);
			
		} catch (NumberFormatException e) {
			
			result =  -1 ;
		}
		
		return result;
		
	}
	static int factor ()
	{
//		System.out.println("factor : " + currentToken);
		if(currentToken != null)
		{
			if(currentToken.equals("("))
			{
				currentToken = nextToken();
				if(currentToken == null)
					return -1;
				
				
				int expr =  expression();
			
				
				if(currentToken == null)
					return -1;

				if(!currentToken.equals(")"))
				{
					return -1;

				}
				else
				{

					currentToken = nextToken();
					return expr;

				}
				

			}

			
			int  result =  tryParse(currentToken);
//			System.out.println(result);
			currentToken = nextToken(); 
//			System.out.println("curr : " + currentToken);
			return result;
		}


		
		return -1;
		
	}
	static int component()
	{
//		System.out.println("component : " + currentToken);

		int multuplication = factor();
		if(multuplication == -1)
			return -1;
		
		if(currentToken != null)
		if(currentToken.equals("*"))
		{
			currentToken = nextToken();
			if(currentToken == null)
				return -1;
			
			multuplication*= component();
		}
		
		
		return multuplication;
		
		
	}
	static int expression()
	{
//		System.out.println("expression : " + currentToken);
		int addition = component();
		
		if(addition == -1)
			return -1;
		
		
		if(currentToken != null)
		{
			if(currentToken.equals("+"))
			{
				currentToken = nextToken();
		
				int expr = expression();
				if(expr == -1)
					return -1;
				addition += expr;
				

			}
			else if(!currentToken.equals(")")) return -1;
	

		}

	return addition;
		
		
	}
	
	static String nextToken()
	{
		
		if(offset >= str_expression.length())
			return null;
		
		String token = String.valueOf(str_expression.charAt(offset)) ;
		
		
		if(Character.isDigit( str_expression.charAt(offset++)))
		while( offset < str_expression.length() && Character.isDigit( str_expression.charAt(offset)))
			token += str_expression.charAt(offset++);
		
		
		return token;
			
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

			 reader = new BufferedReader(new InputStreamReader(inputStream));

		int T = Integer.parseInt(reader.readLine());
		
		
		while(T-- > 0)
		{
			
		
			offset = 0;
			str_expression = reader.readLine();
			
//			String str ;
//			while((str  = nextToken()) != null)
//				System.out.println("tok : " +  str);
			int result = 0;
			currentToken = nextToken();
		
			
				 result = expression();

					if(currentToken != null)				
						 result = -1;
		
						
					
			 System.out.println((result != -1 )? result : "ERROR" );
//			System.out.println("______________");
			 
			 
			
		}
		
		
		
		
		


		reader.close();
	}

}
