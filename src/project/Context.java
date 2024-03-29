package project;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import project.domain.enums.AccountType;
import project.domain.entity.*;

public class Context {

    private static final Context instance = new Context();
    private static AccountType accountType;// never change after logged in

    private List<Manager> managers;
    private List<Trainer> trainers;
    private List<Customer> customers;
    private List<Person> people;
    private static Person currentPerson;
    private static String currentUserId;

    private Context() {

    }

    // -----------------------------------------------------------------

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        Context.currentUserId = currentUserId;
    }

    public static Context getInstance() {
        return instance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    // Used only when login or logout
    public void setAccountType(AccountType accountType) {
        Context.accountType = accountType;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void initPeople() {
        this.people = Stream.of(managers, trainers, customers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
