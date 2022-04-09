import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.DISCARDING;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {




	
	
	static class Vertex implements Comparable<Vertex>
	{

		public int id ;
		public double weight;
		
		
		
		public Vertex(int id, double weight) {
		
			this.id = id;
			this.weight = weight;
		}



		@Override
		public int compareTo(Vertex o) {
			return (int) (this.weight - o.weight);
		}
		
		
		
	}
	static class Point
	{
		public int x ;
		public int y ;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	
	static class BFS {
		boolean[][] graph;
		boolean[][] marked;
		double[][] distTo;

		int[] parent ;
		int manhattan(Point p1 , Point p2)
		{
			
			return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
			
		}
		
		boolean valid(Point p)
		{
			
			if(p.x >= 0 && p.x < graph.length && p.y >= 0 && p.y < graph[0].length && !graph[p.x][p.y])
				return true ;
			
			return false;
			
			
		}
		
		
		public BFS(boolean[][] graph, Point s , Point d) {

			this.graph = graph;
			marked = new boolean[graph.length][graph[0].length];
			parent = new int[graph.length*graph[0].length];
			distTo = new double[graph.length][graph[0].length];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();

			for (int i = 0; i < parent.length; i++) {
				parent[i] = -1;
			}
			
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					
					distTo[i][j] = Double.POSITIVE_INFINITY;

				}
			}
			
			int[] X = {1 ,0, -1,   0 };
			int[] Y = {0, 1,  0 , -1};
			int indice = s.x*graph[0].length + s.y ;
			distTo[s.x][s.y] = 0;
			pq.add(new Vertex(indice , 0));
			int current ;
			while (!pq.isEmpty()) {
				current = pq.poll().id;

				if(current == d.x*graph[0].length + d.y)
					break;
				
				for (int i = 0 ; i  < 4 ; i++) {
			
					int x = current/graph[0].length;
					int y = current%graph[0].length;
					
					int dx = x + X[i];
					int dy = y + Y[i];
					
					
					
					if(!valid(new Point(dx,dy)))
						continue ;
					
				

					if(distTo[dx][dy] > distTo[x][y] + 1)
					{
						distTo[dx][dy] = distTo[x][y] + 1;
					pq.add(new Vertex(dx*graph[0].length + dy, distTo[dx][dy]));
					parent[dx*graph[0].length + dy] = current ;
					
					}
		
						
						
						
					
						
					
					
				}
				
				
			}

		}
		
		
		


	
		
		public int shortestPath(Point d)
		{
			int shortpath = 0;
			for (int i = d.x*graph[0].length + d.y ; parent[i] != -1 ; i = parent[i]) 

				
				shortpath++;
				
			
				
				
			
			return shortpath;
		}
	}

	public static void main(String[] args) throws IOException {

		




		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));



		StringTokenizer tokenizer = null;
		int N , M  , Bombs;

		boolean[][] graph = null;
		String line ;
		
		while (!( line = reader.readLine() ).equals("0 0"))  {
			
			tokenizer = new StringTokenizer(line);
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
			Bombs = Integer.parseInt(reader.readLine());

			graph = new boolean[N][M];
			
			for (int j = 0; j < Bombs; j++) {

				tokenizer = new StringTokenizer(reader.readLine());
				int row  = Integer.parseInt( tokenizer.nextToken());
				int colNumber =  Integer.parseInt( tokenizer.nextToken());
				
				for (int i = 0; i < colNumber; i++) {
					
					graph[row][Integer.parseInt( tokenizer.nextToken())] = true;
					
				}
				
		

				
			}
			
			
			tokenizer = new StringTokenizer(reader.readLine());
			Point s = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
			tokenizer = new StringTokenizer(reader.readLine());
			Point d = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
			
			
			BFS bfs =  new BFS(graph, s, d);
			System.out.println(bfs.shortestPath(d));
			

//			for (int i = 0; i < N ;i++) {
//				
//				for (int j = 0; j < M; j++) {
//					
//					System.out.print(graph[i][j] ? 1 : 0);
//				}
//				System.out.println();
//			}



		}

		reader.close();
		// writer.close();
	}

}
