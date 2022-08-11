package addressBookSystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");

        AddressBook contact = new AddressBook();
        System.out.println("Enter Following Contact Details.");
        InputScanner is = new InputScanner();

        System.out.print("Enter First Name : ");
        String contactFirstName = is.inputString();
        contact.setFirstName(contactFirstName);

        System.out.print("Enter Last Name : ");
        String contactLastName = is.inputString();
        contact.setLastName(contactLastName);

        System.out.print("Enter Address : ");
        String contactAddress = is.inputString();
        contact.setAddress(contactAddress);

        System.out.print("Enter City : ");
        String contactCity = is.inputString();
        contact.setCity(contactCity);

        System.out.print("Enter State : ");
        String contactState = is.inputString();
        contact.setState(contactState);

        System.out.print("Enter Zip : ");
        String contactZip = is.inputString();
        contact.setZip(contactZip);

        System.out.print("Enter Phone Number : ");
        String contactPhoneNumber = is.inputString();
        contact.setPhoneNumber(contactPhoneNumber);

        System.out.print("Enter Email : ");
        String contactEmail = is.inputString();
        contact.setEmail(contactEmail);

        is.scannerClose();

        System.out.println("First Name: " + contact.firstName);
        System.out.println("Last Name: " + contact.lastName);
        System.out.println("Address: " + contact.address);
        System.out.println("City: " + contact.city);
        System.out.println("State: " + contact.state);
        System.out.println("Zip: " + contact.zip);
        System.out.println("Phone Number: " + contact.phoneNumber);
        System.out.println("Email: " + contact.email);

    }
}
