package addressBookSystem;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        InputScanner inputScanner = new InputScanner();
        Collection collection = new Collection();

        System.out.println("Welcome to Address Book System");

        System.out.println("\nEnter Following Contact Details for Person 1.");
        PersonDetails personContactOne = new PersonDetails();
        addressBook.addContact(personContactOne);
        collection.add(personContactOne);

        System.out.println("\nEnter Following Contact Details for Person 2.");
        PersonDetails personContactTwo = new PersonDetails();
        addressBook.addContact(personContactTwo);
        collection.add(personContactTwo);

        System.out.println("\nEnter Following Contact Details for Person 3.");
        PersonDetails personContactThree = new PersonDetails();
        addressBook.addContact(personContactThree);
        collection.add(personContactThree);

        addressBook.print(collection.getContactList());

        int choice;
        System.out.println("\nEnter choice: \n\t1.Add new Contact.\n\t2.Edit existing Contact.\n\t3.Remove existing Contact.");
        choice = inputScanner.inputInteger();
        PersonDetails contact = new PersonDetails();
        switch (choice) {
            case 1:
                System.out.println("Enter the contact Details of Persons you want to add");
                System.out.println("Enter the no. of Contacts to add");
                int noOfContacts = inputScanner.inputInteger();
                for (int i = 0; i < noOfContacts; i++) {
                    addressBook.addContact(contact);
                    collection.add(contact);
                    System.out.println("\nContact List after add :");
                    addressBook.print(collection.getContactList());
                }
                break;
            case 2:
                System.out.print("Enter name of contact : ");
                String name = inputScanner.inputString();
                if (personContactOne.getFirstName().equalsIgnoreCase(name)) {
                    addressBook.edit(personContactOne);
                    System.out.println("\nContact List after edit :");
                }
                else if (personContactTwo.getFirstName().equalsIgnoreCase(name)) {
                    addressBook.edit(personContactTwo);
                    System.out.println("\nContact List after edit :");
                }
                else if (personContactThree.getFirstName().equalsIgnoreCase(name)) {
                    addressBook.edit(personContactThree);
                    System.out.println("\nContact List after edit :");
                }
                else {
                    System.out.println("Name didn't matched with existing Contact");
                    System.out.println("\nAll Contact List Present :");
                }
                addressBook.print(collection.getContactList());
                break;
            case 3:
                System.out.print("Enter name of contact : ");
                String personFirstName = inputScanner.inputString();
                if (personContactOne.getFirstName().equalsIgnoreCase(personFirstName)) {
                    collection.remove(personContactOne);
                    System.out.println("\nContact List after deletion :");
                }
                else if (personContactTwo.getFirstName().equalsIgnoreCase(personFirstName)) {
                    collection.remove(personContactTwo);
                    System.out.println("\nContact List after deletion :");
                }
                else if (personContactThree.getFirstName().equalsIgnoreCase(personFirstName)) {
                    collection.remove(personContactThree);
                    System.out.println("\nContact List after deletion :");
                }
                else {
                    System.out.println("Name didn't matched with existing Contact");
                System.out.println("\nAll Contact List Present :");
                }
                addressBook.print(collection.getContactList());
                break;
        }
    }
}
