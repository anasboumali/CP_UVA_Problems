import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import org.omg.CORBA.portable.IndirectionException;







public class Main {
	
	static enum Direction 
	{
		DOWN , 
		UP 
	}
	

	

	public static void main(String[] args) throws IOException {

		
		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		 	Scanner in   = new Scanner(inputStream);
		
	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		
		int N;
		while(in.hasNext())
			
		{
			N = in.nextInt();
			if(N == 0) break;
			
			int nbrPeaks = 1;
			
			int currentH = 0;
			
			int[] t = new int[N+1];
			
			for (int i = 0; i < t.length -1 ; i++) {
				t[i] = in.nextInt();
			}
			
			t[t.length - 1] = t[0];
			
			Direction currentDir = (t[0]> (currentH =  t[1]) ? Direction.DOWN : Direction.UP );
			Direction firstDir = currentDir;
			Direction lastDir;
			for (int i = 2; i < N + 1; i++) {
				
				
				lastDir = currentDir;
				int lastH = currentH ;
				
				
				currentH  = t[i];
				
				if(lastH >  currentH)
					currentDir = Direction.DOWN;
				
				if(lastH <  currentH)
					currentDir = Direction.UP;
				
				
				if(currentDir != lastDir)
					nbrPeaks++;
				
				
			}
			
			
			if(nbrPeaks == 1) nbrPeaks++;
			else
			{
				
				if(firstDir == currentDir)
					nbrPeaks--;
			}
			
			System.out.println(nbrPeaks);
			
			
			
		
	
		}
	}
		
	



}
