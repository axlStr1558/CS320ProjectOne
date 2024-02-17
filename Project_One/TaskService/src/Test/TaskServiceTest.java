package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Task.TaskService;

class TaskServiceTest {

	/* Adds three new records through TaskService
	 * Displays records and asserts the list is not null
	 */ 
	@Test
	void addTaskTest() {
		System.out.println("****Add Task Test****\n");
		TaskService service = new TaskService();
		service.addTask("Task 1", "A description of Task 1.");
		service.addTask("Task 2", "a;lksjdfasfkjjdf");
		service.addTask("Task 3", "[Insert Detailed description]");
		service.displayTaskList();
		assertNotNull(service.taskList);
		
	}
	/*  Creates new contact through service.addTask() 
	 *  Displays task list 
	 *  Gets the unique Task Id
	 *  Iterates through Task List and finds the matching record
	 *  Deletes the corresponding record and asserts the list is empty
	 *  Task object will be auto deleted by the garbage collector
	 */ 
	@Test
	void deleteTaskTest() {
		System.out.println("****Delete Task Test****\n");
		TaskService service = new TaskService();
		service.addTask("Task 4", "A description of Task 4.");
		service.displayTaskList();
		String id = service.getTaskId();
		for (int num = 0; num < service.taskList.size(); num++) {
			if(service.taskList.get(num).getTaskId().equals(id)) {
				service.deleteTask(id);
			}
			else {
				System.out.println("Task Id does not exist.");
			}
		}
		System.out.println(service.taskList + "\n");
		assertTrue(service.taskList.isEmpty());
	}
	
	/*  Creates new task through service.addTask() 
	 *  Displays task list 
	 *  Gets the unique Task Id
	 *  Iterates through Task List and assigns name1 to the matching record
	 *  Updates the name
	 *  Iterates through Task List and assigns name2 to the updated record
	 *  Redisplays task list
	 *  Asserts both name variables are not identical
	 */ 
	@Test
	void updateNameTest() {
		System.out.println("****Update Name Test****\n");
		TaskService service = new TaskService();
		service.addTask("Task 5", "Description Goes Here.");		
		service.displayTaskList();		
		String id = service.getTaskId();			
		String name1 = null;
		for(int num = 0; num < service.taskList.size(); num++) {
			String name = service.taskList.get(num).getName();
			name1 = name;
		}		
		service.updateName(id, "Updated task name");
		service.displayTaskList();		
		String name2 = null;
		for(int num = 0; num < service.taskList.size(); num++) {
			String name = service.taskList.get(num).getName();
			name2 = name;
		}		
		assertNotSame(name1, name2);
		
	}
	
	/*  Creates new contact through service.addContact() 
	 *  Displays contact list 
	 *  Gets the unique Contact Id
	 *  Iterates through Contact List and assigns name1 to the matching record
	 *  Updates the first name
	 *  Iterates through Contact List and assigns name2 to the updated record
	 *  Redisplays contact list
	 *  Asserts both name variables are not identical
	 */ 
	@Test
	void updateDescriptionTest() {
		System.out.println("****Update Description Test****\n");
		TaskService service = new TaskService();
		service.addTask("Task 10", "The Ultimate Task");		
		service.displayTaskList();		
		String id = service.getTaskId();			
		String description1 = null;
		for(int num = 0; num < service.taskList.size(); num++) {
			String description = service.taskList.get(num).getDescription();
			description1 = description;
		}		
		service.updateDescription(id, "The Ultimate Test further described.");
		service.displayTaskList();		
		String description2 = null;
		for(int num = 0; num < service.taskList.size(); num++) {
			String description = service.taskList.get(num).getDescription();
			description2 = description;
		}		
		assertNotSame(description1, description2);
		
	}
}
