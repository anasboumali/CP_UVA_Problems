import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
						articulationPoints.add(current);

					if (parent[current] != -1 && disc[current] <= low[child])
						articulationPoints.add(current);

					// bridges
					// if (low[child] > disc[current])
					// System.out.println(child + " , " + current);

				} else if (child != parent[current])
					low[current] = Math.min(low[current], disc[child]);

			}

	}

	static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		 InputStream inputStream = System.in;
		//InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		StringTokenizer sToken = null;
		int n;
		int u, v;
		while (true) {

			n = Integer.parseInt(reader.readLine().trim());
			if (n == 0)
				break;
			n++;
			graph = new ArrayList[n];
			marked = new boolean[n];
			disc = new int[n];
			low = new int[n];
			parent = new int[n];

			time = 0;

			for (int i = 1; i < parent.length; i++) {
				parent[i] = -1;
				graph[i] = new ArrayList<>();

			}

			while (true) {

				sToken = new StringTokenizer(reader.readLine().trim());

				u = Integer.parseInt(sToken.nextToken());
				if (u == 0)
					break;


				while (sToken.hasMoreTokens()) {
					v = Integer.parseInt(sToken.nextToken());
					graph[u].add(v);
					graph[v].add(u);

				}

			}

//			for (int i = 0; i < graph.length; i++) {
//				if (graph[i] != null)
//					System.out.println(i + " " + graph[i]);
//			}

			for (int i = 1; i < graph.length; i++) {

				if (!marked[i])

					Tarjan(i);

			}

			writer.println(articulationPoints.size());
			articulationPoints.clear();

			// if(Integer.parseInt( line.split(" ")[0]) != 0)
			// writer.println();

		}
		reader.close();
		writer.close();
		long endTime = System.currentTimeMillis();
		// System.out.println("Took "+(endTime - startTime) + " ms");
	}

}
