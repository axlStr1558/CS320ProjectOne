package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contact.ContactService;

class ContactServiceTest {

	/* Adds three new records through ContactService
	 * Displays records and asserts the list is not null
	 */ 
	@Test
	void addContactTest() {
		System.out.println("****Add Contact Test****\n");
		ContactService service = new ContactService();
		service.addContact("John", "Smith", "4106381322", "123 Road Street");
		service.addContact("Paul", "Paulson", "4105482695", "321 Boulevard Lane");
		service.addContact("Jimmy", "Jones", "4102547896", "999 Dead End Circle");
		service.displayContactList();
		assertNotNull(service.contactList);
		
	}
	/*  Creates new contact through service.addContact() 
	 *  Displays contact list 
	 *  Gets the unique Contact Id
	 *  Iterates through Contact List and finds the matching record
	 *  Deletes the corresponding record and asserts the list is empty
	 *  Contact object will be auto deleted by the garbage collector
	 */ 
	@Test
	void deleteContactTest() {
		System.out.println("****Delete Contact Test****\n");
		ContactService service = new ContactService();
		service.addContact("William", "Riker", "3949305948", "Deck C, Section 2");
		service.displayContactList();
		String id = service.getContactId();
		for (int num = 0; num < service.contactList.size(); num++) {
			if(service.contactList.get(num).getContactId().equals(id)) {
				service.deleteContact(id);
			}
			else {
				System.out.println("Contact Id does not exist.");
			}
		}
		System.out.println(service.contactList + "\n");
		assertTrue(service.contactList.isEmpty());
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
	void updateFirstNameTest() {
		System.out.println("****Update First Name Test****\n");
		ContactService service = new ContactService();
		service.addContact("Man", "Bear Pig", "4106381322", "The Woods");		
		service.displayContactList();		
		String id = service.getContactId();			
		String name1 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String firstName = service.contactList.get(num).getFirstName();
			name1 = firstName;
		}		
		service.updateFirstName(id, "Stan");
		service.displayContactList();		
		String name2 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String firstName = service.contactList.get(num).getFirstName();
			name2 = firstName;
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
	void updateLastNameTest() {
		System.out.println("****Update Last Name Test****\n");
		ContactService service = new ContactService();
		service.addContact("Man", "Bear Pig", "4106381322", "The Woods");		
		service.displayContactList();		
		String id = service.getContactId();			
		String name1 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String lastName = service.contactList.get(num).getLastName();
			name1 = lastName;
		}		
		service.updateLastName(id, "Marsh");
		service.displayContactList();		
		String name2 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String lastName = service.contactList.get(num).getLastName();
			name2 = lastName;
		}		
		assertNotSame(name1, name2);
		
	}
	
	/*  Creates new contact through service.addContact() 
	 *  Displays contact list 
	 *  Gets the unique Contact Id
	 *  Iterates through Contact List and assigns phone1 to the matching record
	 *  Updates the first name
	 *  Iterates through Contact List and assigns phone2 to the updated record
	 *  Redisplays contact list
	 *  Asserts both name variables are not identical
	 */ 
	@Test
	void updatePhoneNumberTest() {
		System.out.println("****Update Phone Number Test****\n");
		ContactService service = new ContactService();
		service.addContact("Man", "Bear Pig", "1234567890", "The Woods");		
		service.displayContactList();		
		String id = service.getContactId();			
		String phone1 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String phone = service.contactList.get(num).getPhone();
			phone1 = phone;
		}		
		service.updatePhone(id, "1111111111");
		service.displayContactList();		
		String phone2 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String phone = service.contactList.get(num).getPhone();
			phone2 = phone;
		}		
		assertNotSame(phone1, phone2);
		
	}
	
	
	/*  Creates new contact through service.addContact() 
	 *  Displays contact list 
	 *  Gets the unique Contact Id
	 *  Iterates through Contact List and assigns address1 to the matching record
	 *  Updates the first name
	 *  Iterates through Contact List and assigns address2 to the updated record
	 *  Redisplays contact list
	 *  Asserts both name variables are not identical
	 */ 
	@Test
	void updateAddressTest() {
		System.out.println("****Update Address Test****\n");
		ContactService service = new ContactService();
		service.addContact("Man", "Bear Pig", "4106381322", "The Woods");		
		service.displayContactList();		
		String id = service.getContactId();			
		String address1 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String address = service.contactList.get(num).getAddress();
			address1 = address;
		}		
		service.updateAddress(id, "A Nice Cottage");
		service.displayContactList();		
		String address2 = null;
		for(int num = 0; num < service.contactList.size(); num++) {
			String address = service.contactList.get(num).getAddress();
			address2 = address;
		}		
		assertNotSame(address1, address2);		
	}
}
