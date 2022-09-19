package addressBookSystem;

import java.io.IOException;

public class ContactMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AddContact ac = new AddContact();
        ac.contactOperation();
    }
}
