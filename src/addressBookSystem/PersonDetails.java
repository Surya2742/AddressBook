package addressBookSystem;

import java.io.Serializable;

public class PersonDetails implements Serializable {
    public String firstName, lastName, address, city, state, zip, phoneNumber, email;


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String contactFirstName) {
        this.firstName = contactFirstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String contactLastName) {
        this.lastName = contactLastName;
    }

    public void setAddress(String contactAddress) {
        this.address = contactAddress;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String contactCity) {
        this.city = contactCity;
    }

    public String getState() {
        return state;
    }
    public void setState(String contactState) {
        this.state = contactState;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String contactZip) {
        this.zip = contactZip;
    }

    public void setPhoneNumber(String contactPhoneNumber) {
        this.phoneNumber = contactPhoneNumber;
    }

    public void setEmail(String contactEmail) {
        this.email = contactEmail;
    }

    @Override
    public String toString() {
        return "[FirstName = " + firstName + ", LastName = " + lastName + ", Address = " + address + ", City = "
                + city + ", State = " + state + ", PinCode = " + zip + ", PhoneNumber = " + phoneNumber + ", eMail = " + email + "]\n";
    }
}
