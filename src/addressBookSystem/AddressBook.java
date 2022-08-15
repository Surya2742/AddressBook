package addressBookSystem;

import java.util.Set;

public class AddressBook {

    void print(Set<PersonDetails> contactList) {
        for (PersonDetails s : contactList) {
            System.out.println(s);
        }
    }

    static void edit(PersonDetails contact) {
        InputScanner inputScannerOne = new InputScanner();
        System.out.println("Edit the details First Name, Last Name, Address, City, State, Zip, Phone Number, Email respectively");
        System.out.print("Re-Correct First Name : ");
        contact.setFirstName(inputScannerOne.inputString());
        System.out.print("Re-Correct Last Name : ");
        contact.setLastName(inputScannerOne.inputString());
        System.out.print("Re-Correct Address : ");
        contact.setAddress(inputScannerOne.inputString());
        System.out.print("Re-Correct City : ");
        contact.setCity(inputScannerOne.inputString());
        System.out.print("Re-Correct State : ");
        contact.setState(inputScannerOne.inputString());
        System.out.print("Re-Correct Zip Code : ");
        contact.setZip(inputScannerOne.inputString());
        System.out.print("Re-Correct Phone Number : ");
        contact.setPhoneNumber(inputScannerOne.inputString());
        System.out.print("Re-Correct Email : ");
        contact.setEmail(inputScannerOne.inputString());
    }

    void addContact(PersonDetails contact) {

        InputScanner inputScannerTwo = new InputScanner();
        Instruction instruction = new Instruction();
        System.out.println("Enter Person contact details");
        instruction.EnterFirstName();
        contact.setFirstName(inputScannerTwo.inputString());
        instruction.EnterLastName();
        contact.setLastName(inputScannerTwo.inputString());
        instruction.EnterAddress();
        contact.setAddress(inputScannerTwo.inputString());
        instruction.EnterCity();
        contact.setCity(inputScannerTwo.inputString());
        instruction.EnterState();
        contact.setState(inputScannerTwo.inputString());
        instruction.EnterZip();
        contact.setZip(inputScannerTwo.inputString());
        instruction.EnterPhoneNumber();
        contact.setPhoneNumber(inputScannerTwo.inputString());
        instruction.EnterEmail();
        contact.setEmail(inputScannerTwo.inputString());
    }
}
