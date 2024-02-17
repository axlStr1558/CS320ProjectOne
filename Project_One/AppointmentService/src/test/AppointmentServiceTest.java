package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Appointment.AppointmentService;

class AppointmentServiceTest {

	//creates valid and invalid test dates to test against Appointment class
	@SuppressWarnings("deprecation")	
	Date testDate1 = new Date(2024, 3, 1, 12, 30);
	Date testDate2 = new Date(2024, 3, 2, 10, 15);
	Date testDate3 = new Date(2024, 3, 1, 9, 30);
	Date invalidDate = new Date(3, 1, 12, 30, 2024);
	
	/* Adds three new records through AppointmentService
	 * Displays records and asserts the list is not null
	 */ 
	@Test
	void addAppointmentTest() {
		System.out.println("****Add Appointment Test****\n");
		AppointmentService service = new AppointmentService();
		service.addAppointment("0000000000", testDate1, "Dental Cleaning");
		service.addAppointment("1111111111", testDate2, "Crown Molding");
		service.addAppointment("2222222222", testDate3, "Teeth Extraction");
		service.displayAppointmentList();
		assertNotNull(service.appointmentList);		
		
	}
	/*  Creates new contact through service.addAppointment() 
	 *  Displays appointment list 
	 *  Gets the unique Appointment Id
	 *  Iterates through Appointment List and finds the matching record
	 *  Deletes the corresponding record and asserts the list is empty
	 *  Appointment object will be auto deleted by the garbage collector
	 */ 
	@Test
	void deleteAppointmentTest() {
		System.out.println("****Delete Appointment Test****\n");
		AppointmentService service = new AppointmentService();
		service.addAppointment("0000000000", testDate1, "Dental Cleaning");
		service.displayAppointmentList();
		String id = service.getAppointmentId();
		for (int num = 0; num < service.appointmentList.size(); num++) {
			if(service.appointmentList.get(num).getAppointmentId().equals(id)) {
				service.deleteAppointment(id);
			}
			else {
				System.out.println("Appointment Id does not exist.");
			}
		}
		System.out.println(service.appointmentList + "\n");
		assertTrue(service.appointmentList.isEmpty());
	}
}
