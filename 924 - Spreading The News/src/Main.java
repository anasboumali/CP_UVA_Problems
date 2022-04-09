import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;



import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {

	
	static class Vertex {

		public int id;
		public int level;

		public Vertex(int id, int level) {

			this.id = id;
			this.level = level;
		}



	}
	
	static class BFS
	{
		
		public boolean[] marked ;
		public int D;
		public int M;

	
		
		public int[] boomByLevel ;
		
		public BFS(Set<Vertex>[] graph , int source) {
			
			marked  = new boolean[graph.length];
			boomByLevel =  new int[graph.length];
			
			for (int i = 0; i < graph.length; i++) {
				boomByLevel[i] =  -1;
			}
			
			Queue<Vertex> queue = new LinkedList<>();
			
			queue.add(new Vertex(source, 0));
			
			while(!queue.isEmpty())
			{
				Vertex current = queue.poll();
				marked[current.id] = true;
				
				for (Vertex neighbor : graph[current.id]) {
					
					if(!marked[neighbor.id])
					{
						neighbor.level = current.level + 1;
						marked[neighbor.id]  = true;
						boomByLevel[neighbor.level]++;
						
						queue.add(neighbor);
						
						
					}
					
				}

				
			}
			
			 D = -1 ;
			 M = -1;
			for (int i = 0; i < boomByLevel.length; i++) {
				if(boomByLevel[i] != -1)
				{
					
					if(boomByLevel[i]  >  M)
					{
						 D = i;
						 M = boomByLevel[i] ;
						
					}
				}
			}


		}
		
	}
	


	public static void main(String[] args) throws NumberFormatException, IOException   {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		Locale.setDefault(new Locale("EN", "US"));
		
		
		
		StringTokenizer tokenizer = null;

		Set<Vertex>[] graph = null;
		String E_str ;
		while ((E_str = reader.readLine()) != null) {

			int E = Integer.parseInt(E_str);
			int nbrQuery ;
			int source ;
			graph = new HashSet[2500];
			
			for (int i = 0; i < E; i++) {
				graph[i] = new HashSet<>();
				tokenizer = new StringTokenizer(reader.readLine());
				int friends = Integer.parseInt(tokenizer.nextToken());
				for (int j = 0; j < friends; j++) {
					
					graph[i].add( new Vertex(Integer.parseInt(tokenizer.nextToken()), 0) );
				}
					
				
			}
			
//			for (int i = 0; i < graph.length; i++) {
//				if(graph[i] != null)
//				System.out.println(graph[i]);
//
//			}
			
			nbrQuery = Integer.parseInt(reader.readLine());
			
			
			for (int i = 0; i < nbrQuery; i++) {
				
				source = Integer.parseInt(reader.readLine());
				

			
				
				BFS bfs  = new BFS(graph, source);
				if(bfs.D != -1)
				System.out.println((bfs.M + 1) + " " + bfs.D);
				else
					System.out.println(0);
				
				
				
				
				
				
				
			}

		


			}
			
		





		reader.close();
		// writer.close();
	}

}
