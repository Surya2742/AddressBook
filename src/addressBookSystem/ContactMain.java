package addressBookSystem;

import java.util.ArrayList;

public class ContactMain {
    static InputScanner inputScanner = new InputScanner();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        ArrayList<AddContact> ContactDetails = new ArrayList<>();
        while (true) {
            AddContact PersonDetails = new AddContact();
            System.out.println("Input :\n01. Add Details, 02. Edit details, 03. Delete details, 04. View details.\nEnter any Number to Ignore");
            int options = inputScanner.inputInteger();
            switch (options) {
                case 01:
                    PersonDetails.setContactDetails();
                    ContactDetails.add(PersonDetails);
                    break;
                case 02:
                    System.out.print("Enter the name to edit : ");
                    PersonDetails.editDetails(ContactDetails);
                    break;
                case 03:
                    PersonDetails.deleteDetails(ContactDetails);
                    break;
                case 04:
                    PersonDetails.viewDetails(ContactDetails);
                    break;
                default:
                    System.out.println("you have not perform any operation");
                    break;
            }
        }
    }
}
