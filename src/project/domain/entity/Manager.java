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
     * Constructor for reading in
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
     * generateManager for new customer account
     * 
     * @param inputs
     * @return
     */
    public Manager generateManager(List<String> inputs) {
        Manager manager = new Manager();

        manager.id = UUID.randomUUID().toString();
        manager.username = inputs.get(0);
        manager.password = inputs.get(1);
        manager.fullName = inputs.get(2);
        manager.gender = inputs.get(3);
        manager.phoneNumber = inputs.get(4);
        manager.email = inputs.get(5);
        manager.role = AccountType.MANAGER.getRole();

        return manager;
    }

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(id, username, password, fullName, gender, phoneNumber, email, role)));
        return data;
    }

}
