
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;





public class Main {
	
	
	static int[][] capacity ;
	static ArrayList<Integer>[] graph;
	static int[] parent;
	static int s ,t;//source , sink
	static ArrayList<Point> minCutVertecies;
	//min flow
	
	static boolean[] reacheable;
	static void dfs(int u)
	{
		reacheable[u] = true;
		
		if(graph[u] != null)
			for (Integer v : graph[u]) {
				
				if(!reacheable[v] && capacity[u][v] > 0)
					dfs(v);
				
			}
		
		
	}
	static boolean bfs()
	{
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited  = new boolean[graph.length];
		parent = new int[graph.length];
		queue.add(s);
		visited[s]  = true;
		while(!queue.isEmpty())
		{
			int u = queue.poll();
			if(u == t)
				return true;
			
			if(graph[u] != null)
			for (Integer v : graph[u]) {
				if( !visited[v] && capacity[u][v] > 0)
				{				
					queue.add(v);
					parent[v] = u;
					visited[v] = true;

					
				}
				

			}
			
			
		}
		
		return false;
		
	}
	static void minCut()
	{
		dfs(s);
		
		for (int i = 0; i < reacheable.length; i++) {
			
			if(graph[i] != null)
			{
				if(reacheable[i])
				{
					for (Integer j : graph[i]) {
						
						if(!reacheable[j] && capacity[i][j] <= 0)
						{
							System.out.println(i + " " + j);
							
						}
							
						
						
					}
				}
		
				
			}
		}
		
		
		
		
	}
	static int EdmondsKarp()
	{
		int Maxflow = 0;

		while(bfs())
		{

			int flow = Integer.MAX_VALUE;
			for (int v = t; v != s; v = parent[v]) {
				
				int u = parent[v];

					flow = Math.min(flow, capacity[u][v]);

				

			}
			
			for (int v = t; v != s; v = parent[v]) {
				
				int u = parent[v];
				capacity[u][v] -= flow;
				capacity[v][u] += flow;

			}

			
			Maxflow += flow;
		}
		
		return Maxflow ;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		Scanner in  = new Scanner(inputStream);
		
//		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"))));



		int n,m;
		int counter = 1;
		int N = 60;
		boolean blank = false;
		while(true)
			
		{
			

			s = 1;
			t = 2;
			n = in.nextInt();
			if(n == 0)
				break;
			
			if(blank)
			{
				System.out.println();
			}
			
			m = in.nextInt();
			graph = new ArrayList[N];
			capacity = new int[N][N];
			reacheable = new boolean[N];
			for (int i = 0; i < N; i++) {
				
				Arrays.fill(capacity[i], -1);
			}
			minCutVertecies = new ArrayList<>();
			while(m-- > 0)
			{
				int u = in.nextInt();
				int v = in.nextInt();
				int c = in.nextInt();
				
				if(graph[u] == null)
					graph[u] = new ArrayList<>();
				
				if(graph[v] == null)
					graph[v] = new ArrayList<>();
				
				

				graph[u].add(v);
				graph[v].add(u);
				
				capacity[u][v] = c;
				capacity[v][u] = c;
				
				
			}
			
			
			EdmondsKarp();
			minCut();

			blank = true;

		}
		
		
		//writer.close();
	
		
	}

}
