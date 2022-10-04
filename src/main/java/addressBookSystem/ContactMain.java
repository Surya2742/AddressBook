package addressBookSystem;

import java.io.IOException;
import java.sql.SQLException;

public class ContactMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        AddContact ac = new AddContact();
        ac.contactOperation();
    }
}
