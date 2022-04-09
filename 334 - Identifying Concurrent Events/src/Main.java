import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws IOException {


		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		  Scanner in = new Scanner(inputStream);
		 

		int counter = 1;

		StringTokenizer tokenizer = null;
		int NC , NE , NM ;

		while(true)
		{
			NC = in.nextInt();

			if(NC == 0)
				break;
//			tokenizer = new StringTokenizer(reader.readLine());
//			P = Integer.parseInt(tokenizer.nextToken());
//			R = Integer.parseInt(tokenizer.nextToken());
	
			
			int num = 0;
			double[][] dist = new double[200][200];
			Map<String , Integer> map = new HashMap<>();
			Map<Integer , String> mapIntToEvent = new HashMap<>();

			
			
			for (int i = 0; i < 200; i++) {
				for (int j = 0; j < 200; j++) {
					
					if(i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = Double.POSITIVE_INFINITY;
				}
			}
			
			
			for (int i = 0; i < NC; i++) {
				NE = in.nextInt();

				String u_str = in.next();				
				int last_u = 0 ;
				
				
				
					map.put(u_str, num++);
					mapIntToEvent.put(num - 1, u_str);
					last_u = map.get(u_str);
					
				for (int j = 0; j < NE - 1; j++) {
//					tokenizer = new StringTokenizer(reader.readLine());
//					String u_str = tokenizer.nextToken();				
//					String v_str = tokenizer.nextToken();
					
					String v_str = in.next();
					
			
					
					if(!map.containsKey(v_str))
					{						
						
						map.put(v_str, num++);

						mapIntToEvent.put(num - 1, v_str);

					}
					
					
					int u = last_u;
					int v = map.get(v_str);
					
					dist[u][v] = 1;
					
					last_u = v;
					
				}
			}
			
			
			
			NM = in.nextInt();

			for (int i = 0; i < NM; i++) {
				
				String u_str = in.next();
				String v_str = in.next();

		
				
				if(!map.containsKey(u_str))
				{
					map.put(u_str, num++);

					mapIntToEvent.put(num - 1, u_str);

				}
				
				if(!map.containsKey(v_str))
				{
					map.put(v_str, num++);
					mapIntToEvent.put(num - 1, v_str);

				}
				
				
				int u = map.get(u_str);
				int v = map.get(v_str);
				
				dist[u][v] = 1;
				
			}
//			System.out.println(map);
//			System.out.println(Arrays.deepToString(dist));
			//floyd minimax
			for (int k = 0; k < num; k++) {
				for (int i = 0; i < num; i++) {
					for (int j = 0; j < num; j++) {
						
						dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
						
						
					}
				}
			}
//			System.out.println(Arrays.deepToString(dist));

			
			int concurentEvents = 0;
			List<Point> twoPairsEvent  = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				for (int j = i; j < num; j++) {
					
					if(dist[i][j] == Double.POSITIVE_INFINITY && dist[j][i] == Double.POSITIVE_INFINITY )
					{
						concurentEvents++;
						twoPairsEvent.add(new Point(i, j));
						
					}
					
				}
				

			}
			

			if(concurentEvents != 0)
			{
			System.out.println("Case "+ counter++ + ", " + concurentEvents + " concurrent events:");
			
			System.out.print("("+ mapIntToEvent.get(twoPairsEvent.get(0).x)  + "," + 
					mapIntToEvent.get(twoPairsEvent.get(0).y) + ") ");
			
			
			if( twoPairsEvent.size() > 1) {
				System.out.print("("+ mapIntToEvent.get(twoPairsEvent.get(1).x)  + "," + 
						mapIntToEvent.get(twoPairsEvent.get(1).y) + ") ");
			}
			System.out.println();
			
			}
			else
			System.out.println("Case "+ counter++ + ", no concurrent events.");

	
			
			
			
		}
		
		

//		reader.close();
		// writer.close();
	}

}
