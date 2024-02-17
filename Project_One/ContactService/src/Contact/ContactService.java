package Contact;

import java.util.ArrayList;
import java.util.UUID;

public class ContactService {
	
	private String contactId;
	//Stores contacts in ArrayList
	public ArrayList<Contact> contactList = new ArrayList<>();
	
	/*  Uses UUID to generate random unique 10 digit Contact Id
	 *  Converts to String character and stored as contactId
	 */
	private String newContactId() {
		return contactId = UUID.randomUUID().toString().substring
				(0, Math.min(toString().length(), 10));
	}
	//Used for displaying records during junit testing
	public void displayContactList() {
		for(int num = 0; num < contactList.size(); num++) {
			System.out.println("Contact ID: " + contactList.get(num).getContactId());
			System.out.println("First Name: " + contactList.get(num).getFirstName());
			System.out.println("Last Name: " + contactList.get(num).getLastName());
			System.out.println("Phone Number: " + contactList.get(num).getPhone());
			System.out.println("Address: " + contactList.get(num).getAddress() + "\n");
		}
	}
	
	//Used for returning contactId during junit testing
	public String getContactId() {
		return contactId;
	}
		
	/*  Adds new Contact object utilizing UUID method for contactId
	 * 	Stores object values in Contact List
	 */
	public void addContact(String firstName, String lastName,
			String phoneNumber, String address) {
		Contact contact = new Contact(newContactId(), firstName, lastName,
			phoneNumber, address); 
		contactList.add(contact);
	}
	
	//Iterates through contact list and deletes record with corresponding id 
	public void deleteContact(String contactId) {
		for (int num = 0; num < contactList.size(); num++) {
			if(contactList.get(num).getContactId().equals(contactId)) {
				contactList.remove(num);
				break;
			}
			if(num == contactList.size()-1) {
				System.out.println("Contact Id: " + contactId + 
						"does not exist.");
			}
		}
	}
	
	public void updateFirstName(String contactId, String newFirstName) {
		for (int num = 0; num < contactList.size(); num++) {
			if(contactList.get(num).getContactId().equals(contactId)) {
				contactList.get(num).setFirstName(newFirstName);
				break;
			}
			else {
				System.out.println("Contact Id: " + contactId + 
						"does not exist.");
			}
		}
	}
	public void updateLastName(String contactId, String newLastName) {
		for (int num = 0; num < contactList.size(); num++) {
			if(contactList.get(num).getContactId().equals(contactId)) {
				contactList.get(num).setLastName(newLastName);
				break;
			}
			else {
				System.out.println("Contact Id: " + contactId + 
						"does not exist.");
			}
		}
	}
	public void updatePhone(String contactId, String newPhone) {
		for (int num = 0; num < contactList.size(); num++) {
			if(contactList.get(num).getContactId().equals(contactId)) {
				contactList.get(num).setPhone(newPhone);
				break;
			}
			else {
				System.out.println("Contact Id: " + contactId + 
						"does not exist.");
			}
		}
	}
	public void updateAddress(String contactId, String newAddress) {
		for (int num = 0; num < contactList.size(); num++) {
			if(contactList.get(num).getContactId().equals(contactId)) {
				contactList.get(num).setAddress(newAddress);
				break;
			}
			else {
				System.out.println("Contact Id: " + contactId + 
						"does not exist.");
			}
		}
	}	
}
