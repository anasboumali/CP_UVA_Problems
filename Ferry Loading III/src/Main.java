
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {

		 Scanner in = new Scanner(System.in);
		
		class Car
		{
			public int id ;
			public int arrival ;
			
			public Car(int id , int arrival)
			{
				this.id = id;
				this.arrival = arrival;
			}
		}

//		Scanner in = null;
//
//		try {
//			in = new Scanner(new FileReader("in.txt"));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}

		Queue<Car> queueLeft =  new ArrayDeque<Car>();
		Queue<Car> queueRight =  new ArrayDeque<Car>();
		
		Queue<Car> queueCurrent;
		
		int n, t, m;
		int currentTime, carArrivalTime;
		String bank;
		int T = Integer.parseInt( in.nextLine());
		while (in.hasNextLine()) {
			
			n = in.nextInt();
			t = in.nextInt();
			m = Integer.parseInt(in.nextLine().trim());

			int[] mapCarToEmbarqTime =  new int[m];
			for (int i = 0; i < m; i++) {

				carArrivalTime = in.nextInt();
				bank = in.nextLine().trim();

				if (bank.equals("left")) {

					queueCurrent = queueLeft;

				} else
					queueCurrent = queueRight;

				queueCurrent.add(new Car(i,carArrivalTime));
				
				
				
			}

			
			
			currentTime = 0;
//			System.out.println(queueLeft.toString());
//			System.out.println(queueRight.toString());
			queueCurrent = queueLeft;
			while(!queueLeft.isEmpty() ||  !queueRight.isEmpty())
			{
				int min ;
				if(queueLeft.isEmpty())
				{
					min = queueRight.peek().arrival;
				}
				else if(queueRight.isEmpty())
				{
					min = queueLeft.peek().arrival;

				}
				else
				{
				min = Math.min(queueLeft.peek().arrival, queueRight.peek().arrival);
				}
				//System.out.println("min : " + min);
				if(currentTime < min)
					currentTime+= (min - currentTime);
				
				
				currentTime +=  t;

				for (int i = 0; i < n; i++) {
					
					if(!queueCurrent.isEmpty())
					{
						
					if(currentTime - t >= queueCurrent.peek().arrival)
					{
						
						mapCarToEmbarqTime[queueCurrent.poll().id] = currentTime;
						
					}else
						break;
								
								
					}else
						break;
			
					
					
				}
				
				queueCurrent = (queueCurrent == queueLeft) ? queueRight : queueLeft;

		   }
				
				for (int i = 0; i < mapCarToEmbarqTime.length; i++) {
					System.out.println(mapCarToEmbarqTime[i]);
				}
				if(T > 1)
				System.out.println();
			
			
				T--;

		}
	}

}
