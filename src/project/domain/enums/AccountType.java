package project.domain.enums;

import java.util.Arrays;

public enum AccountType {

    MANAGER("M"),
    TRAINER("T"),
    CUSTOMER("C");

    private final String role;

    private AccountType(String role) {
        this.role = role;
    }

    public static AccountType fromRole(String role) {
        return Arrays.stream(AccountType.values()).filter(accountType -> accountType.getRole().equals(role))
                .findFirst().orElse(null);
    }

    public String getRole() {
        return role;
    }

}
