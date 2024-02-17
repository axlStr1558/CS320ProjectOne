package Task;

import java.util.ArrayList;
import java.util.UUID;

public class TaskService {
	
	private String taskId;
	//Stores contacts in ArrayList
	public ArrayList<Task> taskList = new ArrayList<>();
	
	/*  Uses UUID to generate random unique 10 digit Task Id
	 *  Converts to String character and stored as taskId
	 */
	private String newTaskId() {
		return taskId = UUID.randomUUID().toString().substring
				(0, Math.min(toString().length(), 10));
	}
	//Used for displaying records during JUnit testing
	public void displayTaskList() {
		for(int num = 0; num < taskList.size(); num++) {
			System.out.println("Task ID: " + taskList.get(num).getTaskId());
			System.out.println("Name: " + taskList.get(num).getName());
			System.out.println("Description: " + taskList.get(num).getDescription());
		}
	}
	
	//Used for returning taskId during JUnit testing
	public String getTaskId() {
		return taskId;
	}
		
	/*  Adds new Task object utilizing UUID method for taskId
	 * 	Stores object values in Task List
	 */
	public void addTask(String name, String description) {
		Task task = new Task(newTaskId(), name, description); 
		taskList.add(task);
	}
	
	//Iterates through task list and deletes record with corresponding id 
	public void deleteTask(String taskId) {
		for (int num = 0; num < taskList.size(); num++) {
			if(taskList.get(num).getTaskId().equals(taskId)) {
				taskList.remove(num);
				break;
			}
			if(num == taskList.size()-1) {
				System.out.println("Contact Id: " + taskId + 
						"does not exist.");
			}
		}
	}
	//Update functions
	public void updateName(String contactId, String newName) {
		for (int num = 0; num < taskList.size(); num++) {
			if(taskList.get(num).getTaskId().equals(taskId)) {
				taskList.get(num).setName(newName);
				break;
			}
			else {
				System.out.println("Task Id: " + taskId + 
						"does not exist.");
			}
		}
	}
	public void updateDescription(String contactId, String newDescription) {
		for (int num = 0; num < taskList.size(); num++) {
			if(taskList.get(num).getTaskId().equals(taskId)) {
				taskList.get(num).setDescription(newDescription);
				break;
			}
			else {
				System.out.println("Task Id: " + taskId + 
						"does not exist.");
			}
		}
	}	
}
