package Controller;

import Model.Contact;
import Model.ContactList;

import java.util.List;
import java.util.Scanner;

public class InputOutputHandler {

    private Scanner sc = new Scanner(System.in);

    public void addContact(ContactList contactList) {
        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter group: ");
        String group = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // Validate phone number format
        if (!isValidPhoneNumber(phone)) {
            System.out.println("Invalid phone number format. Please use a valid format.");
            return;
        }
        // Generate ID for the new contact
        int newId;
        if (contactList.getAllContacts().isEmpty()) {
            newId = 1;
        } else {
            newId = contactList.getAllContacts().get(contactList.getAllContacts().size() - 1).getId() + 1;
        }
        // Create and add the new contact to the list
        Contact newContact = new Contact(newId, fullName, group, address, phone);
        contactList.addContact(newContact);

        System.out.println("Contact added successfully!");
    }

    public void displayAllContacts(ContactList contactList) {
        System.out.println("ID\tName\t\tFirst Name\tLast Name\tGroup\t\tAddress\t\tPhone");
        List<Contact> contacts = contactList.getAllContacts();
        for (Contact contact : contacts) {
            System.out.printf("%-6d%-19s%-17s%-14s%-14s%-14s%-14s%n",
                    contact.getId(), contact.getFullName(), contact.getFirstName(),
                    contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public void deleteContact(ContactList contactList) {
        System.out.print("Enter the ID of the contact you want to delete: ");
        int deleteId = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        // Find the contact with the given ID
        Contact contactToDelete = null;
        List<Contact> contacts = contactList.getAllContacts();
        for (Contact contact : contacts) {
            if (contact.getId() == deleteId) {
                contactToDelete = contact;
                break;
            }
        }

        // If contact found, delete it; otherwise, display an error message
        if (contactToDelete != null) {
            contactList.removeContact(contactToDelete);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("No contact found with the given ID.");
        }
    }

    public boolean isValidPhoneNumber(String phone) {
        // Regular expression for a valid phone number
        String regex = "^(\\d{10}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\(\\d{3}\\)[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\d{3}[-\\.\\s]\\d{4})$";
        return phone.matches(regex);
    }
}
