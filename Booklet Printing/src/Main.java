
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Main {

	

	

	
	public static void main(String[] arg)
	{		
		
		Scanner in = new Scanner(System.in);

//		Scanner in = null;
//		
//		try {
//			 in = new Scanner(new FileReader("in.txt"));
//			
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		}

		int pageNbr;
		int sheetNbr;
		while( (pageNbr = in.nextInt()) != 0 )
		{
			sheetNbr = (pageNbr%4 == 0) ? pageNbr/4 : pageNbr/4 + 1;
			System.out.println("Printing order for " + pageNbr + " pages:");
			
			
			
//			System.out.println("Sheet " +  1 +  ", front: " + ((pageNbr%4 == 0) ? pageNbr-- : "Blank") + ", " + 1);
//				if(pageNbr > 1)
//			System.out.println("Sheet " +  1 +  ", back : " + 2 + ", " + ((pageNbr%4 == 0) ? pageNbr-- : "Blank")  );
				
				int k = 1 ;
				int rest = (4 - pageNbr%4)%4;
				
			for (int i = 0; i < sheetNbr; i++)
			{
				System.out.println("Sheet " + (i+1) + ", front: " + (rest-- >0 ?  "Blank" : pageNbr--) + ", "+ k++);
				
				if(pageNbr > 1)
				System.out.println("Sheet " + (i+1) + ", back : " + k++ + ", " +  (rest-- > 0 ?  "Blank" : pageNbr--));

			}
			 
			
			
		}
			
			
					
				
		


	
	}
}
