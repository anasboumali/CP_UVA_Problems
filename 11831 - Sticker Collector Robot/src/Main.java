import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

	 InputStream inputStream = System.in;
	//	InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		char[][] grid;
		String orders = null;
		int N, M, S;
		int initial_x = 0, initial_y = 0;
		int current_x = 0, current_y = 0;

		int[] x = new int[]{0,-1,0,1};
		int[] y = new int[]{-1,0,1,0};
		
		Map<Character , Integer> mapDir = new HashMap<>();
		mapDir.put('O', 0);
		mapDir.put('N', 1);
		mapDir.put('L', 2);
		mapDir.put('S', 3);
		
		int nbrStickers = 0;
	    int currentDir = 0; 
		while (reader.ready()) {
			String[] line = reader.readLine().trim().split(" +");

			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);
			S = Integer.parseInt(line[2]);

			if (N + M + S == 0)
				break;

			grid = new char[N][M];
			
			for (int i = 0; i < N; i++) {

				grid[i]  =  reader.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					
					if(grid[i][j] != '.' && grid[i][j] != '*' && grid[i][j] != '#' )
					{
						initial_x = i;
						initial_y = j; 
					}
					
				}
			}
			
			
			
			nbrStickers = 0;
			
		
			
			orders = reader.readLine();
					//your initial position & direction
				
				currentDir = mapDir.get(grid[initial_x][initial_y]);
				
				current_x = initial_x;
				current_y = initial_y;
				
				int clockwise = 0;
			for (int i = 0; i < orders.length(); i++) {
				
		
				
				//get order , the order can be 
				//change direction or forward 
				
				if(orders.charAt(i) != 'F')
				{
					//change direction 

					clockwise = (orders.charAt(i) == 'D' ) ?  1 : -1 ; 
					currentDir = (currentDir +  clockwise)%4;
					if( currentDir < 0)
						currentDir = 3 ;
					
					
					
				}else
				{
					
					//don't forward if you will hit a pillar
					//or you will leave the arena 
					
					int next_x  = current_x + x[currentDir];
					int next_y  = current_y + y[currentDir];
					if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M && grid[next_x][next_y] != '#')
					{
						
					//else forward and collect sticker
					//put . in this cell , thus removing sticker
					//increment stickers 
						current_x = next_x;
						current_y = next_y;
						if(grid[next_x][next_y] == '*')
						{
							nbrStickers++;
							grid[current_x][current_y] = '.';
							
						}
						
						
					}
					
					
					
					
			
					
				}
		

				
			}
			
			System.out.println(nbrStickers);


		
		}

		reader.close();
		//writer.close();
	}

}
