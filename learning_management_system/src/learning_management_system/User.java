package learning_management_system;

public abstract class User {
	
	// the reason to create it abstracted is that we want only roles of user to be instantiated

    // Common attributes for all users 
	
    protected String id;
    protected String name;
    protected String role;

    // Constructor
    public User(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    // Abstract method - each role will implement its own menu
    public abstract void menu();
    /* as you know that all the abstract methods have no definition they are defined only in the inherited classes.
     the menu() method provides the users the set of activities they can perform for example for the admin role
    it should be like the searching of the user in the data files and for students it has the activities like courses grades, results*/
}
