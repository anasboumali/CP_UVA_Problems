
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class Main {

	public static void main(String[] arg) {

		//Scanner in = new Scanner(System.in);
		
	

		Scanner in = null;

		try {
			in = new Scanner(new FileReader("in.txt"));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}


//		TreeSet<Integer> pQueueSG ;
//		TreeSet<Integer> pQueueSB ;
		PriorityQueue<Integer> pQueueSG ;
		PriorityQueue<Integer> pQueueSB ;
		

		int B , SG , SB ;
		int	T = Integer.parseInt(in.nextLine());
		while(in.hasNext())
		{
			B = in.nextInt();
			SG = in.nextInt();
			SB = Integer.parseInt(in.nextLine().trim());

//			pQueueSG = new TreeSet<>(Collections.reverseOrder());
//			pQueueSB =  new TreeSet<>(Collections.reverseOrder());
			pQueueSG = new PriorityQueue<>(SG,Collections.reverseOrder());
			pQueueSB =  new PriorityQueue<>(SB, Collections.reverseOrder());			
			for (int i = 0; i < SG; i++) {
				pQueueSG.add( in.nextInt());
				
			}
			
			
			
		for (int i = 0; i < SB; i++) {
			pQueueSB.add( in.nextInt());

			}
		


			Integer sb , sg ;
		while(!pQueueSB.isEmpty()  && !pQueueSG.isEmpty())
		{
			int realB = Math.min(B ,  Math.min(pQueueSB.size(), pQueueSG.size()));
			
			for (int i = 0; i < realB; i++) {
				
			sb = pQueueSB.poll();
			sg = pQueueSG.poll();

			if(sb > sg)
			{
				pQueueSB.add(sb-sg);
			}
			else if(sb  < sg)
			{
				pQueueSG.add(sg-sb);

			}
			
			}
	
			
		
				
			
		}
		
		if( pQueueSB.isEmpty() && pQueueSG.isEmpty())
		{
			
			System.out.println("green and blue died");
		}
		
		
		else if(pQueueSB.isEmpty())
		{
			System.out.println("green wins");

//			for (Integer i : pQueueSG) {
//				System.out.println(i);
//			}
			
			while(pQueueSG.size() != 0)
				System.out.println(pQueueSG.poll());
			
		}
		
		
		
		else if(pQueueSG.isEmpty())
		{
			System.out.println("blue wins");
			
//	for (Integer i : pQueueSB) {
//		System.out.println(i);
//	}
			while(pQueueSB.size() != 0)
				System.out.println(pQueueSB.poll());
		}

		
			
			if(T > 1)
				System.out.println();
			
			T--;
		}

	}

}
