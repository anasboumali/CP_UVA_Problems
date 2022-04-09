import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.rowset.Joinable;


public class Main {

	static int H , W ;

	static char[][] image ;
	static boolean[][] visited;
	static int [] X =  {-1, 1, 0, 0};
	static int [] Y =  { 0, 0, 1, -1};
	static int counter = 1;
	static String map;
	
	static int   FillFlood(int i , int j , char farmer)
	{
		
		if( i >= H || i < 0 || j >= W || j < 0 || visited[i][j] )
			return 0;
		
		int holesNumber    = 0;
		
		if(image[i][j] == '0')
		{
			neutralize(i, j, '0');
			holesNumber++;  
		}
		
		visited[i][j] = true;
		
		for (int k = 0; k < X.length; k++) {
			
			holesNumber += FillFlood(i + X[k], j + Y[k], farmer);
		}
		
		return holesNumber;
	}
	
	static int neutralize(int i , int j , char farmer)
	{
		
//		if( i >= H || i < 0 || j >= W || j < 0 || visited[i][j] || image[i][j] != farmer)
//			return 0;
		 int [] X =   {-1, 1, 0, 0 , 1 , -1 , 1,-1};

		 int [] Y =   { 0, 0, 1, -1,-1 , 1  , 1 ,-1};

		
		visited[i][j] = true;
		
		for (int k = 0; k < X.length; k++) {
			
			int dx =  i + X[k];
			int dy =  j + Y[k];
			if(!( dx >= H || dx < 0 || dy >= W || dy < 0 || visited[dx][dy] || image[dx][dy] != farmer)	)
			{

				neutralize(dx,dy,  farmer);

			}
			
		}
		
		return 0;
	}
	
	
	static void readGlyph()
	{
		
		ArrayList<Character> glyphs = new ArrayList<>();
		

		for (int i = 0; i < H; i++) {
			
			for (int j = 0; j < W; j++) {
				
				if( (i == 0 || i == H-1 ||  j == 0 || j == W-1) && image[i][j] == '0'  )
				{
					neutralize(i, j, '0');
		
	
				}

				
			}
		}
		
//		System.out.println(Arrays.deepToString(visited).replace("],", "\n"));

		
		
		for (int i = 0; i < H; i++) {
			
			for (int j = 0; j < W; j++) {
				

				
				if(image[i][j] == '1' && !visited[i][j])
				{
					Integer holesNumber = FillFlood(i, j, '1') ;
					
					if(holesNumber < map.length())
					glyphs.add( map.charAt(holesNumber));
					else 
						System.out.println("invalid : " + holesNumber);
					
					;//glyphs.add( holesNumber.toString());

					
				}
				
				
			}
		}
		
		Collections.sort(glyphs);
		System.out.print("Case " + counter++ +  ": " ) ;
		for (int i = 0; i < glyphs.size(); i++) {
			System.out.print(glyphs.get(i));

		}
		System.out.println();
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String HW ;
		char[] line ;

		
		
		map = "WAKJSD";



		

		
		while(true)
		{
			HW  = reader.readLine().trim();
			
			H = Integer.parseInt(HW.split("\\s+")[0]) ;
			W = Integer.parseInt(HW.split("\\s+")[1]) ;
			W*= 4;
			
			if(H + W == 0)
				break;
			
			image = new char[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < image.length; i++) {
				Arrays.fill(image[i], '0');
			}

			int maxW = 0;
			for (int i = 0; i < H; i++) {
				line = reader.readLine().toCharArray();
				
				int k = 0;
				for (int j = 0; j < line.length; j++) {
					
				
						Integer num = Integer.parseInt(String.valueOf( line[j]), 16);	
						String bin  = Integer.toBinaryString(num);
						
						//System.out.println(line[j]);
						//System.out.println(bin);

						for (int l = 0; l < bin.length(); l++) {
							image[i][k + 3 - l]  = bin.charAt(bin.length() - l - 1);
							
						}
						k+= 4;
						

						
					
					
									
				}
				
				if( k >  maxW)
					maxW = k;
				
			}
			
			W = maxW;
////			System.out.println("debut");
//			System.out.println(Arrays.deepToString(image).replace("],", "\n"));

			readGlyph();
			
			
		}
		

		
		

		reader.close();
	}

}
