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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static boolean[] marked;
	static Set<Integer>[] graph;
	static boolean[] inStack ;
	static Stack<Integer> stack = new Stack<>();

	static int[] disc ;
	static int[] low ;
	static int time;
	
	static  Map<String , Integer> nameToNbr;
	static  Map<Integer , String> nbrToName;

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
			while(stack.peek() != u)
			{
				inStack[stack.peek()] = false;
				
				writer.print( nbrToName.get(stack.pop()) + ", ");
			}
			
			inStack[stack.peek()] = false;
			writer.println(nbrToName.get(stack.pop()));
			
			
		}

	}
	static PrintWriter writer = new PrintWriter(new BufferedWriter(new
			 OutputStreamWriter(System.out)));

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

	    InputStream inputStream = System.in;
		//InputStream inputStream = new FileInputStream("in.txt");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	
		int counter = 0;
		StringTokenizer sToken = null;
		
		int n, m;
		String u ,v;
		String line = null;
		line = 	reader.readLine().trim();
		while (true) {

			
			sToken = new StringTokenizer(line);
			n = Integer.parseInt(sToken.nextToken());
			if (n == 0)
				break;
			m = Integer.parseInt(sToken.nextToken());
			n++;
			graph = new HashSet[n];
			marked = new boolean[n];
			disc = new int[n];
			low = new int[n];
			inStack = new boolean[n];
			time = 0;
			nameToNbr = new HashMap<>();
			
			for (int i = 0; i < m; i++)

			{

				sToken = new StringTokenizer(reader.readLine().trim());
				
				u = sToken.nextToken();
				v = sToken.nextToken();
				
				if(!nameToNbr.containsKey(u))
					nameToNbr.put(u, nameToNbr.size() + 1);
				
				if(!nameToNbr.containsKey(v))
					nameToNbr.put(v, nameToNbr.size() + 1);
				
				
				if(graph[nameToNbr.get(u)] == null)
					graph[nameToNbr.get(u)] = new HashSet<>();
				
				
				graph[nameToNbr.get(u)].add(nameToNbr.get(v));
				
				
				
			}
			
			
			//mapping matters ex : 1 => Paul
			nbrToName =	nameToNbr.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue,Map.Entry::getKey));
			

			
			writer.println("Calling circles for data set "+ ++counter +":");
			
			for (int i = 1; i < graph.length; i++) {
				
				if(!marked[i])
		
					Tarjan(i);
				
			}
			
			line = reader.readLine().trim();
			if(Integer.parseInt( line.split(" ")[0]) != 0)
				writer.println();
			
	}
		reader.close();
		 writer.close();
		long endTime = System.currentTimeMillis();
		//System.out.println("Took "+(endTime - startTime) + " ms"); 
}
	
}
