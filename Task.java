public class Task{
	
	private int id;
	private int time;
	
	public Task(int id,int time){//constructor
		this.id = id;//id of the task
		this.time = time;//processing time of the task
	}
	
	public int getId() {//return task's id
		return this.id;
	}
	
	public int getTime() {//return tasks's processing time
		return this.time;
	}
}

