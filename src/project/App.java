package project;

import project.domain.entity.Customer;
import project.domain.entity.Manager;
import project.domain.entity.Trainer;
import java.io.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    // application.properties
    public final static String MANAGER_FILE = "src/resources/manager.txt";
    public final static String TRAINER_FILE = "src/resources/trainer.txt";
    public final static String CUSTOMER_FILE = "src/resources/customer.txt";

    public static Service service = new Service();
    public static Controller controller = new Controller();

    public static void main(String[] args) throws Exception {

        init();
        login();

        while (true) {

            if (Context.getInstance().getAccountType() == null) {
                login();
            }

            controller.menu();
        }
    }

    private static void init() {
        Context.getInstance()
                .setManagers(Utils.scanFile(MANAGER_FILE).stream().map(Manager::new).collect(Collectors.toList()));
        Context.getInstance()
                .setTrainers(Utils.scanFile(TRAINER_FILE).stream().map(Trainer::new).collect(Collectors.toList()));
        Context.getInstance()
                .setCustomers(Utils.scanFile(CUSTOMER_FILE).stream().map(Customer::new).collect(Collectors.toList()));
        Context.getInstance().initPeople();
    }

    private static void login() {
        List<String> messages = new ArrayList<String>();
        messages.add("Enter username: ");
        messages.add("Enter password: ");
        List<String> inputs = Utils.readInputs("=========== Login Page ===========", messages);
        service.login(inputs.get(0), inputs.get(1));
    }

}
