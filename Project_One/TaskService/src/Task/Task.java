package Task;

public class Task {
	
	private String taskId;
	private String name;
	private String description;
	
	/*  Task class constructor
	 *  Enables error checking for null fields and length requirements
	 */
	public Task(String taskId, String name, String description) {
		
		if (taskId == null || taskId.length()>10) {    
			throw new IllegalArgumentException("Invalid Id");
		}
		if (name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	//Getters
	public String getTaskId() {
		return taskId;
	}	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	//Setters with same parameters as the Task constructor
	public void setTaskId(String taskId) {
		if (taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid Id");			
		}
		else {
			this.taskId = taskId;
		}
	}
	public void setName(String name) {
		if (name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid Name");			
		}
		else {
			this.name = name;
		}
	}
	public void setDescription(String description) {
		if (description == null || description.length()>50) {
				throw new IllegalArgumentException("Invalid Description");			
		}
		else {
			this.description = description;
		}
	}
}
