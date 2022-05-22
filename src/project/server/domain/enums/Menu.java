package project.server.domain.enums;

import project.server.auth.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Menu {

    VIEW_MANAGER_ACCOUNT("1", "View Manager account", List.of(AccountType.MANAGER)),
    EDIT_MANAGER_ACCOUNT("2", "Edit Manager account", List.of(AccountType.MANAGER)),
    DELETE_MANAGER_ACCOUNT("3", "Delete Manager account", List.of(AccountType.MANAGER)),
    SEARCH_MANAGER_ACCOUNT("4", "Search Manager account", List.of(AccountType.MANAGER)),

    CREATE_TRAINER_ACCOUNT("5", "Create Trainer account", List.of(AccountType.MANAGER)),
    VIEW_TRAINER_ACCOUNT("6", "View Trainer account", List.of(AccountType.MANAGER)),
    EDIT_TRAINER_ACCOUNT("7", "Edit Trainer account", List.of(AccountType.MANAGER)),
    DELETE_TRAINER_ACCOUNT("8", "Delete Trainer account", List.of(AccountType.MANAGER)),
    SEARCH_TRAINER_ACCOUNT("9", "Search Trainer account", List.of(AccountType.MANAGER)),

    CREATE_CUSTOMER_ACCOUNT("10", "Create Customer account", List.of(AccountType.MANAGER)),
    VIEW_CUSTOMER_ACCOUNT("11", "View Customer account", List.of(AccountType.MANAGER)),
    EDIT_CUSTOMER_ACCOUNT("12", "Edit Customer account", List.of(AccountType.MANAGER)),
    DELETE_CUSTOMER_ACCOUNT("13", "Delete Customer account", List.of(AccountType.MANAGER)),
    SEARCH_CUSTOMER_ACCOUNT("14", "Search Customer account", List.of(AccountType.MANAGER)),

    CREATE_BOOKING("15", "create booking", List.of(AccountType.TRAINER)),
    VIEW_BOOKING("16", "view bookings", List.of(AccountType.TRAINER)),
    UPDATE_BOOKING("17", "update bookings", List.of(AccountType.TRAINER)),
    DELETE_BOOKING("18", "delete bookings", List.of(AccountType.TRAINER)),
    SEARCH_BOOKING("19", "search bookings", List.of(AccountType.TRAINER)),

    VIEW_PROFILE("20", "View my profile", List.of(AccountType.CUSTOMER)),
    VIEW_FEEDBACK("21", "View my feedback from trainer", List.of(AccountType.CUSTOMER)),

    LOGOUT("0", "Log out", List.of(AccountType.MANAGER, AccountType.TRAINER, AccountType.CUSTOMER));

    private final String code;
    private final String message;
    private final List<AccountType> userTypes;

    Menu(String code, String message, List<AccountType> userTypes) {
        this.code = code;
        this.message = message;
        this.userTypes = userTypes;
    }

    public static List<Menu> filterByAccountType() {
        return Arrays.stream(Menu.values()).filter(menu ->
                menu.getUserTypes().contains(Context.getInstance().getCurrentUser().getAccountType())
        ).collect(Collectors.toList());
    }

    public static Map<String, String> list() {
        return filterByAccountType().stream().collect(Collectors.toMap(Menu::getCode, Menu::getMessage));
    }

    public static Menu fromCode(String code) {
        return Arrays.stream(Menu.values()).filter(menu -> menu.getCode().equals(code)).findFirst().orElse(null);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<AccountType> getUserTypes() {
        return userTypes;
    }
}
