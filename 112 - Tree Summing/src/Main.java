import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;




public class Main {

	
	
	static int getIndexbyS(String s)
	{
		int index = 1;
		
		for (int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == 'L')
				index*= 2;
			else
				index = index*2 + 1;
			
			
		}
		
		return index;
		
		
		
	}

	public static void main(String[] args) throws IOException {
		
		 InputStream inputStream = System.in;
//		 InputStream inputStream = new FileInputStream("in.txt");

//			 reader = new BufferedReader(new InputStreamReader(inputStream));
		
		 Scanner in  = new Scanner(inputStream);
			String pair , s ;
			int n ;
		while(in.hasNext())
		{
			int[] tree = new int [1000000];
			
			Arrays.fill(tree, -1);
			int nbr0fnodes = 0;
			boolean complete = true;

			while(in.hasNext() && !(pair = in.next()).equals("()"))
			{
				String[] splitted = pair.replace("(", "").replace(")" , "").split(",");
				
				n = Integer.parseInt(splitted[0]);
				s = splitted.length > 1 ?  splitted[1] : "";
				nbr0fnodes++;
				
//				System.out.print(n + " : " + s + " ");
//				System.out.println(getIndexbyS(s));
				
				int indx = getIndexbyS(s);
				
				if(tree[indx] == -1)
				tree[indx] = n;
				else
					complete = false;

			}
			
//			System.out.println(Arrays.toString(tree));
			List<Integer> order = new ArrayList<>();
			int parent ;
			if(complete)
			for (int i = 1; i < tree.length; i++) {
				
				parent = i/2;
				
				if(tree[i] != -1 && tree[parent] == -1 && i != 1)
				{
					complete = false;
					break;
					
				}
				
				
				if(tree[i] != -1)
				order.add(tree[i]);
				
				
			}
			
			if(complete)
			{
				System.out.println(order.toString().replaceAll("[\\[,\\]]" , ""));
			}
			else
				System.out.println("not complete");

			
			
		}
		
		
		
		
		


	}

}
