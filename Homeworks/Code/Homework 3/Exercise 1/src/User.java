// Datei: User.java
public class User {
    private String id;
    private String firstName;
    private String lastName;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void login() {
        System.out.println("User logged in: " + id);
    }
}
