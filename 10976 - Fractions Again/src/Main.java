

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	
	
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

		int  k ;
		int nbrFractions = 0;
		while (in.hasNext()) {
				
			k = Integer.parseInt(in.nextLine().trim());
			nbrFractions = 0;
			ArrayList<Entry<Integer,Integer>> list = new ArrayList<>();
			for (int i = k+1; i <= 2*k; i++) {
				
				if( (k*i)%(i-k )== 0)
				{
					nbrFractions++;
					list.add(new AbstractMap.SimpleEntry(i*k/(i-k), i));

				}
			}
					
		System.out.println(nbrFractions);
		for (Entry<Integer, Integer> entry : list) {
		System.out.println(String.format("1/%d = 1/%d + 1/%d",k,entry.getKey() ,entry.getValue() ));

		}

					


	}
	}
	
	
}
