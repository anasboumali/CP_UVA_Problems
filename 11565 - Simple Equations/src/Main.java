
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] arg) {

		 Scanner in = new Scanner(System.in);

//		Scanner in = null;
//
//		try {
//			in = new Scanner(new FileReader("in.txt"));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}

		class Solution {
			public int x;
			public int y;
			public int z;

			public Solution(int x,int y ,int z) {
				this.x = x;
				this.y = y;
				this.z= z;

			}
			
		}
		int A,B,C ;
		int T;
		Solution sol = null;
		T = in.nextInt();

		while (in.hasNext()) {
			
			A = in.nextInt() ;
			B = in.nextInt() ;
			C = in.nextInt() ;
			sol = null;
			for (int x = -100; x <=100 ; x++) {
				for (int y = -100; y <= 100; y++) {
					for (int z = -100; z <=100; z++) {
						if(x != z && x!= y && z!=y && x+y+z == A && x*y*z == B && x*x + y*y + z*z == C)
						{
							if(sol == null)
							{
								sol = new Solution(x, y, z);
							}
							else if (x < sol.x || (x==sol.x && y < sol.y))
							{
								sol = new Solution(x, y, z);
							}
						}
						
						
					}
					
				}
				
			}
			if(sol != null)
			System.out.println(sol.x +" " + sol.y + " " + sol.z);
			else
			System.out.println("No solution.");
			
			
	}
	}
}
