package project.client.util;

import project.server.domain.enums.AccountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemInUtils {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * read inputs
     *
     * @param title
     * @param messages
     * @return the inputs as a list
     */
    public static List<String> readInputs(String title, List<String> messages) {
        List<String> inputs = new ArrayList<>();

        try {
            System.out.println(title);

            messages.forEach(message -> {
                System.out.print(message);
                String input = sc.nextLine();
                inputs.add(input.trim());
            });

        } catch (Exception err) {
            System.out.println("Something went wrong.");
            err.printStackTrace();
        }
        return inputs;
    }

    /**
     * view data to display account, appointment and feedback
     *
     * @param filePath
     * @param accountType
     * @return all data in txt file
     */
    public static List<List<String>> viewData(String filePath, AccountType accountType) {
//        List<String[]> data = scanFile(filePath);
        List<List<String>> result = new ArrayList<>();

//        data.forEach(line -> {
//            result.add(Arrays.asList(line));
//        });

        for (int i = 0; i < result.size(); i++) {
            System.out.println("id: " + result.get(i).toString().split(",")[0]);
            System.out.println("username: " + result.get(i).toString().split(",")[1]);
            System.out.println("password: " + result.get(i).toString().split(",")[2]);
            System.out.println("full name: " + result.get(i).toString().split(",")[3]);
            System.out.println("gender: " + result.get(i).toString().split(",")[4]);
            System.out.println("phone number: " + result.get(i).toString().split(",")[5]);
            System.out.println("email: " + result.get(i).toString().split(",")[6]);
            if (accountType == AccountType.TRAINER) {
                System.out.println("trainer_level: " + result.get(i).toString().split(",")[8]);
            }

            if (accountType == AccountType.CUSTOMER) {
                System.out.println("date joined: " + result.get(i).toString().split(",")[9]);
                System.out.println("height: " + result.get(i).toString().split(",")[10]);
                System.out.println("weight: " + result.get(i).toString().split(",")[11]);
                System.out.println("Payment status: " + result.get(i).toString().split(",")[12]);
            }

            System.out.println("===========================");
        }

        return result;
    }
}
