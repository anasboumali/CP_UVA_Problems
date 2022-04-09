import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	
	
	static final int MAX = 10000;
	static boolean[] marked = new boolean[MAX];
	static List<Integer>[] graph = new ArrayList[MAX];
	static List<Integer>[] revGraph =  new ArrayList[MAX];

	static boolean[] inStack =  new boolean[MAX];
	static Deque<Integer> stack = new ArrayDeque<>();
	static List<Integer> [] SCC  = new ArrayList[MAX];
	static int[] disc =  new int[MAX];
	static int[] low =  new int[MAX];
	static int time;
	static int nbrSCC ;

static void Tarjan(int u) {
 		
 		disc[u] =  low[u] = ++time;
 		stack.push(u);
		marked[u] = true;
		inStack[u] = true;
		if (graph[u] != null)
			for (Integer v : graph[u]) {

				if (!marked[v]) {
					
										
					Tarjan(v);
					low[u] = Math.min(low[v], low[u]);
					
				} else if(inStack[v])
					low[u] = Math.min(low[v], low[u]);

			}
		
		
		if(low[u] == disc[u])
		{
			List<Integer> scc = new ArrayList<>();
			while(stack.peek() != u)
			{
				inStack[stack.peek()] = false;
				scc.add(stack.pop());
			}
			
			inStack[stack.peek()] = false;
			scc.add(stack.pop());
			
			SCC[nbrSCC++] = scc;

			
		}

	}
	
	


	


	public static void main(String[] args) throws IOException {
		
		 PrintWriter writer = new PrintWriter(new BufferedWriter(new
				 OutputStreamWriter(System.out)));
	//	long startTime = System.currentTimeMillis();

	   InputStream inputStream = System.in;
	//	InputStream inputStream = new FileInputStream("in.txt");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	
		StringTokenizer sToken = null;
		
		int n, m;
		int u ,v;
		int T = Integer.parseInt( reader.readLine().trim());
		
		while (T-- > 0) {

			
			sToken = new StringTokenizer(reader.readLine().trim());
			n = Integer.parseInt(sToken.nextToken());
		
			m = Integer.parseInt(sToken.nextToken());
			n++;	
			
//			graph = new ArrayList[n];
//			revGraph = new ArrayList[n];
//			SCC = new ArrayList[n];
//			marked = new boolean[n];
//			disc = new int[n];
//			low = new int[n];
//			inStack = new boolean[n];
			
			Arrays.fill(graph, null);
			Arrays.fill(revGraph, null);
			Arrays.fill(SCC, null);
			Arrays.fill(marked, false);
			Arrays.fill(inStack, false);
			Arrays.fill(low, 0);
			Arrays.fill(disc, 0);

			
			
			

			time = 0;
			nbrSCC = 0;
			for (int i = 0; i < m; i++)

			{

				sToken = new StringTokenizer(reader.readLine().trim());
				
				u = Integer.parseInt( sToken.nextToken());
				v = Integer.parseInt( sToken.nextToken());
				
				if(graph[u] == null)
					graph[u] = new ArrayList<>();
					
				
				if(revGraph[v] == null)
					revGraph[v] = new ArrayList<>();
				
				graph[u].add(v);
				
				revGraph[v].add(u);
				

				
				
				
			}
			
			
			for (int i = 1; i < n; i++) {
				
				if(!marked[i])
		
				{
					Tarjan(i);

				}
				
			}
			
			
//			for (int i = 0; i < SCC.size(); i++) {
//				System.out.println(SCC.get(i));
//			}
			
//			writer.println("case : ");
//			for (int i = 0; i < revGraph.length; i++) {
//				
//				if(revGraph[i] != null)
//					writer.println(i + " : " + revGraph[i]);
//				
//			}
			
			
			int indegree = 0;//knocks
			boolean SCChasInDegree ;
			for (int i = 0; i < nbrSCC; i++) {
				SCChasInDegree = false;
		
				for (Integer w : SCC[i]) {
					if(revGraph[w] != null)
					for (Integer y : revGraph[w]) {
						
						if(!SCC[i].contains(y))
						{
							SCChasInDegree = true;
							break;
						}
							
					}
					if(SCChasInDegree)
						break;
					
				}
				
				if(!SCChasInDegree)
						indegree++;

		}		
			
			writer.println(indegree);
			
			stack.clear();
			
	}

	//	long endTime = System.currentTimeMillis();
		//writer.println("Took " +(endTime - startTime) + " ms");
		reader.close();
		 writer.close();
}
	
}
