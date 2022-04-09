
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static String s, d;
	static boolean[][] states;
	static Stack<Character> stack;
	static StringBuilder result;
	static boolean[] io;
	static int indice;
	static int resultIndice;

	static void print(boolean[] io) {

		for (int i = 0; i < io.length - 1; i++) {
			writer.print(io[i] ? "i " : "o ");

		}
		writer.println(io[io.length - 1] ? "i" : "o");

	}

	static void backtrack(int col) {
		

		if(result.length() != 0 &&  !d.startsWith(result.toString()))
		{
			return ;

		}

		if (result.toString().equals(d))
			print(io);



		if (col == states[0].length)
			return;

		for (int i = 0; i < states.length; i++) {

			boolean doBacktracking = true;
			char poped = 0;

			if (states[i][col]) {

				if (indice == s.length())
					continue;

				io[col] = states[i][col];
				stack.push(s.charAt(indice++));

			} else {
				if (stack.isEmpty())
					return;

				io[col] = states[i][col];
				poped = stack.pop();


				result.append(poped);


			}

			backtrack(col + 1);

			if (states[i][col]) {
				indice--;
				stack.pop();
			} else {

				stack.push(poped);

				result =  result.delete(result.length() -1 , result.length());


			}

			io[col] = false;// undo

		}

	}

	static PrintWriter writer;

	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		long startTime = System.currentTimeMillis();

		while ((s = reader.readLine()) != null) {
			while (s.equals(""))
				s = reader.readLine();

			d = reader.readLine();
			while (d.equals(""))
				d = reader.readLine();

			stack = new Stack<>();
			indice = 0;
			result = new StringBuilder();
			resultIndice = 0;
			states = new boolean[2][Math.max(s.length(), d.length()) * 2];
			io = new boolean[Math.max(s.length(), d.length()) * 2];

			Arrays.fill(states[0], true);
			Arrays.fill(states[1], false);
			writer.println("[");
			backtrack(0);
			writer.println("]");

		}

		long estimatedTime = System.currentTimeMillis() - startTime;

		writer.println(estimatedTime);
		writer.close();
	}

}
