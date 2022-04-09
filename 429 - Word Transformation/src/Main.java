import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] graph = new int[50001];
	static boolean[] marked = new boolean[50001];;
	static int[] sum = new int[50001];

	



	

	public static void main(String[] args) throws IOException {

		//InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int T = Integer.parseInt(reader.readLine().trim());

		int N;

		int counter = 0;
		
		StringTokenizer tokenizer = null;
		
		for(int j = 1; j <= T; j++)
		{
			
			N = Integer.parseInt(reader.readLine().trim());

			for (int i = 0; i < N; i++) {
				

				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				
			
				graph[u] = v;
				sum[u] = -1 ;
				marked[u] = false;

			}

		
	

			
			

			
		}

			

		

		reader.close();
		//writer.close();
	}

}
