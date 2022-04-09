
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

		int n;
		int m;
		int closestSum = 0;
		int min ;
		int sum;
		Integer[] array;
		int counter = 1;
		while (in.hasNext()) {

			Set<Integer> hashSet = new TreeSet<>();
			ArrayList<Integer> querySeq = new ArrayList<>();

			n = in.nextInt();
			if (n == 0)
				break;

			for (int i = 0; i < n; i++) {
				hashSet.add(in.nextInt());
			}

			m = in.nextInt();

			for (int i = 0; i < m; i++) {
				querySeq.add(in.nextInt());
			}

			array = new Integer[n];
			hashSet.toArray(array);

			System.out.println("Case " + counter++ + ":");
			for (int k = 0; k < m; k++) {

				closestSum = array[0] + array[1];
				min = closestSum - querySeq.get(k);
				for (int i = 0; i < array.length; i++) {
					for (int j = i + 1; j < array.length; j++) {
						sum = array[i] + array[j] ;
							if(Math.abs( sum - querySeq.get(k)) < Math.abs( min) )
							{
								min = Math.abs( sum - querySeq.get(k));
								closestSum  = sum;
							}
								
					}
				}
				
				System.out.println("Closest sum to "+querySeq.get(k)+" is " + closestSum + ".");
			}

			

		}
	}

}
