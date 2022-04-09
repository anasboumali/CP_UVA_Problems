import java.awt.Point;
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

	 
	static char[][] checkerBoard;
	static int[][] paths;
	static boolean[][] visited;
	
	static int[] X = {-1 , -1};
	static int[] Y = {1 ,  -1};

	
	
	static int N;
	
	
	static Scanner in ;
	static int  index ;
	static String str_wwf ;
	static String str ;
	static char current ;
	static int s ;
	static boolean[] visited;
	


	static boolean wwf()
	{
		//terminal 
		if(index >= str_wwf.length())
			return false;
		
		current =  str_wwf.charAt(index);
	 
	
		
		
		if(current == 'N')
		{
			index++;
			return wwf();
		}
		
		
		switch(current)
		{
		case 'A' :
		case 'K' :
		case 'C' :
		case 'E' :
			
			index++;
			
			if(wwf())
			{
				if( wwf())
				{
					return true;
				}	
				else
					return false;
			}

			else
			{
			
				return false;

			}
			
			
			
		}
		
		
		
		if(current == 'p' || current == 'q' || current == 'r' || current == 's' || current == 't')
		{
			index++;
			return true;

		}
		
		index++;
		return false;
		
	}

	
	static boolean isvalid()
	{
		 if(wwf() && (index == str_wwf.length()))
			 return true;
		 else
			return false;
	}
	
	
	
	static int dfs(int i , int j)
	{
		
		if(visited[i][j])
			return paths[i][j];
		
		
		
		visited[i][j] = true;

		
		int nbrPaths = 0;
		
		
		int dx ;
		int dy ;
		
	for (int k = 0; k < 2; k++) {
		
		dx  = i + X[k];
		dy  = j + Y[k];

		
		if(isValid())
		{


		}
	}

		
		
		
		paths[i][j] = nbrPaths;
		
		return paths[i][j];
		
		
		
	}
	

	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  int counter = 1;
		  String area ;
		  String line ;
		  while((line = reader.readLine()).equals("0"))
		  {
	
			  
			  visited      = new boolean[N][N];
			  checkerBoard = new char[N][N];
			  paths        = new int[N][N];
			  
			  Point pos = new Point();
			  boolean found  = false;
			  
			  
			  for (int i = 0; i < N; i++) {
				  checkerBoard[i] = line.

				  
				  
				  
			}

			  
		  }
		


		reader.close();
	}

}
