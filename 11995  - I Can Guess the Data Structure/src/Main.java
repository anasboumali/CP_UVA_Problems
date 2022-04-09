

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedList;
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

		Stack<Integer> stack;
		Queue<Integer> queue;
		Queue<Integer> pQueue;

		int T;
		int commande, x;
		boolean isStack, isQueue, isPQueue;
		while (in.hasNext()) {
				
			T = Integer.parseInt(in.nextLine());
			stack = new Stack<>();
			queue = new LinkedList<>();
			pQueue = new PriorityQueue<>(Comparator.reverseOrder());

				

			String[] line;
			isStack = true;
			isQueue = true;
			isPQueue = true;

			
			for (int i = 0; i < T; i++) {
				line = in.nextLine().trim().split(" ");

				commande = Integer.parseInt(line[0].trim());
				x = Integer.parseInt(line[1].trim());

				if (commande == 1) {
					
					
					if(isStack)
					stack.push(x);
									
					if(isQueue)
					queue.offer(x);
					
					if(isPQueue)
					pQueue.add(x);
					
				
					

				} else {
					
					if (isStack)
						if (stack.isEmpty() || x != stack.pop())
							isStack = false;

					if (isQueue)
						if (queue.isEmpty() || x != queue.poll())
							isQueue = false;

					if (isPQueue)
						if (pQueue.isEmpty() || x != pQueue.poll())
							isPQueue = false;

		
				}

			}




			if (isStack && !isQueue && !isPQueue)
				System.out.println("stack");
			else if (!isStack && isQueue && !isPQueue)
				System.out.println("queue");
			else if (!isStack && !isQueue && isPQueue)
				System.out.println("priority queue");
			else if (isStack  || isQueue || isPQueue)
				System.out.println("not sure");
			else
				System.out.println("impossible");

		}

	}

}
