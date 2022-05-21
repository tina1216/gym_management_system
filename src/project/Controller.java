package project;

import java.util.*;

import project.domain.enums.*;

public class Controller {

    public static Service service = new Service();

    public void menu() {
        // input
        List<String> messages = new ArrayList<String>();
        messages.add("Enter menu number: ");
        int input = Integer.parseInt(Utils.readInputs("=========== Menu ===========", messages).get(0));

        switch (Context.getInstance().getAccountType()) {
            case MANAGER:
                managerMenu(input);
                break;
            case TRAINER:
                trainerMenu(input);
                break;
            case CUSTOMER:
                CustomerMenu(input);
                break;
            default:
                break;
        }
    }

    private void managerMenu(int choice) {
        System.out.println(ManagerChoice.findByCode(choice).getMsg());
        switch (choice) {
            case 1:
                service.createAccount(AccountType.MANAGER);
                break;
            case 2:
                service.viewAccount(AccountType.MANAGER);
                break;
            case 3:
                service.updateAccount(AccountType.MANAGER);
                break;
            case 4:
                service.deleteAccount(AccountType.MANAGER);
                break;
            case 5:
                service.searchAccount(AccountType.MANAGER);
                break;
            case 6:
                service.createAccount(AccountType.TRAINER);
                break;
            case 7:
                service.viewAccount(AccountType.TRAINER);
                break;
            case 8:
                service.updateAccount(AccountType.TRAINER);
                break;
            case 9:
                service.deleteAccount(AccountType.TRAINER);
                break;
            case 10:
                service.searchAccount(AccountType.TRAINER);
                break;
            case 11:
                service.createAccount(AccountType.CUSTOMER);
                break;
            case 12:
                service.viewAccount(AccountType.CUSTOMER);
                break;
            case 13:
                service.updateAccount(AccountType.CUSTOMER);
                break;
            case 14:
                service.deleteAccount(AccountType.CUSTOMER);
                break;
            case 15:
                service.searchAccount(AccountType.CUSTOMER);
                break;
            case 0:
                service.logout();
                break;
            default:
                break;
        }
    }

    private void trainerMenu(int choice) {
        System.out.println(TrainerChoice.findByCode(choice).getMsg());
    }

    private void CustomerMenu(int choice) {
        System.out.println(CustomerChoice.findByCode(choice).getMsg());
    }
}
