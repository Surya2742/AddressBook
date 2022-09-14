package addressBookSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddContact{
    InputScanner inputScanner = new InputScanner();
    ArrayList<PersonDetails> list;
    Map<String, ArrayList<PersonDetails>> map = new HashMap<>();


    public void contactOperation() {
        boolean condition = true;
        boolean condition2 = true;
        while (condition2) {
            System.out.println("New/Select AddressBook");
            System.out.print("Enter Integer Input for AddressBookName : ");
            int i = inputScanner.inputInteger();
            String listNames = "AddressBook" + (i);
            if (map.containsKey(listNames)) {
                System.out.println("The selected addressBook already exists. Continue to make changes or exit with 9");
                list = map.get(listNames);
            } else {
                System.out.println("New addressBook is created.");
                list = new ArrayList<>();
            }

            while (condition) {
                System.out.println("Input :\n01. Add Details, 02. Edit details, 03. Delete details, 04. View current Book,\n05. Edit from Hashmap, 06. Search Person, 07.View all Book, 08.Grouping by,\n09.Count by City/State, 0.Save and Exit.\nEnter any Number to Ignore");
                int options = inputScanner.inputInteger();
                switch (options) {
                    case 1:
                        addContact(listNames);
                        break;
                    case 2:
                        System.out.print("Enter name to Edit Contact : ");
                        String editName = inputScanner.inputString();
                        editDetails(list, editName);
                        break;
                    case 3:
                        deleteDetails(list);
                        break;
                    case 4:
                        viewList();
                        break;
                    case 5:
                        editFromListOfMap();
                        break;
                    case 6:
                        searchPerson();
                        break;
                    case 7:
                        viewMap();
                        break;
                    case 8:
                        groupingBy();
                        break;
                    case 9:
                        countByCityOrState();
                        break;
                    case 0:
                        condition = false;
                    default:
                        System.out.println("Exit from the " + listNames);
                        break;
                }
            }
            contactOperation();
        }
    }
    public void addContact (String listNames) {
        PersonDetails addContact = new PersonDetails();
        System.out.println("enter the First Name");
        String firstName = inputScanner.inputString();
        addContact.setFirstName(firstName);
        if (!checkPersonExist(firstName)){
            System.out.println("enter the Last Name");
            addContact.setLastName(inputScanner.inputString());
            System.out.println("enter the Address Name");
            addContact.setAddress(inputScanner.inputString());
            System.out.println("enter the City Name");
            addContact.setCity(inputScanner.inputString());
            System.out.println("enter the State Name");
            addContact.setState(inputScanner.inputString());
            System.out.println("enter the Zip/postal Code");
            addContact.setZip(inputScanner.inputString());
            System.out.println("enter the Phone Number");
            addContact.setPhoneNumber(inputScanner.inputString());
            System.out.println("enter the Email");
            addContact.setEmail(inputScanner.inputString());
            list.add(addContact);
            System.out.println(list);
            map.put(listNames, list);
        }
        else {
            System.out.println("Contact Already Exists in AddressBook");
        }
    }

    public boolean checkPersonExist(String name) {
        if(list == null)
            return false;
        else {
            PersonDetails search = list.stream().
                    filter(keyObj -> name.equalsIgnoreCase(keyObj.getFirstName())).
                    findFirst().orElse(null);
            return search != null;
        }
    }

    public void editDetails(ArrayList<PersonDetails> list, String editName) {
        for (PersonDetails personDetails : list) {
            if (personDetails.getFirstName().equalsIgnoreCase(editName)) {
                System.out.println("Name : " + personDetails.getFirstName() + " matches with one of the contact in AddressBook.");
                System.out.println(personDetails);
                System.out.println("Enter the number to update contact details. \n1. First Name 2. Last Name 3. Address 4. City 5. State 6. PinCode 7. Phone Number 8.Email");
                int updateChoice = inputScanner.inputInteger();

                switch (updateChoice) {
                    case 1 -> {
                        System.out.print("Enter the First name to update : ");
                        personDetails.setFirstName(inputScanner.inputString());
                        System.out.println("The First Name is Updated");
                    }
                    case 2 -> {
                        System.out.print("Enter the Last name to update : ");
                        personDetails.setLastName(inputScanner.inputString());
                        System.out.println("The Last Name is Updated");
                    }
                    case 3 -> {
                        System.out.print("Enter the Address to Update : ");
                        personDetails.setAddress(inputScanner.inputString());
                        System.out.println("The Address is Updated");
                    }
                    case 4 -> {
                        System.out.print("Enter the City to Update : ");
                        personDetails.setCity(inputScanner.inputString());
                        System.out.println("The State is Updated");
                    }
                    case 5 -> {
                        System.out.print("Enter the State to Update : ");
                        personDetails.setState(inputScanner.inputString());
                        System.out.println("The State is Updated");
                    }
                    case 6 -> {
                        System.out.print("Enter the PinCode to Update : ");
                        personDetails.setZip(inputScanner.inputString());
                        System.out.println("The Pincode/Postalcode is Updated");
                    }
                    case 7 -> {
                        System.out.print("Enter the Phone Number to Update : ");
                        personDetails.setPhoneNumber(inputScanner.inputString());
                        System.out.println("The Phone Number is Updated");
                    }
                    case 8 -> {
                        System.out.print("Enter the eMail to Update : ");
                        personDetails.setEmail(inputScanner.inputString());
                        System.out.println("The eMail is Updated");
                    }
                    default -> System.out.println("you have not updated any details");
                }

            } else
                System.out.println("Name didn't matched.");
        }
    }

    public void deleteDetails(ArrayList<PersonDetails> list) {
        System.out.print("Enter the name to delete Contact : ");
        String deleteName = inputScanner.inputString();
        for(int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getFirstName().equalsIgnoreCase(deleteName)) {
                list.remove(i);
                System.out.println("The contact Details for " + deleteName + " is deleted.");
            } else
                System.out.println("Name didn't matched with contact at position : " + i);
        }
    }

    public void editFromListOfMap() {
        list = new ArrayList<>();
        System.out.print("Enter name to Edit Contact searching all Book : ");
        String editNameFromBook = inputScanner.inputString();
        for (Map.Entry<String, ArrayList<PersonDetails>> entry : map.entrySet()) {
            list = entry.getValue();
            editDetails(list, editNameFromBook);
        }
    }

    public void searchPerson() {
        System.out.print("1.Search by City\t2.Search by State\nEnter the Choice : ");
        int choiceOfSearch = inputScanner.inputInteger();
        switch (choiceOfSearch) {
            case 1 -> {
                System.out.print("Enter City Name to begin Search : ");
                String cityName = inputScanner.inputString();
                map.forEach((k, v) -> {
                    v.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).sorted().forEachOrdered(System.out::println);
                });
            }
            case 2 -> {
                System.out.print("Enter State Name to begin Search : ");
                String stateName = inputScanner.inputString();
                map.forEach((k, v) -> {
                    v.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).sorted().forEachOrdered(System.out::println);
                });
            }
        }
    }

    public void groupingBy() {
        ArrayList<PersonDetails> listOne = new ArrayList<>();
        map.forEach((k, v) -> {
            listOne.addAll(v);
        } );
        Map<String, List<PersonDetails>> collect =
                listOne.stream().
                        collect(Collectors.groupingBy(us -> us.getCity().toUpperCase()));
        System.out.println(collect);
    }

    public void countByCityOrState() {
        System.out.print("1.Count by City\t2.Count by State\nEnter the Choice : ");
        int choiceOfSearch = inputScanner.inputInteger();
        ArrayList<PersonDetails> listOne = new ArrayList<>();
        map.forEach((k, v) -> {
            listOne.addAll(v);
        });
        switch (choiceOfSearch) {
            case 1 -> {
                System.out.print("Enter City Name to begin Count : ");
                String cityName = inputScanner.inputString();
                long b = listOne.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
                System.out.println(b);
            }
            case 2 -> {
                System.out.print("Enter State Name to begin Count : ");
                String stateName = inputScanner.inputString();
                long a = listOne.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).count();
                System.out.println(a);
            }
        }
    }

    public void viewList() {
        System.out.println(list);
    }

    public void viewMap() {
        System.out.println(map);
    }
}
