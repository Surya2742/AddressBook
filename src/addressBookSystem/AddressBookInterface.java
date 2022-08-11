package addressBookSystem;

public class AddressBookInterface {

    void view(AddressBook contact) {
        System.out.println("\nFirst Name: " + contact.firstName);
        System.out.println("Last Name: " + contact.lastName);
        System.out.println("Address: " + contact.address);
        System.out.println("City: " + contact.city);
        System.out.println("State: " + contact.state);
        System.out.println("Zip: " + contact.zip);
        System.out.println("Phone Number: " + contact.phoneNumber);
        System.out.println("Email: " + contact.email);
    }

    void edit(AddressBook contact) {
        InputScanner is4 = new InputScanner();
        System.out.println("Edit the details First Name, Last Name, Address, City, State, Zip, Phone Number, Email respectively");
        System.out.println("Re-Correct First Name");
        contact.setFirstName(is4.inputString());
        System.out.println("Re-Correct Last Name");
        contact.setLastName(is4.inputString());
        System.out.println("Re-Correct Address");
        contact.setAddress(is4.inputString());
        System.out.println("Re-Correct City");
        contact.setCity(is4.inputString());
        System.out.println("Re-Correct State");
        contact.setState(is4.inputString());
        System.out.println("Re-Correct Email");
        contact.setEmail(is4.inputString());
        System.out.println("Re-Correct Zip Code");
        contact.setZip(is4.inputString());
        System.out.println("Re-Correct Phone Number");
        contact.setPhoneNumber(is4.inputString());
    }
}
