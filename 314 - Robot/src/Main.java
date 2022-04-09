import java.awt.Point;
import java.awt.geom.Point2D;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {

	static boolean[][] store ; 
	static Point startPoint ;
	static Point endPoint ;
	static int startDirection ;
	static Map<String , Integer > directions;
	static int[] X = {-1 , 0 ,1 , 0};
	static int[] Y = {0 , 1 , 0, -1};
	static int[] correctionX = {0 , 0 , 1 , 0};
	static int[] correctionY = {0 , 1 , 0 , 0};
	static int N;
	static int M;

	static Queue<Position> pq ;
	static boolean[][][] visited;
	
	static boolean isValidPosition(Point p)
	{
		if(p.getX() >= N || p.getX() <= 0 || p.getY() >= M || p.getY() <= 0  )
			return false;
		
		
		
		return	  !store[(int) p.getX()][(int) p.getY()] 
			   && !store[(int) p.getX()][(int) p.getY()-1]
			   && !store[(int) p.getX()-1][(int) p.getY()] 
			   && !store[(int) p.getX()-1][(int) p.getY()-1];
	}
	

	static class Position 
	{
		Point point ;
		int direction ;
		int time ;
		
		
		public Position(Point point, int direction, int time) {
			this.point = point;
			this.direction = direction;
			this.time = time;
		}




		
		
		
		
		
	}
	
	static int bfs()
	{
		
		pq.add(new Position(startPoint, startDirection, 0));
		visited[(int) startPoint.getX()][(int) startPoint.getY()][startDirection] = true;

		
		while(!pq.isEmpty())
		{
			
			Position current =  pq.poll();
			
			if(current.point.equals(endPoint))
			{
				return current.time;
		
				
			}

	
				
				int dx = (int) (current.point.getX()) ;
				int dy = (int) (current.point.getY()) ;
				
				if(!visited[dx][dy][(current.direction + 1 )%4])
				{
					
			

					pq.add(new Position(current.point,(current.direction + 1 )%4, current.time + 1));
					visited[dx][dy][(current.direction + 1 )%4] = true;
					
				}
				
				if(!visited[dx][dy][(current.direction + 3 )%4])
				{
					
			

					pq.add(new Position(current.point,(current.direction + 3 )%4, current.time + 1));
					visited[dx][dy][(current.direction + 3 )%4] = true;
					
				}
			
				
				
				for (int j = 0; j < 3; j++) {
					dx +=  X[current.direction];
					dy +=  Y[current.direction];
					Point nextPoint = new Point(dx,dy);
					
					if(isValidPosition(nextPoint) )
							{

						if( visited[dx][dy][current.direction])
							continue;
						
						
						visited[dx][dy][current.direction] = true;

						Position pos = new Position(nextPoint,current.direction, current.time + 1);
				//		System.out.println(pos);
						pq.add(pos);
						
						
						
							}
					
					else
								break;
					
					
					
				}
			
			

			
			
			
		}
		
		
		return -1;
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// PrintWriter writer = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(System.out)));
		
		directions = new HashMap<>();
		
		directions.put("north", 0);
		directions.put("east", 1);
		directions.put("south", 2);
		directions.put("west", 3);

		

		StringTokenizer tokenizer = null;
		int B1 , B2 , E1, E2;
		
		
		
		while (true) {

			pq = new LinkedList<>();

			String line = reader.readLine();

		
			tokenizer = new StringTokenizer(line);
		
		

				 N = Integer.parseInt(tokenizer.nextToken());
				 M = Integer.parseInt(tokenizer.nextToken());
				
				if (N + M == 0)
					break;

				store = new boolean[N][M];
				visited =  new boolean[N][M][4];
				for (int i = 0; i < store.length; i++) {
					tokenizer = new StringTokenizer(reader.readLine());

					for (int j = 0; j < store[0].length; j++) {
						store[i][j] = Integer.parseInt( tokenizer.nextToken()) == 0 ? false : true;
						
					}
					
				}
			
		   		tokenizer = new StringTokenizer(reader.readLine());
				 B1 = Integer.parseInt(tokenizer.nextToken());
				 B2 = Integer.parseInt(tokenizer.nextToken());
				 E1 = Integer.parseInt(tokenizer.nextToken());
				 E2 = Integer.parseInt(tokenizer.nextToken());
				 
				 startDirection = directions.get(tokenizer.nextToken());
				 
				 startPoint = new Point(B1, B2);
				 endPoint = new Point(E1, E2);
				 
				 
				 //System.out.println(Arrays.deepToString(store));
				
	

					 System.out.println( bfs());
		
			
			
		
		}



		reader.close();
		// writer.close();
	}

}
