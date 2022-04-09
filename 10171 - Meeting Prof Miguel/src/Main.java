import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {


	static class Edge {

		public int from;
		public int to;
		public double weight;
		public char age ;
		public Edge(int from, int to, double weight , char age) {
			this.from = from;
			this.to = to;
			this.weight = weight;
			this.age = age;

		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + ", age=" + age + "]";
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
		
		public Dijkstra(List<Edge>[] graph, int s,char forbiddenAge) {

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
				
			
				

				if(graph[current] != null)
				for (Edge neighbor : graph[current]) {
					
					if(neighbor.age == forbiddenAge)
						continue;
					
				//	System.out.println(neighbor);
					
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


		int counter = 0;

		StringTokenizer tokenizer = null;
		
		int Miguel , Manzoor ;
		
		
		

		
		List<Edge>[] graph = null;
		int E = Integer.parseInt( reader.readLine());

		while(true) {
			if( E == 0)
				break;
			
			graph = new ArrayList[30];
			for (int j = 0; j < E; j++) {

				tokenizer = new StringTokenizer(reader.readLine());
				char age = tokenizer.nextToken().trim().charAt(0);
				char streetType = tokenizer.nextToken().trim().charAt(0);
				int u = tokenizer.nextToken().trim().charAt(0);
				int v = tokenizer.nextToken().trim().charAt(0);
				double w = Double.parseDouble(tokenizer.nextToken());
				
				u -= 'A';
				v -= 'A';
				if( graph[u] == null)
					graph[u] = new ArrayList<>();
				
				if(streetType == 'B' && graph[v] == null)
					graph[v] = new ArrayList<>();
				
				graph[u].add(new Edge(u,v,w,age));
				
				if(streetType == 'B')
				graph[v].add(new Edge(v,u,w,age));

				
			}
			String migAndManz= reader.readLine();
			Miguel =  (migAndManz.charAt(0) - 'A');
			Manzoor =  (migAndManz.charAt(2) -  'A');
			
//			if(Miguel == Manzoor)
//			{
//						System.out.print("0 " + (char)(Miguel + (int)'A'));
//						E = Integer.parseInt( reader.readLine());
//						if(E != 0)
//							System.out.println();
//						
//						continue;
//
//			}

			Dijkstra dijkstraM = new Dijkstra(graph ,Miguel , 'M');
			Dijkstra dijkstraY = new Dijkstra(graph ,Manzoor , 'Y');

			double minEnergy = Double.POSITIVE_INFINITY ;


			Set<Character> minPlace = new TreeSet<>();
			
			



			for (int j = 0; j < 28; j++) {
				
				
//				if(graph[j] == null)
//					continue;
				
				double distM = dijkstraM.distTo[j];
				double distY = dijkstraY.distTo[j];

				if(distM < Double.POSITIVE_INFINITY && distY < Double.POSITIVE_INFINITY)
				{
					
					if(distM + distY < minEnergy)
					{
						minEnergy = distM + distY;
						minPlace.clear();
						minPlace.add( (char)(j + (int)'A'));
						
					}else if(distM + distY == minEnergy)
						minPlace.add( (char)(j + (int)'A'));

					
				}
					
			}
		
			 if(minEnergy < Double.POSITIVE_INFINITY)
			{
				System.out.println((int)minEnergy + " " + minPlace.toString().replaceAll("[\\[\\],]", ""));
			}else
				System.out.println("You will never meet.");

			 E = Integer.parseInt( reader.readLine());
			 
//			 if(E != 0)
//				 System.out.println();
			 
		}

		reader.close();
		// writer.close();
	}

}
