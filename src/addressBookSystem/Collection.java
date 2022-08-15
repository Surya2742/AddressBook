package addressBookSystem;

import java.util.HashSet;
import java.util.Set;

public class Collection {
    public Set<PersonDetails> contactList = new HashSet<>();

    public Set<PersonDetails> getContactList() {
        return contactList;
    }

    void add(PersonDetails contact) {
        contactList.add(contact);
    }

    public void remove(PersonDetails contact) {
        contactList.remove(contact);
    }

}
