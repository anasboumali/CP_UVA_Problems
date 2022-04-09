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
    static int Black ;
    static int White ;

	static void dfs(int u) {

		marked[u] = true;
		
		if(color[u])
			White++;
		else
			Black++;
	
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
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		int counter = 0;
		StringTokenizer sToken = null;
		String line = null;
		int n, m;
		int u, v;
		int T = Integer.parseInt( reader.readLine());
		
		for (int j = 1; j <= T; j++) 
			
		{
			sToken = new StringTokenizer(reader.readLine().trim());

			n = Integer.parseInt(sToken.nextToken());
			m = Integer.parseInt(sToken.nextToken());

			graph = new ArrayList[n];
			marked = new boolean[n];
			color = new boolean[n];
			
			
			for (int i = 0; i < graph.length; i++) {
				
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++)

			{

				sToken = new StringTokenizer(reader.readLine().trim());
				u = Integer.parseInt(sToken.nextToken());
				v = Integer.parseInt(sToken.nextToken());

		

				graph[u].add(v);

				graph[v].add(u);

			}
			
//			if(j == 6)
//			{
//				System.out.println(n);
//				System.out.println(m);
//
//						 for (int i = 0; i < graph.length; i++) {
//				 
//				if(graph[i] != null)
//				 System.out.println(i + " " + graph[i]);
//			}
//			}
	
		
			
			int guards = 0;
			for (int i = 0; i < graph.length; i++) {
		
				if(!marked[i])
				{
					Black = 0 ;
					White = 0;
					dfs(i);
					
					if(Black + White == 1)
						guards++;
					else
						guards += Math.min(Black, White);
					
					
				}

			}
		
		

				
			if (isTwoColorable)
				System.out.println(guards );
			else
				System.out.println("-1");

			isTwoColorable = true;

		}

		reader.close();
		// writer.close();
	}

}
