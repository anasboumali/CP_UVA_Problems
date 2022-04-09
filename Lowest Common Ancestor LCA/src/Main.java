import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;






public class Main {

	
	static int[] eulerTour ;
	static int[] depth ;
	static int[] firstVisit;
	static int index;
	static int[] t;
	
	
	
	static void build() {  // build the tree
		  for (int i = eulerTour.length - 1; i > 0; --i)
		  {
			  
			  
			  if(t[2*i] < t[2*i + 1])
				  t[i] = 2*i;
			  else
				  t[i] = 2*i + 1;

		  }
		  

		  
		  
		} 



	static int query(int l, int r) {  // sum on interval [l, r)
		  int min = l;
		  
		  for (l += eulerTour.length, r += eulerTour.length; l < r; l >>= 1, r >>= 1) {
		    if (l%2 != 0)
		    	{
		    	if(t[l] < t[min])
		    		{
		    		min = l;
		    		}
		    	l++;
		    	}
		    
		    if (r%2 != 0) 
		    	{
		    	r--;
		    	if(t[r] < t[min])
	    		{
	    		min = r;
	    		}
	    
	    	}}
		    	
		  
		  return min;
		}
	
	
	
	
	
	
	
	
	static void dfs(int u , int dpth) //eulerian tour
	{
		
		eulerTour[index] = u;
		depth[index] = dpth ;
		firstVisit[u] = index ;
		index++;
		
		if(graph[u] != null)
			for (Integer v : graph[u]) {
				
				dfs(v , dpth + 1);		
				
				eulerTour[index] = u;
				depth[index] = dpth ;
				index++;

			}

		

	}
	static ArrayList<Integer>[] graph ;


	public static void main(String[] args) throws IOException {
		
//		 InputStream inputStream = System.in;
		 InputStream inputStream = new FileInputStream("in.txt");

		 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		 
		 
		 
		 
		int T = Integer.parseInt(reader.readLine());
		
		while(T-- > 0)
		{
			int N =  Integer.parseInt(reader.readLine());
			N++;
			graph = new ArrayList[N];
			eulerTour = new int[(N-1)*2 - 1];
			depth = new int[(N-1)*2 - 1 ];
			firstVisit = new int[N];
			t = new int [4*(N-1)];
			
			
			for (int i = 0; i < N - 2; i++) {
				
				String[] uv = reader.readLine().split("\\s+");
				
				int u = Integer.parseInt(uv[0]);
				int v = Integer.parseInt(uv[1]);

				if(graph[u] == null)
					graph[u] = new ArrayList<>();
				
				graph[u].add(v);	
			}

		
		}
		
		
//		for (int i = 0; i < graph.length; i++) {
//			
//			System.out.print( i +  "  : ");
//			if(graph[i] != null)
//				System.out.println(graph[i]);
//			else
//				System.out.println();
//		}
		
		
		
		dfs(1 , 0);

		
		for (int i = t.length - eulerTour.length ,  k = 0; i <  t.length; i++) {
			
			t[i] = k++;
				
		}
		
		System.out.println(Arrays.toString(t));

		build();
		
//		System.out.println(t[query(firstVisit[3],firstVisit[3] )]);
	
		System.out.println(Arrays.toString(t));

		System.out.println(Arrays.toString(eulerTour));
		System.out.println(Arrays.toString(depth));
		System.out.println(Arrays.toString(firstVisit));
		
		
		int M = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < M; i++) {
			String[] ab = reader.readLine().split("\\s+");
			
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			if(a > b)
			{
				int temp = a;
				a = b;
				b = temp;
			}
			
			int res = query(firstVisit[4],firstVisit[5] );
			System.out.println(t[res]);
			
//			if(res == a || res == b)
//				System.out.print(1);
//			else
//				System.out.print(0);
		}


		
		
		
		

	}

}
