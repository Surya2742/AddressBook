package addressBookSystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        AddressBookInterface abi = new AddressBookInterface();

        AddressBook personContactOne = new AddressBook();
        System.out.println("Enter Following Contact Details for Person 1.");
        InputScanner isOne = new InputScanner();

        System.out.print("Enter First Name : ");
        String contactFirstName = isOne.inputString();
        personContactOne.setFirstName(contactFirstName);

        System.out.print("Enter Last Name : ");
        String contactLastName = isOne.inputString();
        personContactOne.setLastName(contactLastName);

        System.out.print("Enter Address : ");
        String contactAddress = isOne.inputString();
        personContactOne.setAddress(contactAddress);

        System.out.print("Enter City : ");
        String contactCity = isOne.inputString();
        personContactOne.setCity(contactCity);

        System.out.print("Enter State : ");
        String contactState = isOne.inputString();
        personContactOne.setState(contactState);

        System.out.print("Enter Zip : ");
        String contactZip = isOne.inputString();
        personContactOne.setZip(contactZip);

        System.out.print("Enter Phone Number : ");
        String contactPhoneNumber = isOne.inputString();
        personContactOne.setPhoneNumber(contactPhoneNumber);

        System.out.print("Enter Email : ");
        String contactEmail = isOne.inputString();
        personContactOne.setEmail(contactEmail);
//-----------------------------------------------------------------------------------------------
        AddressBook personContactTwo = new AddressBook();
        System.out.println("Enter Following Contact Details for Person 2.");
        InputScanner isTwo = new InputScanner();

        System.out.print("Enter First Name : ");
        personContactTwo.setFirstName(isTwo.inputString());

        System.out.print("Enter Last Name : ");
        personContactTwo.setLastName(isTwo.inputString());

        System.out.print("Enter Address : ");
        personContactTwo.setAddress(isTwo.inputString());

        System.out.print("Enter City : ");
        personContactTwo.setCity(isTwo.inputString());

        System.out.print("Enter State : ");
        personContactTwo.setState(isTwo.inputString());

        System.out.print("Enter Zip : ");
        personContactTwo.setZip(isTwo.inputString());

        System.out.print("Enter Phone Number : ");
        personContactTwo.setPhoneNumber(isTwo.inputString());

        System.out.print("Enter Email : ");
        personContactTwo.setEmail(isTwo.inputString());
//-----------------------------------------------------------------------------------------------
        AddressBook personContactThree = new AddressBook();
        System.out.println("Enter Following Contact Details for Person 3.");
        InputScanner isThree = new InputScanner();

        System.out.print("Enter First Name : ");
        personContactThree.setFirstName(isThree.inputString());

        System.out.print("Enter Last Name : ");
        personContactThree.setLastName(isThree.inputString());

        System.out.print("Enter Address : ");
        personContactThree.setAddress(isThree.inputString());

        System.out.print("Enter City : ");
        personContactThree.setCity(isThree.inputString());

        System.out.print("Enter State : ");
        personContactThree.setState(isThree.inputString());

        System.out.print("Enter Zip : ");
        personContactThree.setZip(isThree.inputString());

        System.out.print("Enter Phone Number : ");
        personContactThree.setPhoneNumber(isThree.inputString());

        System.out.print("Enter Email : ");
        personContactThree.setEmail(isThree.inputString());
        System.out.println("\nContact Number 1.");
        abi.view(personContactOne);
        System.out.println("\nContact Number 2.");
        abi.view(personContactTwo);
        System.out.println("\nContact Number 3.");
        abi.view(personContactThree);

        InputScanner is3 = new InputScanner();
        System.out.println("Enter name of contact you want to edit");
        String name = is3.inputString();
        if(personContactOne.firstName.equalsIgnoreCase(name) == true)
            abi.edit(personContactOne);
        else if(personContactTwo.firstName.equalsIgnoreCase(name) == true)
            abi.edit(personContactTwo);
        else if(personContactThree.firstName.equalsIgnoreCase(name) == true)
            abi.edit(personContactThree);
        System.out.println("Contact List after editing AddressBook.");
        System.out.println("\nContact Number 1.");
        abi.view(personContactOne);
        System.out.println("\nContact Number 2.");
        abi.view(personContactTwo);
        System.out.println("\nContact Number 3.");
        abi.view(personContactThree);
    }
}
