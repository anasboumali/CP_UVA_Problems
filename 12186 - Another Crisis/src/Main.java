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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.security.auth.kerberos.KeyTab;





public class Main {
	
	
	
	static ArrayList<Integer>[] graph ;
	static int N , T;
	

	static int dfs(int u)
	{
		
		if(graph[u] != null)
		{
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (Integer v : graph[u]) {
				
				
				pq.add(dfs(v));
				
				
			}
			
			int ratio = (int) Math.ceil((graph[u].size()*(T/100.0)));
			int min  = 0;
			
			while(ratio-- > 0)
				min += pq.poll();
			
			return min;
			
		}else
		return 1;
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException {

		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


	
		String line ;
		while((line = reader.readLine()) != null)
			
		{
			if(line.equals(""))
				continue;
			
			N = Integer.parseInt(line.split("\\s+")[0]);			
			T = Integer.parseInt(line.split("\\s+")[1]);
			
			if(N == 0)
				break;
			
			
			graph = new ArrayList[N+1];
			
			line = reader.readLine();
			StringTokenizer sToken = new StringTokenizer(line);
			
			for (int i = 1; sToken.hasMoreTokens(); i++) {
				
				int v = Integer.parseInt(sToken.nextToken());
				
				if(graph[v] == null)
				graph[v] = new ArrayList<>();
				
				

				graph[v].add(i);
				
				
				
				
				
			}
			
			
//			for (int i = 0; i < graph.length; i++) {
//				
//				System.out.print(i + " : ");
//				if(graph[i] != null)
//				{
//					System.out.println(graph[i].toString());
//				}
//				else
//					System.out.println();
//			}
//			
//			System.out.println(Math.ceil(12.5));
			System.out.println(dfs(0));
			
			
			
			
			
		}
		
		
		reader.close();
		//writer.close();
	
		
	}

}
