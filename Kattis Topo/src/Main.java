import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static boolean[] visited;
	static boolean[] onStack;

	static int[] inDegree;

	static ArrayList<Integer>[] graph;

	static ArrayList<Integer> order;

	static boolean hasCycle;

	static Set<String> setOrders;

    static void findCycle(int v) {

    	visited[v] = true;
        onStack[v] = true;

        for (int w : graph[v]) {
            if(!visited[w]) {
                findCycle(w);
            } else if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }

        onStack[v] = false;
    }


	static void alltopologicalSort() {
		// To indicate whether all topological are found
		// or not
		boolean flag = false;

		for (int i = 0; i < graph.length; i++) {
			if (graph[i] == null)
				continue;

			// If indegree is 0 and not yet visited then
			// only choose that vertex
			if (inDegree[i] == 0 && !visited[i]) {
				// reducing indegree of adjacent vertices

				for (Integer u : graph[i]) {
					inDegree[u]--;
				}

				// including in result
				order.add(i);
				visited[i] = true;
				alltopologicalSort();

				// resetting visited, res and indegree for
				// backtracking
				visited[i] = false;
				order.remove(order.size() - 1);
				for (Integer u : graph[i]) {
					inDegree[u]++;
				}

				flag = true;

			}

		}

		// We reach here if all vertices are visited.
		// So we print the solution here
		if (!flag) {
			StringBuilder sbOrder = new StringBuilder();
			for (int i = 0; i < order.size() - 1; i++) {
				sbOrder.append((char) (order.get(i) + 'A') + " ");
			}

			sbOrder.append((char) (order.get(order.size() - 1) + 'A'));

			setOrders.add(sbOrder.toString());
		}
	}

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		int counter = 0;
		StringTokenizer sToken = null;
		String line = null;
		int n, m;
		int u, v;
		int T = Integer.parseInt(reader.readLine());
		final int MAX = 30;
		while (T-- > 0) {
			reader.readLine();
			sToken = new StringTokenizer(reader.readLine());

			graph = new ArrayList[MAX];
			visited = new boolean[MAX];
			onStack =  new boolean[MAX];

			inDegree = new int[MAX];
			order = new ArrayList<>();
			setOrders = new TreeSet<>();

			for (int i = 0; sToken.hasMoreTokens(); i++)

			{

				graph[(int) (sToken.nextToken().charAt(0) - 'A')] = new ArrayList<>();

			}

			sToken = new StringTokenizer(reader.readLine());
			for (int i = 0; sToken.hasMoreTokens(); i++) {

				StringTokenizer constraintToken = new StringTokenizer(sToken.nextToken(), "<");

				u = constraintToken.nextToken().charAt(0) - 'A';
				v = constraintToken.nextToken().charAt(0) - 'A';

				graph[u].add(v);
				inDegree[v]++;

			}

//			 for (int i = 0; i < graph.length; i++) {
//			 if(graph[i] != null)
//			 System.out.println( i + " : " + graph[i]);
//			 }

			hasCycle = false;

			for (int i = 0; i < graph.length; i++) {
				if (graph[i] != null)
					if (!visited[i])
						findCycle(i);

			}

			if (hasCycle)
				System.out.println("NO");
			else {
				visited = new boolean[MAX];
				alltopologicalSort();

				for (String order : setOrders) {

					System.out.println(order);
				}

			}
			
			if(T != 0)
				System.out.println();

		}

		reader.close();
		// writer.close();
	}

}
