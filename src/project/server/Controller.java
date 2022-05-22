package project.server;

import project.server.auth.Context;
import project.server.domain.enums.AccountType;

import java.util.List;
import java.util.Map;

public class Controller {

    public static UserService userService = new UserService();
    public static MenuService menuService = new MenuService();

    public boolean login(List<String> inputs) {
        if (inputs.size() != 2) {
            return false;
        }
        userService.login(inputs.get(0), inputs.get(1));
        return Context.getInstance().getCurrentUser() != null;
    }

    public boolean logout() {
        userService.logout();
        return Context.getInstance().getCurrentUser() == null;
    }

    public Map<String, String> globalMenu() {
        return menuService.getGlobalMenu();
    }

    public Map<String, String> createManagerAccount(List<String> inputs) {
        return userService.createAccount(AccountType.MANAGER, inputs);
    }

    public Map<String, String> createTrainerAccount(List<String> inputs) {
        return userService.createAccount(AccountType.TRAINER, inputs);
    }

    public Map<String, String> createCustomerAccount(List<String> inputs) {
        return userService.createAccount(AccountType.CUSTOMER, inputs);
    }

}
