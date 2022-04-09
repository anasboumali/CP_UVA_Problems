import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	
	
	 static char[] preOrder;
	 static char[] inOrder;
	 static char[] tree ;
	 static int[] map ;
	 static int index ;
	 
	 static void buildTree(int i)
	 {
		 
		 if(index >= preOrder.length)
			 return ;
		 
		 
		 int idxRoot  = map[ preOrder[index] - 'A'];
		 tree[i] = preOrder[index++];
		 

		 if(index >= preOrder.length)	 
			 return ;
		 
		 int idxChild = map[ preOrder[index++] - 'A'];
			 
	
			 
		 if(idxChild < idxRoot)
			 buildTree(2*i);
		 
		 if(index >= preOrder.length)
			 return ;
		 
		 idxChild = map[ preOrder[index++]- 'A'];
		 
		 if(idxChild > idxRoot)
			 buildTree(2*i +  1);

		 
	 }
	 
	
	 
	 
	public static void main(String[] args) throws IOException {

		
		 InputStream inputStream ;

		if (InetAddress.getLocalHost().getHostName().equals("DESKTOP-OK4NDJB"))
		   inputStream = new FileInputStream("in.txt");
		else
			inputStream = System.in;

				

		
//		  

		 Scanner in = new Scanner(inputStream);
		 
		 

		 while(in.hasNextLine())
		 {
			 preOrder = in.next().toCharArray();
			 inOrder = in.next().toCharArray();
			 map = new int[30];
			 tree = new char[4*preOrder.length];
			 
			 Arrays.fill(tree, (char)0);
			 
			 for (int i = 0; i < inOrder.length; i++) {
				map[inOrder[i] - 'A'] = i;
			}
			 
			 buildTree(1);
		
			 System.out.println(tree);
			 
			 
			 
			 
		 }
		 
		 
		 
		 
		 
		  
		  
		  
	



	}

}
