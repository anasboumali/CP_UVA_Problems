
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static boolean prime(int n) {

		if (n == 0 || n == 1)
			return false;

		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;

		}

		return true;
	}

	
	public static boolean [] used ;
	public static List<String> buffer ;
	public static void backtrack(int[] t, int c) {

		if (c == t.length && prime(1 + t[c - 1])) {

			buffer.add( Arrays.toString(t).replaceAll("[\\[\\],]", ""));
			
			
			
			return;
		}

		for (int i = 2; i <= t.length; i++) {
			
			if(!used[i] && prime( t[c-1] + i) )
			{
				
			used[i] = true;
			t[c] = i;
			backtrack(t, c + 1);
			used[i] = false;
			}
			

		}
	}


	

	public static void main(String[] arg) throws IOException {

	    Scanner in = new Scanner(System.in);

//	    Scanner in = null;
//
//		try {
//			in = new Scanner(new FileReader("in.txt"));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//	    
//	    
//		PrintStream out = new PrintStream(new FileOutputStream("out.txt"));
//		System.setOut(out);
		
		int counter = 1;
		
		while (in.hasNext()) {
			System.out.println("Case " + counter++ +":");
			int[] t = new int[in.nextInt()];
			
			used = new boolean[t.length+1];
			buffer = new ArrayList<>();
			t[0] = 1;
			backtrack(t, 1);
			
			for (int i = 0; i < buffer.size() - 1; i++) {
				System.out.println(buffer.get(i));
			}
			
			System.out.println(buffer.get(buffer.size()-1));
			
			if(in.hasNext())
			System.out.println();
			
			
			
				
				
		}

	}

}
