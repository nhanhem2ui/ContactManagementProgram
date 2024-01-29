package Controller;

import Model.ContactList;
import View.Menu;

public class ContactManagementProgram {

    protected ContactList contactList = new ContactList();
    private InputOutputHandler handler = new InputOutputHandler();

    public void displayMainMenu() {
        Menu<String> mainMenu = new Menu<>("Contact Manager Program", new String[]{
            "Add a contact",
            "Display all contacts",
            "Delete a contact",
            "Exit"
        }) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 ->
                        handler.addContact(contactList);
                    case 2 ->
                        handler.displayAllContacts(contactList);
                    case 3 ->
                        handler.deleteContact(contactList);
                    case 4 ->
                        System.exit(0);
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        contactList.addContact(1, "Nguyen Van Bao", "Dev", "Nexus", "0329593991");
        contactList.addContact(2, "Chuc Zy", "Dev", "Sumeru", "0329593931");
        mainMenu.run();
    }

    public static void main(String[] args) {
        ContactManagementProgram main = new ContactManagementProgram();
        main.displayMainMenu();
    }
}
