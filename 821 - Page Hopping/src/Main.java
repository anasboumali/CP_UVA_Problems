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
import java.util.Locale;
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

	static class Vertex implements Comparable<Vertex> {

		public int id;
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

		public Dijkstra(List<Edge>[] graph, int s) {

			this.graph = graph;
			edgeTo = new Edge[graph.length];
			distTo = new double[graph.length];
			marked = new boolean[graph.length];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			for (int i = 0; i < graph.length; i++) {
				distTo[i] = Double.POSITIVE_INFINITY;
			}

			distTo[s] = 0.0;
			pq.add(new Vertex(s, 0.0));
			int current;
			int w;
			while (!pq.isEmpty()) {
				current = pq.poll().id;

				if (graph[current] != null)
					for (Edge neighbor : graph[current]) {

						// System.out.println(neighbor);

						w = neighbor.to;

						if (distTo[w] > distTo[current] + neighbor.weight) {

							distTo[w] = distTo[current] + neighbor.weight;
							edgeTo[w] = neighbor;

							pq.add(new Vertex(w, distTo[w]));
						}

					}
			}

		}

		public double distTo(int v) {
			return distTo[v];

		}

		public boolean hasPathTo(int v) {
			return distTo[v] < Double.POSITIVE_INFINITY;

		}

		public List<Edge> pathTo(int v) {
			if (!hasPathTo(v))
				return null;
			Stack<Edge> stack = new Stack<>();
			for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from]) {
				stack.push(e);
			}

			return new ArrayList<>(stack);

		}
	}

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		Locale.setDefault(new Locale("EN", "US"));
		
		int counter = 0;

		StringTokenizer tokenizer = null;

		List<Edge>[] graph = null;

		while (true) {

			graph = new ArrayList[101];
			int nbrVertices = 0;
			int nbrPairs = 0;
			String line = reader.readLine();

			if (line.trim().equals("0 0"))
				break;

			tokenizer = new StringTokenizer(line);

			while (true) {

				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());

				if (u + v == 0)
					break;

				if (graph[u] == null)
				{
					graph[u] = new ArrayList<>();
					nbrVertices++;
				}

				graph[u].add(new Edge(u, v, 1));
			}
			
			nbrPairs = nbrVertices*(nbrVertices - 1);
			
			
			
			
			int sumPathLenght = 0;

//			System.out.println(nbrVertices);
		for (int i = 1; i < graph.length; i++) {
			if (graph[i] != null)
			{
				Dijkstra dijkstra =  new Dijkstra(graph, i);
			
				for (int j = 0; j < graph.length; j++) {
					if(dijkstra.distTo(j) < Double.POSITIVE_INFINITY)
					{
						sumPathLenght += dijkstra.distTo(j);
					}
				}
				

			}

			

		}
		

			System.out.println("Case " + ++counter +": average length between pages = "+ String.format("%.3f", (double)sumPathLenght/nbrPairs) +" clicks");
			
			
		
		}



		reader.close();
		// writer.close();
	}

}
