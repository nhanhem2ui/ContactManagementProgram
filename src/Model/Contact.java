package Model;

public class Contact {

    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;
    private String lastName;
    private String firstName;

 
    public Contact(int id, String fullName, String group, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;

        // Extract first name and last name from full name
        String[] names = fullName.split(" ");
        if (names.length >= 2) {
            this.firstName = names[0];
            this.lastName = names[names.length - 1];
        } else {
            this.firstName = fullName;
            this.lastName = "";
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
