package Model;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<Contact> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }
    public void addContact(int id, String fullName, String group, String address, String phone){
        Contact contact = new Contact(id, fullName, group, address, phone);
        contacts.add(contact);
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}