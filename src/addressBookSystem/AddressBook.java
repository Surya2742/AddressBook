package addressBookSystem;

public class AddressBook {

    void view(PersonDetails contact) {
        System.out.println("\nFirst Name\t:\t" + contact.firstName);
        System.out.println("Last Name\t:\t" + contact.lastName);
        System.out.println("Address\t\t:\t" + contact.address);
        System.out.println("City\t\t:\t" + contact.city);
        System.out.println("State\t\t:\t" + contact.state);
        System.out.println("Zip\t\t\t:\t" + contact.zip);
        System.out.println("Phone Number:\t" + contact.phoneNumber);
        System.out.println("Email\t\t:\t" + contact.email);
    }

    void edit(PersonDetails contact) {
        InputScanner isFive = new InputScanner();
        System.out.println("Edit the details First Name, Last Name, Address, City, State, Zip, Phone Number, Email respectively");
        System.out.print("Re-Correct First Name : ");
        contact.setFirstName(isFive.inputString());
        System.out.print("Re-Correct Last Name : ");
        contact.setLastName(isFive.inputString());
        System.out.print("Re-Correct Address : ");
        contact.setAddress(isFive.inputString());
        System.out.print("Re-Correct City : ");
        contact.setCity(isFive.inputString());
        System.out.print("Re-Correct State : ");
        contact.setState(isFive.inputString());
        System.out.print("Re-Correct Zip Code : ");
        contact.setZip(isFive.inputString());
        System.out.print("Re-Correct Phone Number : ");
        contact.setPhoneNumber(isFive.inputString());
        System.out.print("Re-Correct Email : ");
        contact.setEmail(isFive.inputString());
    }
}
