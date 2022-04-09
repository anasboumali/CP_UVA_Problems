
import java.util.Scanner;;

public class Main {

	

	
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		String str = null;
		while(!(str =  in.nextLine()).equals("DONE"))
		{
			str = str.replaceAll("[,!.? ]", "").toLowerCase();
			
			String newStr =  new StringBuilder(str).reverse().toString().toLowerCase();
	
		
			if(str.equals(newStr))
			System.out.println("You won't be eaten!");
			else
				System.out.println("Uh oh..");
			
		}
		


	
	}
}
