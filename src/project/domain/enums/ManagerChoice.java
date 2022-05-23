package project.domain.enums;

import java.util.Arrays;

// when user loggedin
public enum ManagerChoice {

    CREATE_MANAGER_ACCOUNT(1, "Create Manager account"),
    VIEW_MANAGER_ACCOUNT(2, "View Manager account"),
    EDIT_MANAGER_ACCOUNT(3, "Edit Manager account"),
    DELETE_MANAGER_ACCOUNT(4, "Delete Manager account"),
    SEARCH_MANAGER_ACCOUNT(5, "Search Manager account"),

    CREATE_TRAINER_ACCOUNT(6, "Create Trainer account"),
    VIEW_TRAINER_ACCOUNT(7, "View Trainer account"),
    EDIT_TRAINER_ACCOUNT(8, "Edit Trainer account"),
    DELETE_TRAINER_ACCOUNT(9, "Delete Trainer account"),
    SEARCH_TRAINER_ACCOUNT(10, "Search Trainer account"),

    CREATE_CUSTOMER_ACCOUNT(11, "Create Customer account"),
    VIEW_CUSTOMER_ACCOUNT(12, "View Customer account"),
    EDIT_CUSTOMER_ACCOUNT(13, "Edit Customer account"),
    DELETE_CUSTOMER_ACCOUNT(14, "Delete Customer account"),
    SEARCH_CUSTOMER_ACCOUNT(15, "Search Customer account"),

    BACK_TO_MENU(0, "Log out");

    private int code;
    private String msg;

    private ManagerChoice(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // -----------------------------------------------------------------

    public static ManagerChoice findByCode(int code) {
        return Arrays.stream(ManagerChoice.values()).filter(managerChoice -> managerChoice.getCode() == code)
                .findFirst().orElse(null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
