package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;



class ContactTest {
	//Tests functionality of Contact class within normal parameters
	@Test
	void testContactClass() {
		Contact contact = new Contact("1234567890","John",
				"Snow","1234567890","123 Fake Street");
		assertTrue(contact.getContactId().equals("1234567890"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Snow"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Fake Street"));
	}
	
	//Assertions that field names are correct length
	@Test
	void testContactClassContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("12345678901","John","Snow","1234567890","123 Fake Street");
		});		
	}	
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Maximus Decimus","Meridius",
				"1234567890","123 Fake Street");
		});		
	}
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","James","SuperLongLastName",
				"1234567890","123 Fake Street");
		});		
	}	
	@Test
	void testContactClassPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max","Meridius",
				"12345678901","123 Fake Street");
		});		
	}	
	@Test
	void testContactClassPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max","Meridius",
				"123456789","123 Fake Street");
		});		
	}	
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max", "Meridius",
				"1234567890","123 Fake Street, Planet Earth 94035");
		});		
	}
	
	//Assertions that field arguments are not Null
	@Test
	void testContactClassContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact(null,"Max", "Meridius",
				"1234567890","123 Fake Street");
		});		
	}
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890",null, "Meridius",
				"1234567890","123 Fake Street");
		});		
	}
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max", null,
				"1234567890","123 Fake Street");
		});		
	}
	@Test
	void testContactClassPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max", "Meridius",
				null,"123 Fake Street");
		});		
	}
	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		new Contact("1234567890","Max", "Meridius",
				"1234567890",null);
		});		
	}	
}
