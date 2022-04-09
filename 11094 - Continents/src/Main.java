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


	static char[][] grid;
	static boolean[][] visited ;

	
	static int[] X = {-1,0,1,0};
	static int[] Y = {0,-1,0,1};
	
	static int numberOfregions(int x , int y)
	{
		
		
		FloodFill(x, y, grid[x][y]);
		
		int nbrRegions  = 0;
		int countriesInRegion = 0;
		int biggestContinent = 0;
	
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
			
				if( grid[i][j] == grid[x][y] && !visited[i][j])
				{
					nbrRegions++;
					countriesInRegion = FloodFill(i, j,grid[i][j]);
					if( countriesInRegion/X.length> biggestContinent)
						biggestContinent =  countriesInRegion/X.length;
					
					
				}
				
				
			}
		}
		
		return  biggestContinent ;
	}
	
	static int FloodFill(int i , int j , int farmer)
	{
		
		int M = grid.length;
		int N = grid[0].length;

		if(j < 0 )
			j = N -1 ;
		
		else if(j >= N)
			j = 0;
		
		
			
		
		if(i < 0 || i >= M || visited[i][j] || grid[i][j] != farmer)
			return 0;
		
		visited[i][j] = true;
		int nbrOfcountries = 0;
		for (int k = 0; k < X.length; k++) {
			nbrOfcountries += 1 + FloodFill(i + X[k], j + Y[k], farmer);
		}
		
		return nbrOfcountries;
		
	}


	public static void main(String[] args) throws IOException {

//		InputStream inputStream = System.in;
		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));



		int N,M = 0;

		int counter = 0;
		
		StringTokenizer tokenizer = null;
		
		String line = null;
		int x , y;
		while((line = reader.readLine()) != null)
		{
			
		 	 tokenizer = new StringTokenizer(line);
			 M = Integer.parseInt(tokenizer.nextToken());
			 N = Integer.parseInt(tokenizer.nextToken());
			
			grid =  new char[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				grid[i] = reader.readLine().toCharArray();
			}
			
			tokenizer = new StringTokenizer(reader.readLine());
			
			 x = Integer.parseInt(tokenizer.nextToken());
			 y = Integer.parseInt(tokenizer.nextToken());
			 
//			 System.out.println("M" + M + " " + N);
			// System.out.println("x : " +  x + " " + y);
			 
			reader.readLine();
			System.out.println(numberOfregions(x,y));
		
			

			
			
			

			
		}

			

		

		reader.close();
		//writer.close();
	}

}
