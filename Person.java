package com.daynine;
import java.util.*;
import java.io.*;
public class Person {
	
		private String firstname;
		private String lastname;
		private String city;
		private String state;
		private String address;
		private long zipCode;
		private long phoneNumber;
		private String email;
		
		public Person(String firstname,String lastname, String city, String state, String address, long zipCode, long phoneNumber, String email){
			this.firstname = firstname;
			this.lastname = lastname;
			this.city = city;
			this.state = state;
			this.address = address;
			this.zipCode = zipCode;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}

		public void setFirstName(String firstname){
			this.firstname = firstname;
		}
		public void setLastName(String lastname){
			this.lastname = lastname;
		}
		public void setCity(String city){
			this.city = city;
		}
		public void setState(String state){
			this.state = state;
		}
		public void setAddress(String address){
			this.address = address;
		}
		public void setZipCode(long zipCode){
			this.zipCode = zipCode;
		}
		public void setPhoneNumber(long phoneNumber){
			this.phoneNumber = phoneNumber;
		}
		public void setEmailid(String email) {
			this.email = email;
		}

		// Methods for displaying class-variables
		public String getFirstName(){
			return this.firstname;
		}
		public String getLastName(){
			return this.lastname;
		}
		public String getCity(){
			return this.city;
		}
		public String getState(){
			return this.state;
		}
		public String getAddress(){
			return this.address;
		}
		public Long getZipCode(){
			return this.zipCode;
		}
		public long getPhoneNumber(){
			return this.phoneNumber;
		}
		public String getEmailid() {
			return this.email;
		}

		public void showPersonsDetails(){

			System.out.println("-----------------------------------------------------------------");
			System.out.format("| %20s: %30s |\n","Name", this.getFirstName());
			System.out.format("| %20s: %30s |\n","Name", this.getLastName());
			System.out.format("| %20s: %30s |\n","Phone Number", this.getPhoneNumber());
			System.out.format("| %20s: %30s |\n","City", this.getCity());
			System.out.format("| %20s: %30s |\n","State", this.getState());
			System.out.format("| %20s: %30s |\n","Address", this.getAddress());
			System.out.format("| %20s: %30s |\n","Zip Code", this.getZipCode());
			System.out.format("| %20s: %30s |\n","Zip Code", this.getEmailid());
			System.out.println("-----------------------------------------------------------------");
		}
}
