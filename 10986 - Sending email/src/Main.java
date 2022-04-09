import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {


	static class Edge {

		public int from;
		public int to;
		public double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;

		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		
		
	}

	
	
	static class Vertex implements Comparable<Vertex>
	{

		public int id ;
		public double weight;
		
		
		
		public Vertex(int id, double weight) {
		
			this.id = id;
			this.weight = weight;
		}



		@Override
		public int compareTo(Vertex o) {
			return (int) (this.weight - o.weight);
		}
		
		
		
	}
	
	
	static class Dijkstra {
		List<Edge>[] graph;
		Edge[] edgeTo;
		double[] distTo;
		boolean[] marked;
		
		public Dijkstra(List<Edge>[] graph, int s,int t) {

			this.graph = graph;
			edgeTo = new  Edge[graph.length];
			distTo = new double[graph.length];
			marked = new boolean[graph.length];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			for (int i = 0; i < graph.length; i++) {
				distTo[i] = Double.POSITIVE_INFINITY;
			}

			distTo[s] = 0.0;
			pq.add(new Vertex(s , 0.0));
			int current ;
			int w;
			while (!pq.isEmpty()) {
				current = pq.poll().id;
				
				if(current == t)
					break;
				

				if(graph[current] != null)
				for (Edge neighbor : graph[current]) {
					w = neighbor.to;
					
					if(distTo[w] > distTo[current] + neighbor.weight)
					{
						
						distTo[w] = distTo[current] + neighbor.weight;
						edgeTo[w] = neighbor;

						pq.add(new Vertex( w, distTo[w]));
					}
					
					
				}
			}

		}
		
		
		
		public double distTo(int v)
		{
			return distTo[v];
			
		}

		public boolean hasPathTo(int v)
		{
			return distTo[v] < Double.POSITIVE_INFINITY;
			
		}
		
		public List<Edge> pathTo(int v)
		{
			if(!hasPathTo(v)) return null;
			Stack<Edge> stack = new Stack<>();
			for(Edge e = edgeTo[v] ; e != null ; e = edgeTo[e.from])
			{
				stack.push(e);
			}
			
			
			
			return new ArrayList<>(stack);
			
		}
	}

	public static void main(String[] args) throws IOException {

		




		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		int nbrCases = Integer.parseInt(reader.readLine().trim());

		int counter = 0;

		StringTokenizer tokenizer = null;
		int n, m, S, T;
		
		List<Edge>[] graph = null;
		for (int i = 1; i <= nbrCases; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			
			n = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
			S = Integer.parseInt(tokenizer.nextToken());
			T = Integer.parseInt(tokenizer.nextToken());
			graph = new ArrayList[n];
			for (int j = 0; j < m; j++) {

				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				double w = Double.parseDouble(tokenizer.nextToken());
				

				if( graph[u] == null)
					graph[u] = new ArrayList<>();
				
				if( graph[v] == null)
					graph[v] = new ArrayList<>();
				
				graph[u].add(new Edge(u,v,w));
				graph[v].add(new Edge(v,u,w));

				
			}

			Dijkstra dijkstra = new Dijkstra(graph, S,T);
			if(dijkstra.hasPathTo(T))
			System.out.println("Case #" + ++counter +  ": " + (int)dijkstra.distTo(T));
			else
				System.out.println("Case #" + ++counter +  ": unreachable");

//			for (int j = 0; j < graph.length; j++) {
//				
//				if(graph[j] != null)			
//				System.out.println(j + " " + graph[j]);
//			}

		}

		reader.close();
		// writer.close();
	}

}
