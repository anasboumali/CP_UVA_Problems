
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] arg) {

		Scanner in = new Scanner(System.in);

		// Scanner in = null;
		//
		// try {
		// in = new Scanner(new FileReader("in.txt"));
		//
		// } catch (FileNotFoundException e) {
		//
		// e.printStackTrace();
		// }

		int T;
		T = in.nextInt();
		int length;
		int p;
		int sum;
		boolean found;
		while (in.hasNext()) {
			length = in.nextInt();
			p = in.nextInt();
			int[] bars = new int[p];
			for (int i = 0; i < p; i++) {
				bars[i] = in.nextInt();
			}
			found = false;
			for (int i = 0; i < (1 << bars.length); i++) {
				sum = 0;
				for (int j = 0; j < bars.length; j++) {
					if ((i & (1 << j)) != 0) {
						sum += bars[j];
					}
				}
				if (sum == length) {
					found = true;
					break;
				}

			}

			if (found)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
