
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Main {

	
	
	public static int[] getRange(int c, int n) {

		int[] range = new int[n];
		range[0] = c;
		int k = c;
		int j = c;
		for (int i = 1; i < n;) {
			
			if(k < n-1)
				range[i++] = ++k;
			
			if(j > 0)
				range[i++] = --j;
		
		}

		return range;

		
		
	}

	public static boolean place(int[] row , int r ,int c)
	{
		
		
		for (int i = 0; i < c; i++) {
			if(row[i] == r || (Math.abs(row[i] - r) == Math.abs(i-c)))
				return false;
		}
		
		
		return true;
	}
	
	public static int min = 100000;
    public static int[] t ;
	public static void backtrack(int[] row, int c) {

		if (c == row.length) {
			int counter = 0;
			for (int i = 0; i < row.length; i++) {
				if(t[i] != row[i])
					counter++;
				
			}
			
			if(counter < min)
				min = counter;
			
		
			 	return ;
		}

		int n = row.length;
		
		int[] t = getRange(row[c], n);

		
		for (int i = 0; i < n; i++) {
			
			if(place(row, i, c))
			{
				row[c] = i; 
				backtrack(row, c+1);
			}
			
		}
		

	}

	public static void main(String[] arg) {

		 Scanner in = new Scanner(System.in);

//		Scanner in = null;
//
//		try {
//			in = new Scanner(new FileReader("in.txt"));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
		final int n = 8;

		int[] row = new int[n];
		 t = new int[n];

		int counter = 1;
		
		while (in.hasNext()) {
			for (int i = 0; i < n; i++) {

				t[i] = in.nextInt()-1 ;
			}
			 min = 100000;
			 backtrack(row, 0);

			 
			 
			System.out.println("Case " + counter++ + ": " + min);


		}
	}

}
