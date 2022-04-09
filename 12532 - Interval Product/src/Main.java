import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;




public class Main {


		
	

	static int[] t ;
	static int N;
	static void build()
	{
		for(int i = N -1; i > 0 ; i--)
			
			if(t[2*i]*t[2*i+1] < 0)
			t[i] = -1;
			else if(t[2*i]*t[2*i+1]==0 )
			t[i] = 0;

		
		
	}
	
	
	static void update(int p , int value)
	{
		
		for (t[p+= N] = value ; p > 1 ; p/=2) 
		{
			if(t[p]*t[p^1]< 0)
				t[p/2] = -1;
			else if(t[p]*t[p^1]==0 )
				t[p/2] = 0;
			else
				t[p/2] = 1;

		
		}
		
		
	}
	
	
	static int query(int l , int r)
	{
		int res = 1;
		for (l+=N , r+=N; l < r ; l/=2 , r/=2) {
//			System.out.println("l : " + l + " r : " + r);
		//	System.out.println("lv : " + t[l] + " rv : " + t[r]);

			
			
			if(l%2 != 0) 
				{
				int lv =  t[l++];
				
				if(lv < 0)
				 res *= -1 ;
				else if (lv == 0)
					res = 0;
				
				}
			
			if(r%2 != 0) 
				{
		int rv = t[--r];
				
				if(rv < 0)
				 res *= -1 ;
				else if (rv == 0)
					res = 0;
				}
			
		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  int nbrOperations  = 0;
		  String NO;
		  while((NO = reader.readLine()) != null)
		  {
			  N = Integer.parseInt(NO.split(" ")[0]);
			  
			  nbrOperations =Integer.parseInt(NO.split(" ")[1]);
			  
			  t = new int[2*N];
			  StringTokenizer sToken = new StringTokenizer(reader.readLine());
			//  N++;
			  Arrays.fill(t, 1);
			  
			  for (int i = 0; i < N; i++) {
				t[i+N] = Integer.parseInt(sToken.nextToken());
			}
			  
			  build();
			  for (int i = 0; i < nbrOperations; i++) {
				  
				  sToken = new StringTokenizer(reader.readLine());
				  char op = sToken.nextToken().charAt(0);
				  int  a = Integer.parseInt(sToken.nextToken());
				  int  b = Integer.parseInt(sToken.nextToken());
				  
				  if(op == 'C')
					  update(a-1, b);
				  else
				  {
					  int res = query(a-1, b);
//					  System.out.println(res);
					  if(res > 0)
						  System.out.print("+");
					  else if (res == 0)
						  System.out.print("0");
					  else
						  System.out.print("-");
					  
					  
				  }
				  
				  
				  
				  
			}
			  System.out.println();

			  
			  
		  }
		  
		  
		


		reader.close();
	}

}
