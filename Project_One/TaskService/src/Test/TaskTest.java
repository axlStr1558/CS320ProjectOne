package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;



class TaskTest {
	//Tests functionality of Task class within normal parameters
	@Test
	void testTaskClass() {
		Task task = new Task("1234567890", "Task 1", "Insert Description Here");
		assertTrue(task.getTaskId().equals("1234567890"));
		assertTrue(task.getName().equals("Task 1"));
		assertTrue(task.getDescription().equals("Insert Description Here"));
	}
	
	//Assertions that field names are correct length
	@Test
	void testTaskClassTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task("12345678901", "Task 1", "Insert Description Here");
		});		
	}	
	@Test
	void testTaskClassNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task("1234567890","Task 1 Name Is Way Too Long", "Insert Description Here");
		});		
	}
	@Test
	void testTaskClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task("1234567890", "Task 1", 
				"Insert Description Here and add way more decriptive phrasing so you get it right!");
		});		
	}		
	
	//Assertions that field arguments are not Null
	@Test
	void testTaskClassTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task(null, "Task 1", "Insert Description Here");
		});		
	}
	@Test
	void testTaskClassNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task("1234567890", null, "Insert Description Here");
		});		
	}
	@Test
	void testTaskClassDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Task("1234567890", "Task 1", null);
		});		
	}		
}
