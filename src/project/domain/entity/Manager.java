package project.domain.entity;

import project.domain.enums.AccountType;
import java.util.*;

public class Manager extends Person {

    public Manager() {

    }

    public Manager(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role) {
        super(id, username, password, fullName, gender, phoneNumber, email, role);
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Manager(String[] line) {
        this.id = line[0];
        this.username = line[1];
        this.password = line[2];
        this.fullName = line[3];
        this.gender = line[4];
        this.phoneNumber = line[5];
        this.email = line[6];
        this.role = line[7];
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Manager(List<String> inputs) {
        this.id = UUID.randomUUID().toString();
        this.username = inputs.get(0);
        this.password = inputs.get(1);
        this.fullName = inputs.get(2);
        this.gender = inputs.get(3);
        this.phoneNumber = inputs.get(4);
        this.email = inputs.get(5);
        this.role = AccountType.MANAGER.getRole();
    }

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(id, username, password, fullName, gender, phoneNumber, email, role)));
        return data;
    }

}
