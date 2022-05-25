package project;

import project.domain.entity.*;
import project.domain.enums.*;
import java.util.*;
import java.util.stream.Collectors;

public class Service {

    // application.properties
    public final static String MANAGER_FILE = "src/resources/manager.txt";
    public final static String TRAINER_FILE = "src/resources/trainer.txt";
    public final static String CUSTOMER_FILE = "src/resources/customer.txt";
    public final static String BOOKING_FILE = "src/resources/Booking.txt";
    public final static String FEEDBACK_FILE = "src/resources/feedback.txt";

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

        Context.getInstance().getPeople().stream()
                .filter(e -> username.equals(e.getUsername()) &&
                        password.equals(e.getPassword()))
                .findFirst()
                .ifPresent(person -> Context.getInstance().setCurrentUserId(person.getId()));
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
                Utils.createData(MANAGER_FILE, new Manager().generateManager(inputs).writeData());
                break;
            case TRAINER:
                Utils.createData(TRAINER_FILE, new Trainer().generateTrainer(inputs).writeData());
                break;
            case CUSTOMER:
                Utils.createData(CUSTOMER_FILE, new Customer().generateCustomer(inputs).writeData());
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
    public void listAllAccounts(AccountType accountType) {
        switch (accountType) {
            case MANAGER:
                Utils.listAllData(MANAGER_FILE).forEach(System.out::println);
                break;
            case TRAINER:
                Utils.listAllData(TRAINER_FILE).forEach(System.out::println);
                break;
            case CUSTOMER:
                Utils.listAllData(CUSTOMER_FILE).forEach(System.out::println);
                break;
            default:
                break;
        }
    }

    /**
     * updateAccount
     * 
     * @param accountType
     */
    public void updateAccount(AccountType accountType) {
        listAllAccounts(accountType);

        List<String> target = null;
        List<String> messages = new ArrayList<String>();

        messages.add("Select ID to update: ");
        String userId = Utils.readInputs("=========== Update Account ===========", messages).get(0);

        switch (accountType) {
            case MANAGER:
                target = askToUpdate(accountType, userId);
                Utils.updateData(MANAGER_FILE, target);
                break;

            case TRAINER:
                target = askToUpdate(accountType, userId);
                Utils.updateData(TRAINER_FILE, target);
                break;

            case CUSTOMER:
                target = askToUpdate(accountType, userId);
                Utils.updateData(CUSTOMER_FILE, target);
                break;

            default:
                break;
        }
    }

    // testing purpose only
    public List<String> askToUpdate(AccountType accountType, String id) {
        List<String> attributes = new ArrayList<String>();

        attributes.add(id);
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
        List<String> inputs = Utils.readInputs("", messages);
        return inputs;
    }

    /**
     * delete account
     * 
     * @param accountType
     */
    public void deleteAccount(AccountType accountType) {
        List<String> messages = new ArrayList<String>();
        messages.add("Enter ID to delete: ");
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

    /**
     * search account
     * 
     * @param accountType
     */
    public void searchAccount(AccountType accountType) {
        List<String> messages = new ArrayList<String>();
        messages.add("Enter ID to search for: ");
        String userId = Utils.readInputs("=========== Search Result ===========", messages).get(0);

        switch (accountType) {
            case MANAGER:
                Utils.searchData(MANAGER_FILE, userId).forEach(System.out::println);
                break;

            case TRAINER:
                Utils.searchData(TRAINER_FILE, userId).forEach(System.out::println);
                break;

            case CUSTOMER:
                Utils.searchData(CUSTOMER_FILE, userId).forEach(System.out::println);
                break;

            default:
                break;
        }
    }

    // -------------------------------------------------------------
    /**
     * create booking, it reads duration of training, booked date and trainer id.
     */
    public void createBooking() {

        try {
            List<String> attributes = new ArrayList<String>();
            // id
            // dateAdded
            attributes.add("duration");
            attributes.add("booked date");
            // attributes.add("customer ID");
            attributes.add("trainer ID");

            List<String> messages = attributes.stream().map(attribute -> "Enter " + attribute + ": ")
                    .collect(Collectors.toList());

            List<String> inputs = Utils.readInputs("=========== Create New Booking ===========", messages);

            Utils.createData(BOOKING_FILE, new Booking().addBooking(inputs).writeData());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * create feedback for customer, it reads comment and customer ID
     */
    public void createFeedback() {
        List<String> attributes = new ArrayList<String>();
        // id
        // dateAdded
        attributes.add("comment");
        // attributes.add("trainer ID");
        attributes.add("customer ID");

        List<String> messages = attributes.stream().map(attribute -> "Enter " + attribute + ": ")
                .collect(Collectors.toList());

        List<String> inputs = Utils.readInputs("=========== Create New Feedback ===========", messages);

        Utils.createData(FEEDBACK_FILE, new Feedback().addFeedback(inputs).writeData());
    }

    /**
     * show all data from either Booking.txt or feedback.txt
     */
    public void listAllInfo(AccountType accountType) {
        switch (accountType) {
            case TRAINER:
                Utils.listAllData(BOOKING_FILE).forEach(System.out::println);
                break;
            case CUSTOMER:
                Utils.listAllData(FEEDBACK_FILE).forEach(System.out::println);
                break;
            default:
                break;
        }
    }

    /**
     * update booking and feedback
     * 
     * @param accountType
     */
    public void updateInfo(AccountType accountType) {
        List<String> target = null;
        List<String> messages = new ArrayList<String>();
        String userInput, userId;

        switch (accountType) {
            case TRAINER:
                userId = Context.getInstance().getCurrentUserId();
                Utils.searchData(BOOKING_FILE, userId).forEach(System.out::println);

                messages.add("Select ID to update: ");
                userInput = Utils.readInputs("", messages).get(0);
                target = Utils.searchData(BOOKING_FILE, userInput);
                Utils.updateData(BOOKING_FILE, target).forEach(System.out::println);
                break;

            case CUSTOMER:
                userId = Context.getInstance().getCurrentUserId();
                Utils.searchData(FEEDBACK_FILE, userId).forEach(System.out::println);

                messages.add("Select ID to update: ");
                userInput = Utils.readInputs("", messages).get(0);
                target = Utils.searchData(FEEDBACK_FILE, userInput);
                Utils.updateData(FEEDBACK_FILE, target).forEach(System.out::println);
                break;

            default:
                break;
        }
    }

    /**
     * delete booking or feedback
     */
    public void deleteInfo(AccountType accountType) {
        List<String> messages = new ArrayList<String>();
        String userInput;

        switch (accountType) {
            case TRAINER:
                searchMyData(accountType);
                messages.add("Enter ID to delete: ");
                userInput = Utils.readInputs("", messages).get(0);
                Utils.deleteData(BOOKING_FILE, userInput);
                break;

            case CUSTOMER:
                searchMyData(accountType);
                messages.add("Enter ID to delete: ");
                userInput = Utils.readInputs("", messages).get(0);
                Utils.deleteData(FEEDBACK_FILE, userInput);
                break;

            default:
                break;
        }
    }

    /**
     * search data only for the user current logged in
     * 
     * @param accountType
     */
    public void searchMyData(AccountType accountType) {
        String userId = Context.getInstance().getCurrentUserId();

        switch (accountType) {
            case TRAINER:
                Utils.searchById(BOOKING_FILE, userId).forEach(System.out::println);
                break;

            case CUSTOMER:
                Utils.searchById(FEEDBACK_FILE, userId).forEach(System.out::println);
                break;

            default:
                break;
        }
    }

    /**
     * search profile by current user id and return the result
     * 
     * @param accountType
     */
    public void searchMyProfile(AccountType accountType) {
        String userId = Context.getInstance().getCurrentUserId();

        switch (accountType) {
            case TRAINER:
                Utils.searchById(TRAINER_FILE, userId).forEach(System.out::println);
                break;

            case CUSTOMER:
                Utils.searchById(CUSTOMER_FILE, userId).forEach(System.out::println);
                break;

            default:
                break;
        }
    }

}
