import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;




public class Main {

	static  BufferedReader reader  ;
	static String currentToken ;
	static String padd  = "";
	static StringTokenizer tokenizer;
	static int offset = 0;
	static String smeech_expr ;
	
	
	
	
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

	static double Smeech()
	{
//		System.out.println("expression : " + currentToken);

		double smeech ;
		
		if(currentToken.equals("("))
		{
			currentToken = nextToken();
			
			double p = Double.parseDouble(currentToken);
			
			currentToken = nextToken();

			double x = Smeech();
			
			double y = Smeech();
			
			//read closed parenthese  )
			currentToken = nextToken();

			
			
			smeech = p*(x+y) + (1-p)*(x-y);
			
		}else
		{
			

			smeech = (double)Integer.parseInt(currentToken);
			currentToken = nextToken();
			
			
			

		}
		
		return smeech;

		
	}
	
	static String nextToken()
	{
		
		if(offset >= smeech_expr.length())
			return null;
		
		while(smeech_expr.charAt(offset) == ' ')
			offset++;
		
		
		String token = String.valueOf(smeech_expr.charAt(offset)) ;
		
		
		if(Character.isDigit( smeech_expr.charAt(offset)) || smeech_expr.charAt(offset) == '.' || smeech_expr.charAt(offset)=='-' )
		{
			offset++;
			while( offset < smeech_expr.length() && (Character.isDigit( smeech_expr.charAt(offset)) || smeech_expr.charAt(offset) == '.' ))
				token += smeech_expr.charAt(offset++);		
		}
		else
			offset++;
	
		
		return token;
			
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

			 reader = new BufferedReader(new InputStreamReader(inputStream));
			 Locale.setDefault(Locale.US);
		
		
		while(!(smeech_expr = reader.readLine()).equals("()"))
		{
			
			
			offset = 0;
			currentToken = nextToken();
			System.out.println(String.format("%.2f", Smeech()) );
			
			
			


			 
			
		}
		
		
		
		
		


		reader.close();
	}

}
