
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Locale;

public class Main {

	

	

	
	public static void main(String[] arg)
	{		
		
		Scanner in = new Scanner(System.in);

//		Scanner in = null;
		
//		try {
//			 in = new Scanner(new FileReader("in.txt"));
//			
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		}

		Locale.setDefault(new Locale("en", "US"));
		Date time = null;
		double angle;
		double minute ;
		double hour;
		SimpleDateFormat  sdf = new SimpleDateFormat("HH:mm");
		while(in.hasNext())
		{
			String sTime = in.nextLine();
			if(sTime.isEmpty())
				break;
			
			try {
				time = sdf.parse(sTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if( time.compareTo(new SimpleDateFormat("HH:mm").parse("00:00"))  == 0)
					break;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			minute =  ((double)time.getMinutes()/5.0F ) ;
			minute = minute <= 6 ? minute :  minute - 12 ;
			
			hour =  time.getHours() + time.getMinutes()/60.0F;
			

			
			hour = hour < 6 ? hour : hour - 12 ;
			
			
			
			angle = (Math.abs(hour - minute)*30.0F);
			if( angle >= 180)
				angle = 360  - angle;
					
			System.out.println(String.format("%.3f", angle));
			
		}
			
		


	
	}
}
