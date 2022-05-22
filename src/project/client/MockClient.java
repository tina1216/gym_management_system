package project.client;

import project.client.util.SystemInUtils;
import project.server.Controller;
import project.server.domain.enums.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockClient {
    private final Controller controller = new Controller();

    public void login() {
        List<String> messages = List.of("Enter username: ", "Enter password: ");
        List<String> inputs = SystemInUtils.readInputs("=========== Login Page ===========", messages);
        System.out.println(controller.login(inputs) ? "logged in successfully" : "login failed");
    }

    public void showGlobalMenu() throws Exception {
        Map<String, String> globalMenu = controller.globalMenu();

        System.out.println("=========== Menu ===========");
        globalMenu.entrySet() //
                .stream() //
                .sorted(Comparator.comparing(entry -> Integer.parseInt(entry.getKey()))) //
                .forEach(menu -> System.out.println(menu.getKey() + ": " + menu.getValue()));

        List<String> messages = List.of("Enter menu number: ");
        List<String> inputs = SystemInUtils.readInputs("=========== Menu ===========", messages);
        if (inputs.size() != 1) {
            throw new Exception();
        }
        if (!globalMenu.containsKey(inputs.get(0))) {
            System.out.println("Illegal Input");
            showGlobalMenu();
        }

        System.out.println(globalMenu.get(inputs.get(0)));
        showDetails(inputs.get(0));
    }

    public void showDetails(String input) throws Exception {
        switch (Menu.fromCode(input)) {
            case VIEW_MANAGER_ACCOUNT:
                break;
            case CREATE_TRAINER_ACCOUNT:
                createTrainerAccount();
                break;
            case CREATE_CUSTOMER_ACCOUNT:
                createCustomerAccount();
                break;
            case LOGOUT:
                logout();
                break;
        }
    }

    public void createManagerAccount() throws Exception {
        List<String> attributes = userCommonAttributes();
        Map<String, String> result = controller.createManagerAccount(receiveCreateAccountInput(attributes));
        System.out.println("=========== Created User ===========");
        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void createTrainerAccount() throws Exception {
        List<String> attributes = userCommonAttributes();
        attributes.add("trainer level");
        Map<String, String> result = controller.createTrainerAccount(receiveCreateAccountInput(attributes));
        System.out.println("=========== Created User ===========");
        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void createCustomerAccount() throws Exception {
        List<String> attributes = userCommonAttributes();
        attributes.add("height");
        attributes.add("weight");
        attributes.add("paid");
        Map<String, String> result = controller.createCustomerAccount(receiveCreateAccountInput(attributes));
        System.out.println("=========== Created User ===========");
        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private List<String> userCommonAttributes() {
        List<String> attributes = new ArrayList<>();
        attributes.add("username");
        attributes.add("password");
        attributes.add("full name");
        attributes.add("gender");
        attributes.add("phone number");
        attributes.add("email");
        return attributes;
    }

    private List<String> receiveCreateAccountInput(List<String> attributes) throws Exception {
        List<String> messages = attributes.stream().map(attribute -> "Enter " + attribute + ": ")
                .collect(Collectors.toList());
        List<String> inputs = SystemInUtils.readInputs("=========== Create Account ===========", messages);
        if (inputs.size() != attributes.size()) {
            throw new Exception();
        }
        return inputs;
    }

    private void logout() {
        System.out.println(controller.logout() ? "logged out successfully" : "logout failed");
    }
}
