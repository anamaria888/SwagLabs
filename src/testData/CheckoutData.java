package testData;

import core.utility.Reader;

public class CheckoutData {
	
	private String firstName;
    private String lastName;
    private String postalCode;
    
    public CheckoutData(String fileData) {
    	this.firstName = Reader.json(fileData).get("firstName").toString();
		this.lastName = Reader.json(fileData).get("lastName").toString();
		this.postalCode = Reader.json(fileData).get("postalCode").toString();
    }
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPostalCode() {
		return this.postalCode;
	}

}
