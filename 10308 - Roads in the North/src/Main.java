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
	
	static class Edge 
	{
		int from ;
		int to ;
		double weight ;

		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		
		
		
	}
	static ArrayList<Edge>[] graph ;

	

	static PriorityQueue<Integer> pq; 
	static int dfs(int u , int parent)
	{
		 int firstMax  = 0;
		 int secondMax = 0;
		
		int max = 0;
		if(graph[u] != null)
		for (Edge  e : graph[u]) {
			
			if(e.to == parent)
				continue;
			
			 max = (int) (e.weight) + dfs(e.to , e.from);		
		
				
				if(max > firstMax)
				{
					secondMax = firstMax;
					firstMax = max;
					
				}
				else if(max > secondMax)
					secondMax = max;
				
				
					
					
				
				
			
			
		}
		
		
		pq.add(firstMax + secondMax);
		
		return firstMax;
	
		
		
		
	}

	public static void main(String[] args) throws IOException {

		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


	
		String line ;
		while((line = reader.readLine()) != null)
			
		{
			
			graph = new ArrayList[10000];
			
			do
			{
				int u , v , c ;
				u = Integer.parseInt( line.split("\\s+")[0]);
				v = Integer.parseInt( line.split("\\s+")[1]);
				c = Integer.parseInt( line.split("\\s+")[2]);
				
				
				if(graph[u] == null)
					graph[u] = new ArrayList<>();
				

				if(graph[v] == null)
					graph[v] = new ArrayList<>();
				
				
				graph[u].add(new Edge(u, v, c));
				graph[v].add(new Edge(v, u, c));
				
				
				
			}while((line = reader.readLine()) != null && !line.equals(""));
			
			pq = new PriorityQueue<>(Comparator.reverseOrder());
			dfs(1 , 0);
			
			System.out.println(pq.peek());
			
			
			
		}

			

		

		reader.close();
		//writer.close();
	}

}
