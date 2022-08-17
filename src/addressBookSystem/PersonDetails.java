package addressBookSystem;

public class PersonDetails {
    public String firstName, lastName, address, city, state, zip, phoneNumber, email;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String contactFirstName) {
        this.firstName = contactFirstName;
    }

        public void setLastName(String contactLastName) {
        this.lastName = contactLastName;
    }

    public void setAddress(String contactAddress) {
        this.address = contactAddress;
    }

    public void setCity(String contactCity) {
        this.city = contactCity;
    }

    public void setState(String contactState) {
        this.state = contactState;
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
                + city + ", State = " + state + ", zip = " + zip + ", PhoneNumber = " + phoneNumber + ", eMail = " + email + "]\n";
    }

}
