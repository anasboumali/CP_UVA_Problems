import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	static int nbrNodes ;
	static int[] tree;
	static int[] fallenLeaves ;
	static Scanner in ;
	
	
	static void buildTree(int indice , int unit)
	{
	
	
		int node  = current;
		current = in.nextInt();
		

		
		if(node!= -1)
		{
			fallenLeaves[unit] += node;

			buildTree(2*indice , unit - 1);//left
			buildTree(2*indice + 1 , unit + 1);//right
		}

		
		
	}
	static int current ;
	
	static void fall(int indice , int unit)
	{
	 
		if(indice >= tree.length || unit < 0 || unit >= fallenLeaves.length || tree[indice] == -1 )
			return ;
		
		fallenLeaves[unit] += tree[indice];
		
		fall(indice*2 + 1 , unit + 1);
		fall(indice*2 , unit - 1);
		
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		
		 InputStream inputStream ;

		if (InetAddress.getLocalHost().getHostName().equals("DESKTOP-OK4NDJB"))
		   inputStream = new FileInputStream("in.txt");
		else
			inputStream = System.in;

				

		
//		  

		  in = new Scanner(inputStream);
	



		int counter = 1;
		
		int N = 1000;
		current = in.nextInt();
		boolean first = true;
		while((current) != -1)
		{
			
			if(!first)
			System.out.println();
			
			
			fallenLeaves = new int[N];
			nbrNodes = 0;
			
			buildTree(1 , N/2);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < fallenLeaves.length; i++) {
				if(fallenLeaves[i] != 0)
					sb.append(fallenLeaves[i] + " ");
			}
			
			
			System.out.println("Case " + counter++ +":");
			System.out.println(sb.toString().trim());
//first = false;
			System.out.println();

		}
		
		


		// writer.close();
	}

}
