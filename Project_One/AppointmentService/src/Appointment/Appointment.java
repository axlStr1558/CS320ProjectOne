package Appointment;

import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private Date date;
	private String description;
	
	
	/*  Appointment class constructor
	 *  Enables error checking for null fields and length requirements
	 */
	public Appointment(String appointmentId, Date date, 
		String description) {
		if (appointmentId == null || appointmentId.length()>10) {    
			throw new IllegalArgumentException("Invalid Id");
		}
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
	}
	
	//Getters
	public String getAppointmentId() {
		return appointmentId;
	}	
	public Date getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
	
	//Setters with same parameters as the Appointment constructor	
	public void setDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Last Name");			
		}
		else {
			this.date = date;
		}
	}	
	public void setDescription(String description) {
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid First Name");			
		}
		else {
			this.description = description;
		}
	}
}
