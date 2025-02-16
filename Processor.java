import java.util.*;

public class Processor implements Comparable<Processor>{
	
	private int id;
	private List<Task>processedTasks;
	
	public Processor(int id){//constructor
		this.id = id;//give the processor an id
		processedTasks = new List<Task>();//create a new single-linked list for the tasks of the processor
	}
	
	public int getActiveTime() {//if there are tasks in the list return the total time the processor proceed them
		if(processedTasks.isEmpty()) {
			return 0;//if there are not return 0
		}else {
			int sum = 0;//sum of processing times
			Node<Task> h = processedTasks.getHead();
			Node <Task> iterator = h;
			Task dat;
			while (iterator != null) {
				dat = iterator.getData();
				sum += dat.getTime();//add the processing times
				iterator = iterator.getNext();
			}
			return sum;//return the active time
		}
	}
	
	public boolean compareTo(Processor b) {//implements Comparable--return true if the second processor has the advantage
		int ta = this.getActiveTime();
		int tb = b.getActiveTime();
		if (ta>tb) {//compare the active times of the two processors
			return true;//and return true if the active time of the first is higher
		}else if (ta<tb) {
			return false;//else if the second's active time is higher return false
		}else {//else if both of them have the same active time
			int ia = this.getId();
			int ib = b.getId();
			if (ia>ib) {//compare the id
				return true;//if the first's id is higher return true
			}else {
				return false;//if the second's id is higher return false
			}
		}
	}
	
	public void addTask(Task t) {//add a task in the processor's list
		processedTasks.insertAtFront(t);
	}
	
	public int getId() {//get the processor's id
		return this.id;
	}
	
	public String getStrTasks() {//return a String with the contents of the task-list
		String word = "";
		Node<Task> h = processedTasks.getHead();
		Node <Task> iterator = h;
		Task dat;
		while (iterator != null) {
			dat = iterator.getData();
			word = String.valueOf(dat.getTime()) + " " + word;//add to the String the processing time of every task  
			iterator = iterator.getNext();
		}
		return word;//return the String
	}
	
	public String toString() {//print all the informations about the processor
		return "id " + this.getId() + ", load=" + this.getActiveTime() + ": " + this.getStrTasks();
	}
}