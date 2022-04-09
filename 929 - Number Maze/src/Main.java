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
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class Main {

	
	
	static class IndexMinPQ {
	    private int maxN;        // maximum number of elements on PQ

	    private int n;           // number of elements on PQ
	    private int[] pq;        // binary heap using 1-based indexing
	    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
	    private double[] keys;      // keys[i] = priority of i
	    
	    public IndexMinPQ(int maxN) {
	        if (maxN < 0) throw new IllegalArgumentException();
	        this.maxN = maxN;
	        n = 0;
	        keys =  new double[maxN + 1];    // make this of length maxN??
	        pq   = new int[maxN + 1];
	        qp   = new int[maxN + 1];                   // make this of length maxN??
	        for (int i = 0; i <= maxN; i++)
	            qp[i] = -1;
	    }
		
	    
	    public boolean isEmpty() {
	        return n == 0;
	    }
	    
	    public boolean contains(int i) {
	        return qp[i] != -1;
	    }
	    
	    public int size() {
	        return n;
	    }
	    
	    public void insert(int i, double key) {
	        n++;
	        qp[i] = n;
	        pq[n] = i;
	        keys[i] = key;
	        swim(n);
	    }
	    
	    public int delMin() {
	        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
	        int min = pq[1];
	        exch(1, n--);
	        sink(1);
	        qp[min] = -1;        // delete
	        return min;
	    }
	    
	    public void decreaseKey(int i, double key) {
	     
	        keys[i] = key;
	        swim(qp[i]);
	    }
	    
	    private void swim(int k) {
	        while (k > 1 && keys[pq[k/2]] > keys[pq[k]]) {
	            exch(k, k/2);
	            k = k/2;
	        }
	    }
	    
	    private void sink(int k) {
	        while (2*k <= n) {
	            int j = 2*k;
	            if (j < n && keys[pq[j]] > keys[pq[j+1]]) j++;
	            if (keys[pq[k]] <= keys[pq[j]]) break;
	            exch(k, j);
	            k = j;
	        }
	    }
	    
	    private void exch(int i, int j) {
	        int swap = pq[i];
	        pq[i] = pq[j];
	        pq[j] = swap;
	        qp[pq[i]] = i;
	        qp[pq[j]] = j;
	    }
	    
	    
	    
	    
	    
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static class Edge {

		public int from;
		public int to;
		public double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;

		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		
		
	}

	static class Dijkstra {
		//List<Edge>[] graph;
		int[][] graph;
		Edge[] edgeTo;
		double[] distTo;
		boolean[] marked;
		
		boolean validPosition (int i , int j)
		{
			return i < graph.length && i >= 0 && j < graph[0].length && j >= 0; 
			
		}
		
		
		public Dijkstra(int[][]  graph, int s ,int t ,int weightSource) {

			this.graph = graph;
			edgeTo = new  Edge[graph.length];
			distTo = new double[graph.length*graph[0].length];
			marked = new boolean[graph.length];
			IndexMinPQ pq = new IndexMinPQ(graph.length*graph[0].length);

			for (int i = 0; i < graph.length*graph[0].length; i++) {
				distTo[i] = Double.POSITIVE_INFINITY;
			}

			distTo[s] = weightSource;
			pq.insert(s, weightSource);
			int current ;
			int dx;
			int dy;

			int[] x = {0,0,-1,1};
			int[] y = {1,-1,0,0};
			
			while (!pq.isEmpty()) {
				
				
				current = pq.delMin();
				if(current == t)
					break;
				
				
			
				for (int neighbor = 0 ; neighbor < 4 ;neighbor++) {
					
					int i = current/graph[0].length;
					int j = current%graph[0].length;
					
					dx =  i + x[neighbor];
					dy =  j + y[neighbor];
					
					if(!validPosition(dx, dy))
						continue;
					
					int w = graph[0].length*dx + dy;
					if(distTo[w] > distTo[current] + graph[dx][dy])
					{
						
						distTo[w] = distTo[current] + graph[dx][dy];
						
						if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
						else pq.insert(w, distTo[w]);
						
						//pq.insert(w, distTo[w]);
					}
					
					
				}
			}

		}
		
		
		
		public double distTo(int v)
		{
			return distTo[v];
			
		}

		public boolean hasPathTo(int v)
		{
			return distTo[v] < Double.POSITIVE_INFINITY;
			
		}
		
		public List<Edge> pathTo(int v)
		{
			if(!hasPathTo(v)) return null;
			Stack<Edge> stack = new Stack<>();
			for(Edge e = edgeTo[v] ; e != null ; e = edgeTo[e.from])
			{
				stack.push(e);
			}
			
			
			
			return new ArrayList<>(stack);
			
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		




		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));

		int nbrCases = Integer.parseInt(reader.readLine().trim());

		int counter = 0;

		StringTokenizer tokenizer = null;
		int N ,M ;
		int keyOfVertex;
		List<Edge>[] graph = null;
		int[][] maze ;
		int[][] keysVertices ;
		
		for (int t = 1; t <= nbrCases; t++) {
			N = Integer.parseInt(reader.readLine().trim());
			M = Integer.parseInt(reader.readLine().trim());

			graph = new ArrayList[N*M];
			maze = new int[N][M];
			keysVertices = new int[N][M];
			keyOfVertex = 0;
			for (int i = 0; i < N; i++) {

				tokenizer = new StringTokenizer(reader.readLine());
				for (int j = 0; j < M; j++) {
					
					maze[i][j] = Integer.parseInt( tokenizer.nextToken());
					keysVertices[i][j] = keyOfVertex++;
					
				}
				
				

			}
			int key = 0;
//			for (int i = 0; i < N; i++) {
//
//				for (int j = 0; j < M; j++) {
//					key = keysVertices[i][j];
//					graph[key] = new ArrayList<>();
//					//top
//					if(i > 0 )
//						graph[key].add(new Edge(key, keysVertices[i-1][j], maze[i-1][j]));
//					
//					//down
//					if(i < N - 1 )
//						graph[key].add(new Edge(key, keysVertices[i+1][j], maze[i+1][j]));
//					
//					//left
//					if(j > 0 )
//						graph[key].add(new Edge(key, keysVertices[i][j - 1], maze[i][j-1]));
//					
//					//top
//					if(j < M - 1 )
//						graph[key].add(new Edge(key, keysVertices[i][j+1], maze[i][j+1]));
//					
//				}
//				
//				
//
//			}
			
			Dijkstra dijkstra = new Dijkstra(maze, 0, M*N -1 ,maze[0][0]);
			
			System.out.println((int)dijkstra.distTo(M*N-1));
			
			
			
//			for (int i = 0; i < graph.length; i++) {
//				
//				System.out.println(i + " : " +  graph[i]);
//			}
			//System.out.println(Arrays.deepToString(maze));
		//	System.out.println(Arrays.deepToString(keysVertices));

			
			

//			for (int j = 0; j < graph.length; j++) {
//				
//				if(graph[j] != null)			
//				System.out.println(j + " " + graph[j]);
//			}

		}

		reader.close();
		// writer.close();
	}

}
