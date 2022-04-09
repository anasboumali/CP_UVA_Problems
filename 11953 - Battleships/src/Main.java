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
	
	static int numberOfregions()
	{
		
		
	
		
		int nbrShips  = 0;
		
		
	
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
			
		
				
				if( grid[i][j] == 'x' && !visited[i][j])
				{
					nbrShips++;
					FloodFill(i, j,grid[i][j]);
		
					
					
				}
				
				
			}
		}
		
		return  nbrShips ;
	}

	static int FloodFill(int i , int j , int farmer)
	{
		
		int M = grid.length;
		int N = grid[0].length;

		if( i >= 0 && j  >= 0 && i  < grid.length &&  j < grid[0].length )
		if(grid[i][j] == '@')
		{

			grid[i][j] = 'x';
		}
		
		
		
		if(j < 0 || j >= N || i < 0 || i >= M || visited[i][j] || grid[i][j] != farmer)
			return 0;
		
		visited[i][j] = true;
		int nbrOfcountries = 0;
		for (int k = 0; k < X.length; k++) {
			nbrOfcountries += 1 + FloodFill(i + X[k], j + Y[k], farmer);
		}
		
		return nbrOfcountries;
		
	}


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
		//InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));



		int N = 0;

		int counter = 0;
		reader.readLine();		
		String line = null;
		int x , y;
		while((line = reader.readLine()) != null)
		{
			
		 	 N = Integer.parseInt(line);
			
			grid =  new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				grid[i] = reader.readLine().toCharArray();
			}
			

			 
//			 System.out.println("M" + M + " " + N);
			// System.out.println("x : " +  x + " " + y);
			
			
			//System.out.println(Arrays.deepToString(grid));
			 
			System.out.println("Case "+ ++counter + ": "  + numberOfregions());
		
			

			
			
			

			
		}

			

		

		reader.close();
		//writer.close();
	}

}
