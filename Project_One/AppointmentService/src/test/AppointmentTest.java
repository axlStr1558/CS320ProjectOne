package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Appointment.Appointment;

import java.util.Date;


class AppointmentTest {
	
	//creates valid and invalid test dates to test against Appointment class
	@SuppressWarnings("deprecation")	
	Date testDate = new Date(2024, 3, 1, 12, 30);
	Date invalidDate = new Date(3, 1, 12, 30, 2024);
	
	//Tests functionality of Appointment class within normal parameters
		@Test
		void testAppointmentClass() {
			Appointment appointment = new Appointment("1234567890", testDate,
					"Description of the appointment.");
			assertTrue(appointment.getAppointmentId().equals("1234567890"));
			assertTrue(appointment.getDate().equals(testDate));
			System.out.println(appointment.getDate());
			assertTrue(appointment.getDescription().equals("Description of the appointment."));
		}
		
		//Assertions that field names are correct length
		@Test
		void testAppointmentClassContactIdTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678901", testDate,
					"Description of the appointment.");
			});		
		}	
		@Test
		void testAppointmentClassDateInvalidFormat() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", invalidDate,
					"Description of the appointment.");
			});		
		}
		@Test
		void testAppointmentClassDescriptionTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", testDate,
					"Description of the appointment. Additional words to make the description"
					+ "over 50 characters which would not be advisable since there are only"
					+ "allowed 50 characters in this description.");
			});		
		}	
				
		//Assertions that field arguments are not Null
		@Test
		void testAppointmentClassContactIdNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, testDate,
					"Description of the appointment.");
			});		
		}
		@Test
		void testContactClassFirstNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", null,
					"Description of the appointment.");
			});		
		}
		@Test
		void testContactClassLastNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", testDate, null);
			});		
		}		
	}
