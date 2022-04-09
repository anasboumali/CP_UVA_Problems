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
		int P , R ;
		boolean first = true;
		while(true)
		{
//			tokenizer = new StringTokenizer(reader.readLine());
//			P = Integer.parseInt(tokenizer.nextToken());
//			R = Integer.parseInt(tokenizer.nextToken());
			P = in.nextInt();
			R = in.nextInt();
			
			if(R == 0)
				break;
			
			int num = 0;
			double[][] dist = new double[P][P];
			Map<String , Integer> map = new HashMap<>();
			
			
			
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < P; j++) {
					
					if(i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = Double.POSITIVE_INFINITY;
				}
			}
			
			for (int i = 0; i < R; i++) {
//				tokenizer = new StringTokenizer(reader.readLine());
//				String u_str = tokenizer.nextToken();				
//				String v_str = tokenizer.nextToken();
				
				String u_str = in.next();				
				String v_str = in.next();
				
				if(!map.containsKey(u_str))
					map.put(u_str, num++);
				
				if(!map.containsKey(v_str))
					map.put(v_str, num++);
				
				
				int u = map.get(u_str);
				int v = map.get(v_str);
				
				dist[u][v] = 1;
				dist[v][u] = 1;
				
				
			}
//			System.out.println(map);
//			System.out.println(Arrays.deepToString(dist));
			//floyd minimax
			for (int k = 0; k < P; k++) {
				for (int i = 0; i < P; i++) {
					for (int j = 0; j < P; j++) {
						
						dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
						
						
					}
				}
			}
//			System.out.println(Arrays.deepToString(dist));

			
			boolean disconnected = false;
			double max = 0;
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < P; j++) {
					
					if(dist[i][j] == Double.POSITIVE_INFINITY)
					{
						disconnected = true;
						break; 
						
					}else
						max = Math.max(max, dist[i][j]);
					
				}
				
				if(disconnected)
					break;
			}
			
			
			if(!first)
			System.out.println();
			
			
			first = false;
			
			if(disconnected)
			System.out.println("Network " + counter++ + ": DISCONNECTED");
			else
			System.out.println("Network " + counter++ + ": " + (int)max);

	
			
			
			
		}
		
		System.out.println();
		

//		reader.close();
		// writer.close();
	}

}
