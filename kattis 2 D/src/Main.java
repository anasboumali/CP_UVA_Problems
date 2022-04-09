import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;






public class Main {




	


	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
//		InputStream inputStream = new FileInputStream("in.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	//	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


		
		
		String input = "!   9        \"   6        #  24        $  29        %  22 " +
"&  24        '   3        (  12        )  12        *  17        +  13 "+
",   7        -   7        .   4        /  10        0  22        1  19 "+
"2  22        3  23        4  21        5  27        6  26        7  16 "+
"8  23        9  26        :   8        ;  11        <  10        =  14 "+
">  10        ?  15        @  32        A  24        B  29        C  20 "+
"D  26        E  26        F  20        G  25        H  25        I  18 "+
"J  18        K  21        L  16        M  28        N  25        O  26 "+
"P  23        Q  31        R  28        S  25        T  16        U  23 "+
"V  19        W  26        X  18        Y  14        Z  22        [  18 "+
"\\  10        ]  18        ^   7        _   8        `   3        a  23 "+
"b  25        c  17        d  25        e  23        f  18        g  30 "+
"h  21        i  15        j  20        k  21        l  16        m  22 "+
"n  18        o  20        p  25        q  25        r  13        s  21 "+
"t  17        u  17        v  13        w  19        x  13        y  24 "+
"z  19        {  18        |  12        }  18        ~   9 ";
		
		
        Scanner sc = new Scanner(input);
        HashMap<String , Integer> map = new HashMap<>();
        map.put(" ", 0);
        while(sc.hasNext())
        {
        	String key = sc.next();
        	int value = sc.nextInt();
        	
        	map.put(key, value);
        	
        }
        
//        System.out.println(map);
        	String line ;
				while((line   = reader.readLine()) != null)
				{
					
			        
			        int somme = 0;
			        for (int i = 0; i < line.length(); i++) {
						somme += map.get(Character.toString(line.charAt(i)) );
					}
			        
			        System.out.println(somme);

				}

				
			}
			
		
		

			

		

	
		//writer.close();
	

}
