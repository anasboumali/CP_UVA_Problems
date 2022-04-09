import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	
	




	public static void main(String[] args) throws IOException {

//		InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;

		StringTokenizer sToken = null;
		int n,m;
		int u, v;
		int s, d;
		int T = Integer.parseInt(reader.readLine());
		int[][] buildings ;
		int counter = 1;
		final int INF = 10000;
		while (T-- > 0) {
			
			n = Integer.parseInt(reader.readLine());
			m = Integer.parseInt(reader.readLine());

			
			
			buildings =  new int[n][n];
			for (int i = 0; i < buildings.length; i++) {
				Arrays.fill(buildings[i], INF);
	            buildings[i][i] = 0;


			}
			  
			//System.out.println(Arrays.deepToString(buildings));
			for (int i = 0; i < m; i++) {
				
				String[] edge = reader.readLine().split("\\s+");
				u = Integer.parseInt(edge[0]);
				v = Integer.parseInt(edge[1]);
				
				buildings[u][v] = 1;
				buildings[v][u] = 1;
				
				

			}
			
			String[] sourceDest = reader.readLine().split("\\s+");
			s = Integer.parseInt(sourceDest[0]);
			d = Integer.parseInt(sourceDest[1]);
			
			
	        for (int k = 0; k < n; ++k)
	            for (int i = 0; i < n; ++i)
	                for (int j = 0; j < n; ++j)
	                   buildings[i][j] = Math.min(buildings[i][j], buildings[i][k] + buildings[k][j]);
		

	        
	        int minTime = 0;

	        for (int i = 0; i < n; ++i)
	            if (buildings[s][i] != INF
	                && buildings[i][d] != INF)
	            {
	                minTime = Math.max(minTime, buildings[s][i] + buildings[i][d]);
	            }
	        
	        System.out.println("Case " + counter++ + ": " + minTime);

	}
		
		
		
	}
	

}
