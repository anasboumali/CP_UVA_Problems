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

	static class Prims {
		List<Edge>[] graph;
		Edge[] edgeTo;
		double[] distTo;
		boolean[] marked;
		
		public Prims(List<Edge>[] graph) {
			
			this.graph = graph;
			edgeTo = new  Edge[graph.length];
			distTo = new double[graph.length];
			marked = new boolean[graph.length];
			IndexMinPQ pq = new IndexMinPQ(graph.length);

			for (int i = 0; i < graph.length; i++) {
				distTo[i] = Double.POSITIVE_INFINITY;
			}

			distTo[0] = 0.0;
			pq.insert(0, 0.0);
			int current ;
			int w;
			while (!pq.isEmpty()) {
				current = pq.delMin();
				marked[current] =true;

				if(graph[current] != null)
				for (Edge neighbor : graph[current]) {
					w = neighbor.to;
					
					if(marked[w])continue;
					if(distTo[w] > neighbor.weight)
					{
						
						distTo[w] =  neighbor.weight;
						edgeTo[w] = neighbor;
						
						if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
						else pq.insert(w, distTo[w]);
						
					}
					
					
				}
			}

		}
		
		
		public double sumCost()
		{
			double MSTCost = 0;
		for (Edge e : edgeTo) {
			
			if(e != null)
				MSTCost += e.weight;
		}
		
		return MSTCost;

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

	public static void main(String[] args) throws IOException {

		




		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));



		

		StringTokenizer tokenizer = null;
		int n, m;
		int TotalWeight ;
		List<Edge>[] graph = null;
		while(true) {
			tokenizer = new StringTokenizer(reader.readLine());
			m = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			if( m + n == 0)
				break;
			
			graph = new ArrayList[m];
			TotalWeight = 0;
			for (int j = 0; j < n; j++) {

				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				double w = Double.parseDouble(tokenizer.nextToken());
				

				if( graph[u] == null)
					graph[u] = new ArrayList<>();
				
				if( graph[v] == null)
					graph[v] = new ArrayList<>();
				
				graph[u].add(new Edge(u,v,w));
				graph[v].add(new Edge(v,u,w));

				TotalWeight+=w;
			}

			Prims prims = new Prims(graph);
			
			
			System.out.println(TotalWeight - (int)prims.sumCost() );

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
