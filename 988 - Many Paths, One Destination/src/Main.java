import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.ValidationEvent;




public class Main {

	
	static List<Integer>[] graph ;
	static Set<Integer> deaths;
	static int numberOfPaths ;
	static boolean[] visited;
	static int[] paths;
	
	 static int dfs(int i)
	 {
		 
		 if(deaths.contains(i))
		 {
			 
			 return 1;
		 }
		 
		 if(visited[i])
			 return paths[i];
		 
		 visited[i]  = true;
		 
	
	
		 
		 int sumPaths = 0;
		 for (Integer u : graph[i]) {
			
			 sumPaths +=dfs(u);
			 
		}
		 
		 paths[i] = sumPaths;
		 
		 return sumPaths;
		 
	 }

	

	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		  
		  
		  String T ;
		  while((T = reader.readLine()) != null)
		  {
			  int events = Integer.parseInt(T);
			  graph = new ArrayList[events];
			  deaths = new HashSet<>();
			  paths = new int[graph.length];
			  visited = new boolean[graph.length];

			  for (int i = 0; i < events ; i++) {
				  
				  graph[i] = new ArrayList<>();
				  StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				  int nbr_v = Integer.parseInt(tokenizer.nextToken());
				  if(nbr_v == 0)
					  deaths.add(i);
				  
				  
				  for (int j = 0; j < nbr_v; j++) {
					graph[i].add(Integer.parseInt(tokenizer.nextToken()));
					
					
				}
			}
			  
			  
			  
//			  for (int i = 0; i < graph.length; i++) {
//					 System.out.println(graph[i]);
//				
//			}
//			  
//			  System.out.println(deaths);
		
			  

			  System.out.println(dfs(0));
			  
			  
			  String s  = reader.readLine();
			  if(s != null)
				  System.out.println();
		  }


		reader.close();
	}

}
