package project.domain.entity;

import project.domain.enums.AccountType;
import java.io.*;
import java.time.*;
import java.util.*;

public class Customer extends User {

    private String customer_date_joined;
    private double weight;
    private double height;
    private boolean isPaid;

    public Customer() {

    }

    public Customer(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role, String customer_date_joined, double height, double weight, boolean isPaid) {
        super(id, username, password, fullName, gender, phoneNumber, email, role);

        this.customer_date_joined = customer_date_joined;
        this.height = height;
        this.weight = weight;
        this.isPaid = isPaid;
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Customer(String[] line) {
        this.id = line[0];
        this.username = line[1];
        this.password = line[2];
        this.fullName = line[3];
        this.gender = line[4];
        this.phoneNumber = line[5];
        this.email = line[6];
        this.role = line[7];
        this.customer_date_joined = LocalDate.parse(line[8]).toString();
        this.height = Double.parseDouble(line[9]);
        this.weight = Double.parseDouble(line[10]);
        this.isPaid = Boolean.parseBoolean(line[11]);
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Customer(List<String> inputs) {
        this.id = UUID.randomUUID().toString();
        this.username = inputs.get(0);
        this.password = inputs.get(1);
        this.fullName = inputs.get(2);
        this.gender = inputs.get(3);
        this.phoneNumber = inputs.get(4);
        this.email = inputs.get(5);
        this.role = AccountType.CUSTOMER.getRole();
        this.customer_date_joined = LocalDate.now().toString();
        this.height = Double.parseDouble(inputs.get(6));
        this.weight = Double.parseDouble(inputs.get(7));
        this.isPaid = Boolean.parseBoolean(inputs.get(8));
    }

    // getters & setters
    // -------------------------------------------------------------
    public String getCustomer_date_joined() {
        return customer_date_joined;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(id, username, password, fullName, gender, phoneNumber, email, role, customer_date_joined,
                        String.valueOf(height), String.valueOf(weight), String.valueOf(isPaid))));
        return data;
    }

}