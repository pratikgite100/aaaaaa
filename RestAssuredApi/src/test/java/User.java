import java.util.ArrayList;

public class User {
	
	private String email;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> mobile;
	private Address address;
	
	public User(String email, String firstName, String lastName, String flatNo, String city, String state, String country) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address=new Address(flatNo,city,state,country);
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String email, String firstName, String lastName, ArrayList<Integer> mobile) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		
	}
	
	
	
	public ArrayList<Integer> getMobile() {
		return mobile;
	}
	public void setMobile(ArrayList<Integer> mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public void setMobileNumbers (int... mobileNumbers) {
		
		for(int i=0;i<mobileNumbers.length;i++) {
			
			this.mobile.add(mobileNumbers[i]);
		}
	}
	
	
	

}
