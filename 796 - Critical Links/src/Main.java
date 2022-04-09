import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	
	static class Edge 
	{
		int u ;
		int v;
		
		public Edge(int u, int v) {
			
			this.u = u;
			this.v = v;
		}

		public int getU() {
			return u;
		}

		public int getV() {
			return v;
		}


		
	}
	
	static boolean[] marked;
	static Set<Integer>[] graph;
	static int[] parent;
	static List<Edge> bridges  = new ArrayList<>();

	static int[] disc;
	static int[] low;
	static int time;

	static void Tarjan(int current) {

		int children = 0;
		disc[current] = low[current] = ++time;
		marked[current] = true;

		if (graph[current] != null)
			for (Integer child : graph[current]) {

				if (!marked[child]) {

					parent[child] = current;
					children++;
					Tarjan(child);
					low[current] = Math.min(low[child], low[current]);

					// bridges
					if (low[child] > disc[current])
						bridges.add(new Edge(Math.min(child, current),Math.max(child, current)));

					// System.out.println(child + " ," + current);

				} else if (child != parent[current])
					low[current] = Math.min(low[current], disc[child]);

			}

	}

	static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) throws IOException {
		
		
		

		
		
		

		
		
		
		long startTime = System.currentTimeMillis();

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;

		StringTokenizer sToken = null;
		int n;
		int u, v;
		while ((line = reader.readLine()) != null) {

			n = Integer.parseInt(line.trim());

			graph = new HashSet[n];
			marked = new boolean[n];
			disc = new int[n];
			low = new int[n];
			parent = new int[n];

			time = 0;

			for (int i = 0; i < parent.length; i++) {
				parent[i] = -1;
				graph[i] = new HashSet<>();

			}

			for (int i = 0; i < n; i++) {

				sToken = new StringTokenizer(reader.readLine().trim());

				u = Integer.parseInt(sToken.nextToken());

				sToken.nextToken();

				while (sToken.hasMoreTokens()) {
					v = Integer.parseInt(sToken.nextToken());
					graph[u].add(v);
					
				}

			}

//			for (int i = 0; i < graph.length; i++) {
//				if (graph[i] != null)
//					writer.println(i + " " + graph[i]);
//			}

			for (int i = 1; i < graph.length; i++) {

				if (!marked[i])

					Tarjan(i);

			}

			bridges.sort(new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					if(o1.u < o2.u )
						return -1;
					else if(o1.u > o2.u )
						return 1;
					
					if(o1.v < o2.v)
						return -1 ;
					else if(o1.v > o2.v)
						return  1 ;
					
					return 0;				
				}
				
				
			});
			
			
			writer.println(bridges.size() + " critical links");
			for (int i = 0; i < bridges.size() - 1; i++) {
				
				writer.println(bridges.get(i).u + " - " + bridges.get(i).v);
			} 
				
			
//			reader.readLine();
//			writer.println();
			
			if(reader.readLine() != null)
			{
				if(!bridges.isEmpty())
				writer.println(bridges.get(bridges.size() - 1).u + " - " + bridges.get(bridges.size() - 1).v);

				writer.println();
			}else
				if(!bridges.isEmpty())
				writer.print(bridges.get(bridges.size() - 1).u + " - " + bridges.get(bridges.size() - 1).v);

			
			bridges.clear();
			


		}
		reader.close();
		writer.close();
		long endTime = System.currentTimeMillis();
		// System.out.println("Took "+(endTime - startTime) + " ms");
	}

}
