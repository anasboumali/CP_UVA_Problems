import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;






public class Main {



	static  boolean[] marked ;
    static ArrayList<Integer>[] graph;
    
	
		
	
		
	

		
	


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));



		

		int counter = 1;
		StringTokenizer sToken = null;	
		String line = null;
	
		int n , m;
		int u ,v;
		Map<String , Integer> mapDrinkToint ;
		Map<Integer , String> mapIntToDrink ;
		PriorityQueue<Integer> pq;
		List<Integer> order ;
		
		while((line = reader.readLine()) != null)
		{
			n = Integer.parseInt( line); 
			mapDrinkToint =  new  HashMap<>();
			mapIntToDrink =  new  HashMap<>();
			pq =  new PriorityQueue<>();
			order = new ArrayList<>() ;
			for (int i = 0; i < n; i++) {
				
				String drink = reader.readLine();
				mapDrinkToint.put(drink, i);
				mapIntToDrink.put(i, drink);
				
				
			}
		

		
			m = Integer.parseInt( reader.readLine());
			 
			graph =  new ArrayList[n];
			marked = new boolean[n];
			int[] inDegree = new int[n];
			for (int i = 0; i < m; i++) 
				
			{
				
				sToken = new StringTokenizer(reader.readLine());
				u  = mapDrinkToint.get(sToken.nextToken().trim()); 
				v  = mapDrinkToint.get(sToken.nextToken().trim()); 
				
				if(graph[u] == null)
				graph[u] = new ArrayList<>();
				
				inDegree[v]++;
				graph[u].add(v);
				
		
			}
			

		
			
			

			for (int i = 0; i < inDegree.length; i++) {
				
				if(inDegree[i] == 0)
					pq.add(i);
			}
		
			int countVertices = 0;
			
			while(!pq.isEmpty())
			{
				
				int current = pq.poll();
				order.add(current);
				countVertices++;
				
				if(graph[current] != null)
				for (int i = 0; i < graph[current].size(); i++) {
					
					inDegree[graph[current].get(i)]--;
					
					if(inDegree[graph[current].get(i)] == 0)
						pq.add(graph[current].get(i));
				}
				
				
			}
			
			
			
			System.out.print("Case #" + counter++ +": Dilbert should drink beverages in this order: ");

			
			

			for (int i = 0; i < order.size(); i++) {
			
				if(i != order.size() - 1)
					System.out.print(mapIntToDrink.get(order.get(i )) + " ");
				else
					System.out.println(mapIntToDrink.get(order.get(i))+ ".");

			}
			
			System.out.println();
			order.clear();
			
			
			
		
			

			
			
			

			reader.readLine();
		}

			

		

		reader.close();
		//writer.close();
	}

}
