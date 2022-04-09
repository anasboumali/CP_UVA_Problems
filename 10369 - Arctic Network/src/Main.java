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
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;






public class Main {

	
	static List<Edge>[] graph;
	static int S ; 
	
	static class Edge implements Comparable<Edge>
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



		public int compareTo(Edge o) {

			if(this.weight - o.weight < 0)
			return 1;
			else if (this.weight - o.weight > 0)
				return -1;
			
			return 0;
			
			
			
		}
		
		
		
		
	}
	
	static class Vertex implements Comparable<Vertex>
	{
		int id ;
		double weight;
		
		public Vertex(int id, double weight) {
			this.id = id;
			this.weight = weight;
		}
		
		public int compareTo(Vertex o) {

			if(this.weight - o.weight < 0)
			return -1;
			else if (this.weight - o.weight > 0)
				return 1;
			
			return 0;
			
			
			
		}
		
		
	}
	
	
	
	
	static void Prim()
	{
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		PriorityQueue<Edge> pqEdge = new PriorityQueue<>();

	    Edge[] edgeTo = new Edge[graph.length] ;
	    boolean[] visited = new boolean[graph.length];
	    double[] distTo = new double[graph.length];
	    
	    
	    for (int i = 0; i < distTo.length; i++) {
			
	    	distTo[i] = Double.POSITIVE_INFINITY;
		}
	    
	    pq.add(new Vertex(0, 0.0));
	    distTo[0] = 0.0;
	    
	    while(!pq.isEmpty())
	    {
	    	int current = pq.poll().id;
		    visited[current] = true;

		    for (Edge e : graph[current]) {
				int w = e.to;
				if(!visited[w])
				{
					if(e.weight < distTo[w])
					{
						distTo[w] = e.weight;
						edgeTo[w] = e;
						pq.add(new Vertex(w , distTo[w]));
						
						
						
					}
					
				}
		    	
		    	
		    	
			}
	    	
	    	
	    	
	    	
	    }
	    
	    for (int i = 0; i < edgeTo.length; i++) {
			if(edgeTo[i] != null)
				pqEdge.add(edgeTo[i]);
		}
	    S--;
	    while( S-- > 0)
	    	pqEdge.poll();
	    System.out.println(String.format("%.2f", pqEdge.peek().weight ) );
		
		
		
	}
	
	

	public static void main(String[] args) throws IOException {

		




		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		Locale.setDefault(Locale.US);
		int counter = 0;

		StringTokenizer tokenizer = null;
		int N , P;
		
	    N = Integer.parseInt(reader.readLine().trim());
		while(N-- > 0)
		{
			String[] SP = reader.readLine().split("\\s+");
			S = Integer.parseInt( SP[0]);
			P = Integer.parseInt( SP[1]);
			
			Point[]  points = new Point[P];
			graph = new ArrayList[P];
			for (int i = 0; i < points.length; i++) {
				
				String[] XY = reader.readLine().split("\\s+");
				points[i] = new Point(Integer.parseInt( XY[0]), Integer.parseInt( XY[1]));

		

			}
			
			
			for (int i = 0; i < points.length; i++) {
				graph[i] = new ArrayList<>();
				for (int j = 0; j < points.length; j++) {
					
					if(i == j)
						continue;
					
					graph[i].add(new Edge(i, j, points[i].distance(points[j])));
					
					
				}
			}
			
			
//			for (int i = 0; i < graph.length; i++) {
//				System.out.println(graph[i]);
//			}
			
		//	System.out.println(Arrays.deepToString(points));
			
			Prim();
			
			
			
			
			
		}


		reader.close();
		// writer.close();
	}

}
