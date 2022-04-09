import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;




public class Main {

	
	static Set<Integer> visited ;
	static Map<Integer , ArrayList<Integer>> graph ;
	static boolean tree ;
	static void dfs(int u)
	{
		
		visited.add(u);
		
		if(graph.containsKey(u))
		for (Integer v : graph.get(u)) {
			
			if(visited.contains(v))
			{
				tree =  false;
			}
			
			 dfs(v);
			
		} 
			
		
	}
	

	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		 InputStream inputStream = new FileInputStream("in.txt");

//			 reader = new BufferedReader(new InputStreamReader(inputStream));
		
		 Scanner in  = new Scanner(inputStream);
		 boolean end = false;
		 Map<Integer , Integer> indegree = null  ;
		 int counter = 1;
		 
		 
		while(in.hasNext())
		{
//			String pair ;
			int u ,v ;
			
		    indegree  = new HashMap<>();
		    graph = new HashMap<>();
		    visited = new HashSet<>();
			while(in.hasNext())
			{
				u = in.nextInt();
				v = in.nextInt();
				
				if(v + u == 0)
					break;
				
				if(v < 0)
				{
					end = true;
					break;
				}
				

//				System.out.println( u + " " + v);
				
				if(!graph.containsKey(u))
					graph.put(u, new ArrayList<>());
					
					graph.get(u).add(v);
				
			
				
				
				if(!indegree.containsKey(u))
					indegree.put(u, 0);
				
				if(!indegree.containsKey(v))
					indegree.put(v, 0);
				
				
				indegree.put(v, indegree.get(v)+ 1);
				
				//				System.out.println(indegree[v]);
				
				
				
				
			}

			
		if(end)
			break;
		
		int howManyRoot = 0;
		 tree = true;
		int keyRoot = 0 ;
		for (Integer key  : indegree.keySet()) {
			
		
			if(indegree.get(key) > 1)
			{
				tree = false;
				break;
			}
			
			if(indegree.get(key) == 0)
			{
				keyRoot = key;
				howManyRoot++;
				
			}
			
	
			
		}
		if(indegree.size() == 0)
			tree  = true;
		else if(howManyRoot != 1)
		{
			tree = false;
		}
		else
		{
//			System.out.println(keyRoot + " val : " + graph.get(keyRoot).get(0));
			dfs(keyRoot);
//			System.out.println(keyRoot);
//			System.out.println(tree);
//			System.out.println(visited);
			if(tree)
			for (Integer key  : indegree.keySet()) {
				
				if(!visited.contains(key))
				{
					tree = false;
					break;
					
				}
		
				
			}
			
			
			
		}
			
//		System.out.println(howManyRoot);
	
		
			System.out.println("Case "+ counter++ + " is "+  (tree  ? "a" : "not a")+  " tree.");
		


	}
		
		
		
	}

}
