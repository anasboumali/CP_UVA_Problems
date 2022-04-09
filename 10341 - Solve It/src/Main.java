import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;





public class Main {
	
	static int p ,q , r ,s ,t , u;

	static double f(double x)
	{
		
		
		return p*Math.exp(-x) + q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*x*x + u;
		
		
	}

	
	
	public static void main(String[] args) throws IOException {

		

		
		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		Scanner in  = new Scanner(inputStream);
		
//		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"))));



		double EPS  = 1e-8;
		while(in.hasNext())
			
		{
			p = in.nextInt();
			q = in.nextInt();
			r = in.nextInt();
			s = in.nextInt();
			t = in.nextInt();
			u = in.nextInt();
			
			if(f(0)*f(1) > 0)
			{
				System.out.println("No solution");
				continue;
			}
			
			
			double left = 0 ;
			double right = 1;
			
			double m;
			do
			{
				m = (left + right)/2;
				
				if(f(m) > 0)
					left  = m;
				else
					right = m;
				
				
				
			}while(Math.abs(left - right) > EPS);
			
		
			
			System.out.println(String.format("%.4f", m).replace(",", "."));
			
			
			
			

		}
		
		
		//writer.close();
	
		
	}

}
