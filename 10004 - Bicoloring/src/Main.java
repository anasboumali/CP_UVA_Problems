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
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean[] marked;
	static boolean[] color;
	static ArrayList<Integer>[] graph;

	static boolean isTwoColorable = true;

	static void dfs(int u) {

		marked[u] = true;

		if (graph[u] != null)
			for (Integer v : graph[u]) {

				if (!marked[v]) {
					
					color[v] = !color[u];

					dfs(v);

				} else if (color[v] == color[u])
					isTwoColorable = false;

			}

	}

	public static void main(String[] args) throws IOException {

	    InputStream inputStream = System.in;
		//InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		int counter = 0;
		StringTokenizer sToken = null;
		String line = null;
		int n, m;
		int u, v;

		while (true) {

			n = Integer.parseInt(reader.readLine().trim());
			if (n == 0)
				break;

			m = Integer.parseInt(reader.readLine().trim());

			graph = new ArrayList[n ];
			marked = new boolean[n];
			color = new boolean[n ];
			for (int i = 0; i < m; i++)

			{

				sToken = new StringTokenizer(reader.readLine().trim());
				u = Integer.parseInt(sToken.nextToken());
				v = Integer.parseInt(sToken.nextToken());

				if (graph[u] == null)
					graph[u] = new ArrayList<>();

				graph[u].add(v);

			}

			// System.out.println(graph[0]);

			// is Tow-colorable - bipartite

			dfs(0);

			if (isTwoColorable)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");

			isTwoColorable = true;
		}

		reader.close();
		// writer.close();
	}

}
