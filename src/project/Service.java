package project;

import project.domain.entity.*;
import project.domain.enums.*;
import java.io.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Service {

    // application.properties
    public final static String MANAGER_FILE = "src/resources/manager.txt";
    public final static String TRAINER_FILE = "src/resources/trainer.txt";
    public final static String CUSTOMER_FILE = "src/resources/customer.txt";

    /**
     * login
     * 
     * @param username
     * @param password
     */
    public void login(String username, String password) {

        Context.getInstance().getPeople().stream()
                .filter(e -> username.equals(e.getUsername()) &&
                        password.equals(e.getPassword()))
                .findFirst()
                .ifPresent(person -> Context.getInstance().setAccountType(AccountType.fromRole(person.getRole())));

        // Context.getInstance().getPeople().forEach(e -> {
        // if (username.equals(e.getUsername()) && password.equals(e.getPassword())) {
        // Context.getInstance().setAccountType(AccountType.fromRole(e.getRole()));
        // }
        // });
    }

    /**
     * logout
     */
    public void logout() {
        Context.getInstance().setAccountType(null);
    }

    /**
     * createAccount
     * 
     * @param accountType account who will be created
     */
    public void createAccount(AccountType accountType) {

        List<String> attributes = new ArrayList<String>();
        // id
        attributes.add("username");
        attributes.add("password");
        attributes.add("full name");
        attributes.add("gender");
        attributes.add("phone number");
        attributes.add("email");
        // role

        if (accountType == AccountType.TRAINER) {
            attributes.add("trainer level");
        }

        if (accountType == AccountType.CUSTOMER) {
            // customer_date_joined
            attributes.add("height");
            attributes.add("weight");
            attributes.add("paid");
        }

        List<String> messages = attributes.stream().map(attribute -> "Enter " + attribute + ": ")
                .collect(Collectors.toList());

        List<String> inputs = Utils.readInputs("=========== Create Account ===========", messages);

        switch (accountType) {
            case MANAGER:
                Utils.createData(MANAGER_FILE, new Manager(inputs).writeData());
                break;
            case TRAINER:
                Utils.createData(TRAINER_FILE, new Trainer(inputs).writeData());
                break;
            case CUSTOMER:
                Utils.createData(CUSTOMER_FILE, new Customer(inputs).writeData());
                break;
            default:
                break;
        }
    }

    /**
     * view account
     * 
     * @param accountType
     */
    public void viewAccount(AccountType accountType) {
        switch (accountType) {
            case MANAGER:
                Utils.viewData(MANAGER_FILE, accountType);
                break;
            case TRAINER:
                Utils.viewData(TRAINER_FILE, accountType);
                break;
            case CUSTOMER:
                Utils.viewData(CUSTOMER_FILE, accountType);
                break;
            default:
                break;
        }
    }

    public void updateAccount(AccountType accountType) {

        viewAccount(accountType);

        List<String> messages = new ArrayList<String>();
        messages.add("Enter user ID that will be edited: ");
        String updateUserId = Utils.readInputs("=========== Update Account ===========", messages).get(0);

        switch (accountType) {
            case MANAGER:
                Utils.updateData(MANAGER_FILE, updateUserId);
                break;
            case TRAINER:
                Utils.updateData(TRAINER_FILE, updateUserId);
                break;
            case CUSTOMER:
                Utils.updateData(CUSTOMER_FILE, updateUserId);
                break;
            default:
                break;
        }

    }

    public void deleteAccount(AccountType accountType) {
        List<String> messages = new ArrayList<String>();
        messages.add("Enter delete target user ID : ");
        String deleteUserId = Utils.readInputs("=========== Delete Account ===========", messages).get(0);

        switch (accountType) {
            case MANAGER:
                Utils.deleteData(MANAGER_FILE, deleteUserId);
                break;
            case TRAINER:
                Utils.deleteData(TRAINER_FILE, deleteUserId);
                break;
            case CUSTOMER:
                Utils.deleteData(CUSTOMER_FILE, deleteUserId);
                break;
            default:
                break;
        }
    }

    public void searchAccount(AccountType accountType) {
        List<String> messages = new ArrayList<String>();
        messages.add("Enter full name to search for: ");
        String searchBythis = Utils.readInputs("=========== Search Result ===========", messages).get(0);

        switch (accountType) {
            case MANAGER:
                Utils.searchData(MANAGER_FILE, searchBythis).stream().forEach(System.out::println);
                break;
            case TRAINER:
                Utils.searchData(TRAINER_FILE, searchBythis).stream().forEach(System.out::println);
                break;
            case CUSTOMER:
                Utils.searchData(CUSTOMER_FILE, searchBythis).stream().forEach(System.out::println);
                break;
            default:
                break;
        }
    }

}
