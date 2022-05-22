package project.server;

import project.server.auth.Context;
import project.server.domain.dto.CustomerDto;
import project.server.domain.dto.ManagerDto;
import project.server.domain.dto.TrainerDto;
import project.server.domain.dto.UserDto;
import project.server.domain.enums.AccountType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserService {

    public void login(String username, String password) {
        UserDto.getAllUser().stream()
                .filter(e -> username.equals(e.getUsername()) &&
                        password.equals(e.getPassword()))
                .findFirst()
                .ifPresent(user -> Context.getInstance().init(user));
    }

    public void logout() {
        Context.getInstance().reset();
    }

    public Map<String, String> createAccount(AccountType accountType, List<String> inputs) {
        return switch (accountType) {
            case MANAGER -> ManagerDto.createManager(inputs).toMap();
            case TRAINER -> TrainerDto.createTrainer(inputs).toMap();
            case CUSTOMER -> CustomerDto.createCustomer(inputs).toMap();
            default -> Collections.emptyMap();
        };
    }

    public void viewAccount(AccountType accountType) {

    }

    public void updateAccount(AccountType accountType) {


    }

    public void deleteAccount(AccountType accountType) {

    }

    public void searchAccount(AccountType accountType) {

    }
}
