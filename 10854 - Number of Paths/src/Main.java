import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;




public class Main {

	static  BufferedReader reader  ;
	static String currentToken ;
	static String padd  = "";
	static int Else() throws IOException
	{

	int paths = 1;


		do
			{

			paths *= instruction();
			
			}while(!currentToken.equals("END_IF"));
		currentToken = reader.readLine();

		return paths;
		
	}
	
	static int If() throws IOException
	{


	int paths = 1;
		
		do
			{

			paths *= instruction();
			
			}while(!currentToken.equals("ELSE"));
		currentToken = reader.readLine();

		
		paths += Else();
	
		return paths;
	}

	static int instruction () throws IOException
	{
		
		
		if(currentToken.equals("IF")) 
		{
			currentToken = reader.readLine();
			return If();

		}
		
		if(currentToken.equals("S")) 
		{
			currentToken = reader.readLine();
			return 1;

		}
		

		return 1;
	
		
		
	}
	static int program() throws IOException
	{
		currentToken = reader.readLine();

		int paths = 1;
		do
		{
			int test = instruction();
			 paths *= test;
			
	
			
			
		}while(!currentToken.equals("ENDPROGRAM"));

		return paths;
		
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

			 reader = new BufferedReader(new InputStreamReader(inputStream));

		
		int T = Integer.parseInt(reader.readLine());
		
		
		while(T-- > 0)
		{
			
			
			
			 System.out.println(program());
			
			
		}
		
		
		
		
		


		reader.close();
	}

}
