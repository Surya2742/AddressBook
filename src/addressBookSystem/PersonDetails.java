package addressBookSystem;

public class PersonDetails {
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

    public String getAddress() {
        return address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String contactPhoneNumber) {
        this.phoneNumber = contactPhoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String contactEmail) {
        this.email = contactEmail;
    }

    @Override
    public String toString() {
        return "\b\b[FirstName = " + firstName + ", LastName = " + lastName + ", Address = " + address + ", City = "
                + city + ", State = " + state + ", eMail = " + email + ", zip = " + zip + ", PhoneNumber = " + phoneNumber + "]\n";
    }

}
