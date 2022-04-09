import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.ValidationEvent;




public class Main {


	

	static class Employee implements Comparable<Employee>
	{
		
			String dep ;
		  String title ;
		  String adresse;
		  @Override
		public String toString() {
			return title + " " + firstName + " " +  lastName + "\n" + 
					adresse + "\n" + 
					"Department: " + dep +"\n" + 
					"Home Phone: " + homePhone + "\n" + 
					"Work Phone: " + workPhone + "\n" + 
					"Campus Box: " + campusBox ;
					
		  
		  }

		public Employee(String dep, String title, String firstName, String lastName,String adresse ,String homePhone, String workPhone,
				String campusBox) {
			super();
			this.dep = dep;
			this.title = title;
			this.firstName = firstName;
			this.lastName = lastName;
			this.adresse = adresse;
			this.homePhone = homePhone;
			this.workPhone = workPhone;
			this.campusBox = campusBox;
		}

		String  firstName ;
		  

		String lastName   ;
		  String homePhone ;
		  String workPhone ;
		  


		String campusBox ;

		@Override
		public int compareTo(Employee o) {
			return lastName.compareTo(o.lastName);
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		 InputStream inputStream = System.in;
//		  InputStream inputStream = new FileInputStream("in.txt");

		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  String line ;
		  

		  int T  = Integer.parseInt(reader.readLine());
		  int order = 0;
		  PriorityQueue<Employee> pq = new PriorityQueue<>();

		  while(T-- > 0)
		  {
			  String dep = reader.readLine();
			  while((line = reader.readLine()) != null &&  !line.equals(""))
			  {
				  String[] infos = line.split(",");
				  String title = infos[0];
				  String  firstName = infos[1];
				  String lastName   = infos[2];
				  String adress  = infos[3]; 
				  String homePhone  = infos[4];
				  String workPhone = infos[5];
				  String campusBox = infos[6];
				  pq.add(new Employee(dep ,title,  firstName, lastName, adress,homePhone, workPhone, campusBox));
				  
				
						
				
				  
				  
				  
			  }
			  

			  
			  
		  }
		
	  while(!pq.isEmpty())
	  {
		  System.out.println("----------------------------------------");
		  System.out.println(pq.poll());
		  
	  }
	  
			  
		  }
		




}
