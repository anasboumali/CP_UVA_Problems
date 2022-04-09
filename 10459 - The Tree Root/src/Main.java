import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;






public class Main {
	
	
	
	static HashSet<Integer>[] graph ;
	
	static boolean[] visisted ;
	static int[] distance ;
	static int best  , worst  ;
	

	static int firstMax ;
	static int secondMax;
	static int nodeThatGiveMax;
	static int root;
	static void dfs_increment(int u , boolean maxPath , int parent)
	{

		if(maxPath)
		distance[u] = Math.max(firstMax - distance[u], secondMax + distance[u]);
		else
			distance[u]+= firstMax;
		
		
		if(distance[u] < best)
			best   = distance[u];
		
		for (Integer v : graph[u]) {
			
			if(v == parent)
				continue;
						
			dfs_increment(v, maxPath, u);
						
		}
	}
	
	static int dfs(int u , int level ,int parent)
	{
		

		
		distance[u] = level;
		int max  = level;
		for (Integer v : graph[u]) {
			
			if(v == parent)
				continue;
			
			int dist = dfs(v, level + 1, u);
			
			if(u == root)
			{
				if(dist > firstMax)
				{
					secondMax = firstMax;
					firstMax = dist;
					nodeThatGiveMax = v;
				}
				else if(dist > secondMax)
					secondMax = dist;
			}else
			{
				if( dist > max)
					max = dist ;

			}

						
		}
		
		
		
		if(root == u)
		{
			distance[u] = firstMax;
			worst = secondMax + firstMax;
			best = distance[u];
			
			for (Integer v : graph[u]) {
				
				if(v == nodeThatGiveMax)
					dfs_increment(v, true, u);
				else
					dfs_increment(v, false, u);
			}
		}
		
		return max;
		

		
		
	}
	
	
	public static void main(String[] args) throws IOException {

		

		
//		InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		Scanner in  = new Scanner(inputStream);
		
	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


		int[] degree ;
		String line ;
		int N;
		while(in.hasNext())
			
		{
			
		
			N =	in.nextInt();				
	
			
			N++;
			
			graph = new HashSet[N];
			degree = new int[N];
			visisted = new boolean[N];
			distance = new int[N];
			
			root = 0;
			int maxRoot = 0;
			for (int i = 1;  i < N; i++) {
				

				graph[i] = new HashSet<>();
				int k =	in.nextInt();				

				while(k-- > 0)
				{
					
					int v = in.nextInt();				
					
					if(graph[v] == null)
						graph[v] = new HashSet<>();
					
					graph[i].add(v);
					graph[v].add(i);

					degree[i]++;
					
					if(degree[i] > maxRoot)
					{
						root = i;
						maxRoot = degree[i];
					}
					
					
					
					
					
				}
				
		

				
				
				
				
				
				
				
			}
//			System.out.println(Arrays.toString(degree));
//			System.out.println(root + " " + maxRoot);
			firstMax = 0;
			secondMax = 0;
			nodeThatGiveMax = 0;
			best = Integer.MAX_VALUE;
			worst = 0;
			
			
			
			
			dfs(root , 0 , 0);
			List<Integer> bestRoots = new ArrayList<>();
			List<Integer> worstRoots = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				
				if(distance[i] == best)
					bestRoots.add(i);
				else if (distance[i] == worst)
					worstRoots.add(i);
				
			}
			
			System.out.println("Best Roots  : " + bestRoots.toString().replaceAll("[\\[\\],]", ""));
			System.out.println("Worst Roots : " + worstRoots.toString().replaceAll("[\\[\\],]", ""));
			


			
			
			
			
		}
		
		
		//writer.close();
	
		
	}

}
