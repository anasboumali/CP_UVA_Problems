import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static boolean[] marked;
	static List<Integer>[] graph;
	static int[] parent;
	static Set<Integer> articulationPoints = new HashSet<>();

	static int[] disc;
	static int[] low;
	static int time;
    static int[] bridges ;
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

					// articulations points
					
					if (parent[current] == -1 && children > 1)
					{
								articulationPoints.add(current);
					}
						

					if (parent[current] != -1 && disc[current] <= low[child])
					{
						       articulationPoints.add(current);
					}

					// bridges
					 if (low[child] > disc[current])
					 {
					//	 System.out.println(child + "," + current);
						 
						 bridges[child]++;
						 bridges[current]++;

			
					 }
					 
//					 System.out.println(child + " , " + current);

				} else if (child != parent[current])
					low[current] = Math.min(low[current], disc[child]);

			}

	}

	static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	
	static class Station implements Comparable<Station>
	{
		
		int id ;
		int pigeonValue;
		
		public Station(int id, int pigeonValue) {
			this.id = id;
			this.pigeonValue = pigeonValue;
		}

		@Override
		public String toString() {
			return "Station [id=" + id + ", pigeonValue=" + pigeonValue + "]";
		}

		@Override
		public int compareTo(Station o) {
			
			if(o.pigeonValue < pigeonValue)
				return -1;
			else if (o.pigeonValue > pigeonValue)
				return 1;
			
			return -1*(o.id - id) ;
			

		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		PriorityQueue<Station> pq ;
		StringTokenizer sToken = null;
		int count = 0;
		int n , m;
		int u, v;
		while (true) {
			String[] first = reader.readLine().split("\\s+");
			n = Integer.parseInt(first[0]);
			m = Integer.parseInt(first[1]);

			if (n == 0)
				break;
			
			graph = new ArrayList[n];
			marked = new boolean[n];
			disc = new int[n];
			low = new int[n];
			parent = new int[n];
			bridges = new int[n];
			time = 0;

			for (int i = 0; i < parent.length; i++) {
				parent[i] = -1;

			}

			while (true) {

				sToken = new StringTokenizer(reader.readLine().trim());

				u = Integer.parseInt(sToken.nextToken());
				v = Integer.parseInt(sToken.nextToken());

				if (u == -1)
					break;

				if(graph[u] == null)
					graph[u] = new ArrayList<>();
				
				if(graph[v] == null)
					graph[v] = new ArrayList<>();

					graph[u].add(v);
					graph[v].add(u);

				

			}

//			for (int i = 0; i < graph.length; i++) {
//				if (graph[i] != null)
//					System.out.println(i + " " + graph[i]);
//			}

			for (int i = 0; i < graph.length; i++) {

				if (!marked[i])

					Tarjan(i);

			}
			
			pq = new PriorityQueue<Station>();
			
			for (Integer articlPoint : articulationPoints)
			{
		
				if(bridges[articlPoint] == 0)
					pq.add(new Station(articlPoint, 2));

			else if(graph[articlPoint].size() > bridges[articlPoint])
					pq.add(new Station(articlPoint,  bridges[articlPoint] +  1));
				else
					pq.add(new Station(articlPoint, bridges[articlPoint] ));
				
	
			}
			
			int initialSize = pq.size();
			for (int i = 0 , k = 0; i < m - initialSize ;k++) {

				if(!articulationPoints.contains(k))
				{
					pq.add(new Station(k, 1));
					
					i++;
				}
			}
			
	
for	 ( int i = 0 ;  !pq.isEmpty() && i < m ; i++) {

	Station s = pq.poll();
	
writer.println(s.id + " " + s.pigeonValue);


	}

	

		
		writer.println();

	articulationPoints.clear();

	

		}
	
		reader.close();
		writer.close();
		// System.out.println("Took "+(endTime - startTime) + " ms");
	}

}
