package project.domain.entity;

public class User extends Person {

    public User() {

    }

    public User(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role) {
        super(id, username, password, fullName, gender, phoneNumber, email, role);
    }

}
