package addressBookSystem;

public class AddContact extends PersonDetails{

    InputScanner inputScanner = new InputScanner();
    public void setContactDetails()  {
        System.out.println("enter the First Name");
        setFirstName(inputScanner.inputString() );
        System.out.println("enter the Last Name");
        setLastName(inputScanner.inputString());
        System.out.println("enter the Address Name");
        setAddress(inputScanner.inputString());
        System.out.println("enter the City Name");
        setCity(inputScanner.inputString());
        System.out.println("enter the State Name");
        setState(inputScanner.inputString());
        System.out.println("enter the Zip/postal Code");
        setZip(inputScanner.inputString());
        System.out.println("enter the Phone Number");
        setPhoneNumber(inputScanner.inputString());
        System.out.println("enter the Email");
        setEmail(inputScanner.inputString());
    }
}
