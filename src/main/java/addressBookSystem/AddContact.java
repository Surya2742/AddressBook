package addressBookSystem;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddContact {
    InputScanner inputScanner = new InputScanner();
    ArrayList<PersonDetails> list;
    Map<String, ArrayList<PersonDetails>> map = new HashMap<>();
    String listNames;


    public void contactOperation() throws IOException, ClassNotFoundException {
        boolean condition = true;
        boolean condition2 = true;
        while (condition2) {
            System.out.println("New/Select AddressBook");
            System.out.print("Enter Integer Input for AddressBookName : ");
            int i = inputScanner.inputInteger();
            listNames = "AddressBook" + (i);
            if (map.containsKey(listNames)) {
                System.out.println("The selected addressBook already exists. Continue to make changes or exit with 0");
                list = map.get(listNames);
            } else {
                System.out.println("New addressBook is created.");
                list = new ArrayList<>();
            }
            while (condition) {
                System.out.println("Current Book : " + listNames + "\nInput :\n01. Add Details, 02. Edit details, 03. Delete details, 04. View currentBook," +
                        "\n05. Edit from Hashmap, 06. Search Person, 07.View all Book, 08.Grouping by," +
                        "\n09.Count by City/State, 10.Sort, 11.Read/Write with File, 12.Read/Write with CSV, 13. Read/Write with JSON, 0.Save and Exit.\nEnter any Number to Ignore");
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
                    case 10:
                        sortContactList();
                        break;
                    case 11:
                        fileCreate();
                        break;
                    case 12:
                        csvFileReadWrite();
                        break;
                    case 13:
                        jsonReadWriteFile();
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

    public void addContact(String listNames) {
        PersonDetails addContact = new PersonDetails();
        System.out.println("enter the First Name");
        String firstName = inputScanner.inputString();
        addContact.setFirstName(firstName);
        if (!checkPersonExist(firstName)) {
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
            list.forEach(System.out::print);
            map.put(listNames, list);
        } else {
            System.out.println("Contact Already Exists in AddressBook");
        }
    }

    public boolean checkPersonExist(String name) {
        if (list == null)
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
        for (int i = 0; i < list.size(); i++) {
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
                    v.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).sorted().forEachOrdered(System.out::print);
                });
            }
            case 2 -> {
                System.out.print("Enter State Name to begin Search : ");
                String stateName = inputScanner.inputString();
                map.forEach((k, v) -> {
                    v.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).sorted().forEachOrdered(System.out::print);
                });
            }
        }
    }

    public void groupingBy() {
        ArrayList<PersonDetails> listOne = listOne();
        Map<String, List<PersonDetails>> collect =
                listOne.stream().
                        collect(Collectors.groupingBy(us -> us.getCity().toUpperCase()));
        collect.forEach((k, v) -> {
            System.out.print(k + " : " + v);
        });
    }

    public ArrayList<PersonDetails> listOne() {
        ArrayList<PersonDetails> listOne = new ArrayList<>();
        map.forEach((k, v) -> {
            listOne.addAll(v);
        });
        return listOne;
    }

    public void countByCityOrState() {
        System.out.print("1.Count by City\t2.Count by State\nEnter the Choice : ");
        int choiceOfSearch = inputScanner.inputInteger();
        ArrayList<PersonDetails> listOne = listOne();
        switch (choiceOfSearch) {
            case 1 -> {
                System.out.print("Enter City Name to begin Count : ");
                String cityName = inputScanner.inputString();
                long b = listOne.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
                System.out.println("Only " + b + " Contact found.");
            }
            case 2 -> {
                System.out.print("Enter State Name to begin Count : ");
                String stateName = inputScanner.inputString();
                long a = listOne.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).count();
                System.out.println("Only " + a + " Contact found.");
            }
        }
    }

    public void sortContactList() {
        System.out.print("1.ContactList by Name\t2.All AddressBook by Name\t3.ContactList by City\t4.ContactList by Zip\t5.ContactList by State\nEnter the Choice : ");
        int choiceOfSearch = inputScanner.inputInteger();
        switch (choiceOfSearch) {
            case 1 -> list.sort(Comparator.comparing(PersonDetails::getFirstName).thenComparing(PersonDetails::getLastName));
            case 2 -> map.forEach((k, v) -> {
                v.sort(Comparator.comparing(PersonDetails::getFirstName).thenComparing(PersonDetails::getLastName));
            });
            case 3 -> list.sort(Comparator.comparing(PersonDetails::getCity));
            case 4 -> list.sort(Comparator.comparing(PersonDetails::getZip));
            case 5 -> list.sort(Comparator.comparing(PersonDetails::getState));
            default -> System.out.println("Invalid Choice.");
        }
    }

    public void fileCreate() throws IOException, ClassNotFoundException {
        System.out.print("1.Write to File\t2.Read from File\nEnter the Choice : ");
        int choice = inputScanner.inputInteger();
        if (choice == 1) {
            FileOutputStream fos = new FileOutputStream("G:\\JAVA\\Intellij\\AddressBookSystem\\textFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.flush();
            oos.close();
        } else if (choice == 2) {
            FileInputStream fis = new FileInputStream("G:\\JAVA\\Intellij\\AddressBookSystem\\textFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, ArrayList<PersonDetails>> mapInFile = (Map<String, ArrayList<PersonDetails>>) ois.readObject();
            ois.close();
            mapInFile.forEach((k, v) -> {
                System.out.print(k + " : " + v);
            });
        } else
            System.out.println("Wrong choice.");
    }

    public void csvFileReadWrite() throws IOException {
        System.out.print("1.Write all contacts in CSV file, 2.Read contacts from CSV, 3. Read and Load contacts from CSV, 4. Write current list in CSV file.\nEnter The Choice : ");
        int choice = inputScanner.inputInteger();
        switch (choice) {
            case 1 -> writeAllContactsInCSVFile();
            case 2 -> showReadFileFromCSV();
            case 3 -> readAndLoadCSVToList();
            case 4 -> writeCurrentAddressBookInCSV();
            default -> System.out.println("Wrong Choice.");
        }
    }

    public void writeCurrentAddressBookInJSON(File file) throws IOException {
        file.createNewFile();
        try (Writer writer = new FileWriter("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBookJsonFile(LIST).json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(list, writer);
        }
    }

    public void writeMapInJSON(File file) throws IOException {
        file.createNewFile();
        try (Writer writer = new FileWriter("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBookJsonFile(MAP).json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(map, writer);
        }
    }

    public void loadListFromJSONToCurrentBook() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<PersonDetails> temp = mapper.readValue(new FileReader("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBookJsonFile(LIST).json"), new TypeReference<ArrayList<PersonDetails>>() {
        });
        list = (ArrayList<PersonDetails>) Stream.concat(list.stream(), temp.stream()).collect(Collectors.toList());
        System.out.println("Size of List : " + list.size());
        map.put(listNames, list);
    }

    public void loadMapFromJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        map.putAll(mapper.readValue(new FileReader("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBookJsonFile(MAP).json"), new TypeReference<Map<String, ArrayList<PersonDetails>>>() {
        }));
        System.out.println("size of Map : " + map.size());
        list = map.get(listNames);
    }


    public void jsonReadWriteFile() throws IOException {
        System.out.print("1.Write current AddressBook in JSON file, 2.Read and load List in current AddressBook, 3. Write map in JSON file, 4. Read and load Map.\nEnter The Choice : ");
        int choice = inputScanner.inputInteger();
        File file = new File("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBookJsonFile.json");
        switch (choice) {
            case 1 -> writeCurrentAddressBookInJSON(file);
            case 2 -> loadListFromJSONToCurrentBook();
            case 3 -> writeMapInJSON(file);
            case 4 -> loadMapFromJSON();
            default -> System.out.println("Wrong Input");
        }
    }

    public void viewList() {
        list.forEach(System.out::print);
    }

    public void viewMap() {
        map.forEach((k,v) -> {
            System.out.print(k + " : " + v);
        });
    }

    public void writeAllContactsInCSVFile() throws IOException {
        ArrayList<PersonDetails> listOne = listOne();
        File csvOutputFile = new File("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBook.csv");
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("firstName").addColumn("lastName").addColumn("address")
                .addColumn("city").addColumn("state").addColumn("zip")
                .addColumn("phoneNumber").addColumn("email")
                .build();
        ObjectWriter writer = mapper.writerFor(PersonDetails.class).with(schema);
        writer.writeValues(csvOutputFile).writeAll(listOne);
    }

    public void writeCurrentAddressBookInCSV() throws IOException {
        File csvOutputFile = new File("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBook.csv");
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("firstName").addColumn("lastName").addColumn("address")
                .addColumn("city").addColumn("state").addColumn("zip")
                .addColumn("phoneNumber").addColumn("email")
                .build();
        ObjectWriter writer = mapper.writerFor(PersonDetails.class).with(schema);
        writer.writeValues(csvOutputFile).writeAll(list);
    }

    public MappingIterator<PersonDetails> readContactsFromCSV() throws IOException {
        File csvFile = new File("G:\\JAVA\\Intellij\\AddressBookSystem\\addressBook.csv");
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true)
                .addColumn("firstName").addColumn("lastName").addColumn("address")
                .addColumn("city").addColumn("state").addColumn("zip")
                .addColumn("phoneNumber").addColumn("email")
                .build();
        MappingIterator<PersonDetails> usersIter = csvMapper
                .readerWithTypedSchemaFor(PersonDetails.class)
                .with(csvSchema)
                .readValues(csvFile);
        return usersIter;
    }

    public void showReadFileFromCSV() throws IOException {
        MappingIterator<PersonDetails> usersIter = readContactsFromCSV();
        List<PersonDetails> users = usersIter.readAll();
        users.forEach(System.out::print);
    }

    public void readAndLoadCSVToList() throws IOException {
        MappingIterator<PersonDetails> usersIter = readContactsFromCSV();
        System.out.print("Enter Integer Input for AddressBookName : ");
        int i = inputScanner.inputInteger();
        String temp = "AddressBook" + (i);
        if (map.containsKey(temp)) {
            System.out.println("The selected addressBook already exists.\n 1. To merge with list, 2. OverWrite list, 3. Ignore.");
            int a = inputScanner.inputInteger();
            switch (a) {
                case 1 -> {
                    listNames = temp;
                    list = map.get(listNames);
                    list = (ArrayList<PersonDetails>) Stream.concat(list.stream(), usersIter.readAll().stream()).distinct().collect(Collectors.toList());
                    map.put(listNames, list);
                }
                case 2 -> {
                    listNames = temp;
                    list = map.get(listNames);
                    list = (ArrayList<PersonDetails>) usersIter.readAll();
                    map.put(listNames, list);
                }
                case 3 -> System.out.println("Ignored.");
            }
        }
        else {
            System.out.println("New addressBook is created.");
            list = (ArrayList<PersonDetails>) usersIter.readAll();
            map.put(listNames, list);
        }
    }
}
