import java.io.*;
import java.util.*;

public class Greedy{
	public static void main(String[] args) {
		BufferedReader reader = null;
		String filename = args[0];//read the filename
		String line;
		String word = "";
		int p,t,c,idt,timet,nt,ex;//p=processors t=tasks, idt=id of task, timet=processing time of task, nt=number of tasks the txt contains  
		int i = 1;
		boolean flag = false;//a flag to check the txt
		Processor x;
		Task y;
		MaxPQ pq = new MaxPQ(new ProcessorComparator());//new priority queue
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));//open the file
			line = reader.readLine();//read the first line
			while (line != null) {//while there is a line
				if (line.length() != 0){//if the line contains numbers
					flag = true;
					p = Integer.parseInt(line);//store the number of processors from this line
					for (i = i;i<=p;i++) {
						pq.insert(new Processor(i));//create the number of processors you read before
					} 
					line = reader.readLine();//read the next line
					t = Integer.parseInt(line);//store the number of tasks from this line
					line = reader.readLine();
				
					nt = 0;//start counting the tasks you read
				
					while (nt<t && line != null) {//while there are more tasks you have to read and there is a line
						if (line.length() != 0){
							c = 0;
							while (!(String.valueOf(line.charAt(c)).equals(" "))) {//read the line char by char until you find a space
								word += String.valueOf(line.charAt(c));//store the number 
								c++;
							}
							idt = Integer.parseInt(word);//convert the number and store the task's id
							word = "";
							c++;
							word = line.substring(c);//store the number
							timet = Integer.parseInt(word);//convert the number and store the task's processing time
							word = "";
							nt++;//count the task you just read
							y = new Task(idt,timet);//create a task 
							x = pq.getmax();//get and remove the processor with the highest priority
							x.addTask(y);//add to this processor the task
							pq.insert(x);//add the processor again to the priority queue
						}
						line = reader.readLine();
					
					}
				
					if (nt < t) {//if there were less tasks in the txt than it said in the beginning
						System.out.println("There are less Tasks than you said before!");//print error message
						flag = false;
						break;//exit
					}
					
					if (line != null && line.length() != 0) {//if there are extra lines which contain more numbers
						System.out.println("There are more Tasks than you said before!");//print error message
						flag = false;
						break;//exit
						
					}
					
				}else{
					line = reader.readLine();
				}
				
			}
			reader.close();//close the txt
		}
		
		catch (IOException e) {
			System.out.println("Error reading line...");//print error message
		}
		if (flag) {//if everything is correct with the txt
			pq.printMaxPQ();//print the whole priority queue
			System.out.println("Makespan = " + pq.makespan());//print the Makespan
		}
		
	}
}