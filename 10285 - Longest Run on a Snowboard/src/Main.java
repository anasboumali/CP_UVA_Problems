import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.xml.bind.ValidationEvent;




public class Main {

	 
	static int[][] heights;
	static int[][] longest;
	static boolean[][] visited;
	
	static int[] X = {-1 ,1 ,0 ,0 };
	static int[] Y = { 0 ,0 ,1 ,-1};
	
	
	static int N , M;
	
	
	static boolean isValid(int dx , int dy , int val)
	{
		
		if(dx < 0 || dx >= N || dy < 0 || dy >= M)
			return false;
		
		if(val <= heights[dx][dy] )
			return false;
		
		
		return true;
		
		
		
	}
	
	
	
	static int dfs(int i , int j)
	{
		
		if(visited[i][j])
			return longest[i][j];
		
		visited[i][j] = true;
		
		int max = 0;
		
		for (int k = 0; k < X.length; k++) {
			int dx = i + X[k];
			int dy = j + Y[k];
			if(isValid(dx,dy ,heights[i][j]))
			{
				int temp = dfs(dx , dy);
				
				if(temp > max)
					max = temp;
			}
			
		}
		
		longest[i][j] = max + 1;
		
		return longest[i][j];
		
		
		
	}
	

	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  int T  = Integer.parseInt(reader.readLine()) ;
		  
		  String area ;
		  while(T-- > 0)
		  {
			  
			  StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			  
			  area = tokenizer.nextToken();
			  N  = Integer.parseInt(tokenizer.nextToken());
			  M  = Integer.parseInt(tokenizer.nextToken());
			  
			  visited = new boolean[N][M];
			  heights = new int[N][M];
			  longest = new int[N][M];
			  
			  
			  for (int i = 0; i < N; i++) {
					tokenizer = new StringTokenizer(reader.readLine());
					
				for (int j = 0; j < M; j++) {
									
				
					heights[i][j] = Integer.parseInt(tokenizer.nextToken()) ;
					
					
				}
			}
			  
		//	  System.out.println(Arrays.deepToString(heights));
			  int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if(!visited[i][j])
						max = Math.max(max, longest[i][j] = dfs( i ,j)) ;
				}
			}  
			  
			 
			// System.out.println(Arrays.deepToString(longest).replace("],", "\n"));
			  System.out.println(area + ": "+max);
			  
			  
			  
		  }
		


		reader.close();
	}

}
