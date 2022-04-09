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
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;






public class Main {

	static boolean[] visited;
	static boolean[] onStack;



	static boolean hasCycle;

	static Set<String> setOrders;

    static void findCycle(int v) {

    	visited[v] = true;
        onStack[v] = true;
        
    	if(graph[v] != null)
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

	static  boolean[] marked ;
    static ArrayList<Integer>[] graph;
	static Stack<Integer> order = new Stack<>();
	
	static void dfs (int u)
	{
		
	
		
		marked[u] = true;
		
	if(graph[u] != null)
	for (Integer v : graph[u]) {
		
		if(!marked[v])
			dfs(v);
		
	
	}
	
		order.push(u);
		
	}
	
		
	


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));



		

		int counter = 0;
		StringTokenizer sToken = null;	
		String line = null;
		int n , m;
		int u ,v;
		
		while((line = reader.readLine()) != null)
		{
		
			sToken = new StringTokenizer(line);
			n = Integer.parseInt( sToken.nextToken()); 
			m = Integer.parseInt( sToken.nextToken()); 
			if(n == 0)
					break ;
			
			graph =  new ArrayList[n+1];
			marked = new boolean[n+1];
			visited = new boolean[n+1];
			onStack = new boolean[n+1];			
			for (int i = 0; i < m; i++) 
				
			{
				
				sToken = new StringTokenizer(reader.readLine());
				u = Integer.parseInt( sToken.nextToken()); 
				v  = Integer.parseInt( sToken.nextToken()); 
				
				if(graph[u] == null)
				graph[u] = new ArrayList<>();
				
				graph[u].add(v);
				
		
			}
		for (int i = 1; i < graph.length; i++) {

				
				if(!visited[i])
					findCycle(i);
				
			}
		
		if(hasCycle)
		{
			System.out.println("IMPOSSIBLE");
		}else
		{
			
			for (int i = 1; i < graph.length; i++) {

				
				if(!marked[i])
					dfs(i);
				
			}
			
			while(!order.isEmpty())
				System.out.println(order.pop());
			
		}
		

			
			
		
			

			
			
			

			
		}

			

		

		reader.close();
		//writer.close();
	}

}
