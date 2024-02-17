package Appointment;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class AppointmentService {
	
	private String appointmentId;
	//Stores contacts in ArrayList
	public ArrayList<Appointment> appointmentList = new ArrayList<>();
	
	/*  Uses UUID to generate random unique 10 digit Appointment Id
	 *  Converts to String character and stored as appointmentId
	 */
	private String newAppointmentId() {
		return appointmentId = UUID.randomUUID().toString().substring
				(0, Math.min(toString().length(), 10));
	}
	//Used for displaying records during JUnit testing
	public void displayAppointmentList() {
		for(int num = 0; num < appointmentList.size(); num++) {
			System.out.println("Appointment ID: " + appointmentList.get(num).getAppointmentId());
			System.out.println("Date: " + appointmentList.get(num).getDate());
			System.out.println("Description: " + appointmentList.get(num).getDescription());
		}
	}
	
	//Used for returning appointmentId during JUnit testing
	public String getAppointmentId() {
		return appointmentId;
	}
		
	/*  Adds new Appointment object utilizing UUID method for appointmentId
	 * 	Stores object values in Appointment List
	 */
	public void addAppointment(String appointmentId, Date date, 
			String description) {
		Appointment appointment = new Appointment(newAppointmentId(), date, description); 
		appointmentList.add(appointment);
	}
	
	//Iterates through appointment list and deletes record with corresponding id 
	public void deleteAppointment(String appointmentId) {
		for (int num = 0; num < appointmentList.size(); num++) {
			if(appointmentList.get(num).getAppointmentId().equals(appointmentId)) {
				appointmentList.remove(num);
				break;
			}
			if(num == appointmentList.size()-1) {
				System.out.println("Contact Id: " + appointmentId + 
						"does not exist.");
			}
		}
	}	
	/*
	//Getter searches through appointmentList and returns matching record or NULL if not found
	public Appointment getAppointment(String appointmentId) {
		Appointment newAppointment = new Appointment(null, null, null);
		for (Appointment appointment : appointmentList) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				newAppointment = appointment;
			}	
		}
		return newAppointment;
	}*/
}