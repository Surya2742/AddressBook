package addressBookSystem;

import java.util.HashMap;

public class ContactMain {
    static InputScanner inputScanner = new InputScanner();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        HashMap<String, PersonDetails> ContactHashMap = new HashMap<>();
        boolean decision = true;
        while (decision) {
            AddContact PersonDetails = new AddContact();
            System.out.println("Input :\n01. Add Details, 02. Edit details, 03. Delete details, 04. View details, 09. To Exit.\nEnter any Number to Ignore");
            int options = inputScanner.inputInteger();
            switch (options) {
                case 01:
                    PersonDetails.setContactDetails();
                    ContactHashMap.put(PersonDetails.getFirstName(), PersonDetails);
                    break;
                case 02:
                    System.out.print("Enter the name to edit : ");
                    String editName = inputScanner.inputString();
                    if( ContactHashMap.containsKey(editName)) {
                        PersonDetails.setContactDetails();
                        ContactHashMap.put(editName,PersonDetails);
                    } else
                        System.out.println("Name didn't matched with any contact.");
                    break;
                case 03:
                    System.out.print("Enter the Name to delete contact: ");
                    String deleteName = inputScanner.inputString();
                    ContactHashMap.remove(deleteName);
                    break;
                case 04:
                    System.out.println(ContactHashMap.toString());
                    break;
                case 9:
                    decision = false;
                    break;
                default:
                    System.out.println("Enter the proper option");
                    break;
            }
        }
    }
}
