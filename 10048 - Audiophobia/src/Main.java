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
import java.util.PriorityQueue;

public class Main {


	public static void main(String[] args) throws IOException {


		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));



		int counter = 1;

		StringTokenizer tokenizer = null;
		int C , S , Q ;
		boolean first = true;
		while(true)
		{
			tokenizer = new StringTokenizer(reader.readLine());
			C = Integer.parseInt(tokenizer.nextToken());
			S = Integer.parseInt(tokenizer.nextToken());
			Q = Integer.parseInt(tokenizer.nextToken());
			if(C == 0)
				break;
			
			C++;
			
			int[][] dist = new int[C][C];
			
			for (int i = 1; i < C; i++) {
				for (int j = 1; j < C; j++) {
					
					if(i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for (int i = 0; i < S; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				int w = Integer.parseInt(tokenizer.nextToken());
				
				dist[u][v] = w;
				dist[v][u] = w;
				
				
			}
			
			
			//floyd minimax
			for (int k = 1; k < C; k++) {
				for (int i = 1; i < C; i++) {
					for (int j = 1; j < C; j++) {
						dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
						
						
					}
				}
			}
			
			if(!first)
			System.out.println();

			first = false;
			System.out.println("Case #" + counter++);
			for (int i = 0; i < Q; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				
				if(dist[u][v] != Integer.MAX_VALUE)
					System.out.println(dist[u][v]);
				else
					System.out.println("no path");
			}
			
			
			
		}
		

		reader.close();
		// writer.close();
	}

}
