package com.daynine;
import java.util.*;
import java.io.*;



public class AddressBookMain{
	
	ArrayList<Person> data=new ArrayList<Person>();
	
	Map<String, ArrayList<Person>> addressBooks = new HashMap<String, ArrayList<Person>>();
	
	Set<Person> data1 = new HashSet<Person>();
	
	public boolean isBookPresent(String bookName) {

		boolean isBookPresent = false;

		try {
			isBookPresent = addressBooks.containsKey(bookName);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isBookPresent;
	}

	public void bookOperations() {

		System.out.println("Enter the Book Name ");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next().toUpperCase();
		ArrayList<Person> contactList = this.addPerson(bookName);

		if (addressBooks.equals(null)) {
			contactList = this.addPerson(bookName);
		}

		if (addressBooks.containsKey(bookName.toUpperCase())) {
			try {
				if (contactList == null) {
					System.out.println("Contact of person is already present in book");

				} else {
					addressBooks.get(bookName).addAll(contactList);
					System.out.println(" Added a contact to " + bookName);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		} else {
			addressBooks.put(bookName, contactList);
			System.out.println(" New book " + bookName + " is created");
			System.out.println(" Contact is added to " + bookName);

		}
	}
	
	public String readString(String displayMessage){

		Scanner sc = new Scanner(System.in);
		System.out.print(displayMessage);
		String input=sc.nextLine();

		return input;
	}
	public long readLong(String displayMessage){

		Scanner sc = new Scanner(System.in);
		System.out.print(displayMessage);
		long input=sc.nextLong();
		
		return input;
	}
	public int indexOfPerson(){

		System.out.println();
		String firstname=readString("Enter Person's first name: ");
		long phoneNumber=readLong("Enter the phone number: ");

		int index=0;
		for(Person p : this.data)
		{
			if(p.getFirstName().equals(firstname) && p.getPhoneNumber()==phoneNumber){
				return index;
			}
			++index;
		}
		return -1;
	}

	public ArrayList<Person> addPerson( String bookName){
		
		
		ArrayList<Person> persons = new ArrayList<Person>();
		
		System.out.println();
		String firstname=readString("Enter Person's first name: ");
		String lastname=readString("Enter Person's last name: ");
		boolean isFoundMap = false;
		boolean isBookNotPresent = false;
		isBookNotPresent = addressBooks.get(bookName) == null;

		try {
			if ((!(addressBooks.isEmpty())) && !(isBookNotPresent)) {
				isFoundMap = addressBooks.get(bookName).stream()
						.anyMatch(cs -> cs.getFirstName().equalsIgnoreCase(firstname)
								&& cs.getLastName().equalsIgnoreCase(lastname));
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		if (isFoundMap == false) {
		String city=readString("Enter the City: ");
		String state=readString("Enter State: ");
		String address=readString("Enter full address: ");
		long zipCode=readLong("Erea's Zip Code: ");
		long phoneNumber=readLong("Enter phone number: ");
		String email=readString("Enter email id: ");
		
		
		
		
		Person newEntry=new Person(firstname,lastname, city, state, address, zipCode, phoneNumber, email);
		
	
		this.data.add(newEntry);
		System.out.println("\n[*]\t"+firstname+" added successfully to address book.");
		} else if (isFoundMap == true) {

			return null;
		}
		return persons;
	}
	
	
	public void editPerson(){

		int index=this.indexOfPerson();

		if(index != -1){
			String options="\tWhat you want to change?\n\t1. City\n\t2. State\n\t3. Address\n\t4. Zip Code\n\t5. PhoneNumber\n\t6 Emailid\n: ";
			int choice=(int)readLong(options);

			switch(choice)
			{
				case 1: 
					this.data.get(index).setCity(readString("Enter new City: "));
					System.out.println("\tEntry Modified");
					break;
				case 2: 
					this.data.get(index).setState(readString("Enter new State: "));
					System.out.println("\tEntry Modified");
					break;
				case 3: 
					this.data.get(index).setAddress(readString("Enter new Address: "));
					System.out.println("\tEntry Modified");
					break;
				case 4: 
					this.data.get(index).setZipCode(readLong("Enter new Zip Code: "));
					System.out.println("\tEntry Modified");
					break;
				case 5: 
					this.data.get(index).setPhoneNumber(readLong("Enter new Phone number: "));
					System.out.println("\tEntry Modified");
					break;
				case 6:
					this.data.get(index).setEmailid(readString("Enter new Email id: "));
					System.out.println("");
					break;
				default:
					System.out.println("\n\tBad Input!");
			}
		}
		else{

			System.out.println("\n\tNo such person found!");
		}
	}
	public void deletePerson(){
		
		int index=this.indexOfPerson();

		if(index != -1){

			Person p=this.data.remove(index);
			System.out.println("\n\tPerson "+p.getFirstName()+" with mobile number "+p.getPhoneNumber()+" removed successfully.");
		}
		else{

			System.out.println("\n\tNo one with these details found!");
		}
	}
	

	public void showPerson(){

		int index=this.indexOfPerson();

		if(index != -1){

			this.data.get(index).showPersonsDetails();
		}
		else{

			System.out.println("\n\tNo one with these details found!");
		}
	}
	public void showAllPersons(){

		for(Person p : this.data)
		{
			p.showPersonsDetails();
		}
		if(this.data.isEmpty()){

			System.out.println("\n\n\t\tAddress Book is empty!\t\t\n");
		}
	}

	
	public void runMenu(){
		
		long choice=-1;
		while(choice != 0)
		{
			System.out.println();
			System.out.println("--------------------Address Book--------------------");
			System.out.println("| 1. Add a person");
			System.out.println("| 2. Edit a person");
			System.out.println("| 3. Delete a person");
			System.out.println("| 4. Show a person");
			System.out.println("| 5. Show all persons");
			System.out.println("| 6. Show address books");
			System.out.println("| 7. Exit");
			System.out.println("-----------------------------------------------------");
			choice=readLong("Enter your choice: ");

			switch((int)choice)
			{
				case 1: addPerson(null);
					break;
				case 2: editPerson();
					break;
				case 3: deletePerson();
					break;
				case 4: showPerson();
					break;
				case 5: showAllPersons();
					break;
				case 6 : showBookName();
					break;
				case 7: choice = 0;
					break;
				default: System.out.println("\n\tBad Input!");
			}
		}
	}
	
	public void showBookName() {
		for (Map.Entry<String, ArrayList<Person>> set : addressBooks.entrySet()) {
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}
	
	public void displayBook(String bookName) {

		addressBooks.keySet().stream().filter(book -> book.equals(bookName)).map(book -> addressBooks.get(bookName))
				.forEach(System.out::println);

	}

	public static void main(String[] args) {
		
		AddressBookMain newBook=new AddressBookMain();
		newBook.runMenu();
	}
}