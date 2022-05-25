package project;

import java.io.*;
import java.util.*;

public class Utils {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * read .txt file
     * 
     * @param filePath
     * @return a list that contains each line from the .txt file
     */
    public static List<List<String>> scanFile(String filePath) {
        List<List<String>> lines = new ArrayList<List<String>>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(Arrays.asList(line.trim().split("\\s*,\\s*")));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File was not found. Make sure the file exists.");
            System.err.println("Message: " + e.getMessage());
        }
        return lines;
    }

    /**
     * read user inputs
     * 
     * @param title
     * @param messages
     * @return the inputs as a list
     */
    public static List<String> readInputs(String title, List<String> messages) {
        List<String> inputs = new ArrayList<String>();

        try {
            System.out.println(title);

            messages.forEach(message -> {
                System.out.print(message);
                String input = sc.nextLine();
                inputs.add(input.trim());
            });

        } catch (Exception err) {
            err.printStackTrace();
        }
        return inputs;
    }

    /**
     * clean up all data in the file
     * 
     * @param filePath
     * @param id
     * @return
     */
    private static void clearData(String filePath) {
        File file = new File(filePath);

        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write("");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create account, appointment and feedback
     * 
     * @param filePath
     * @param data
     * @return newly created data aka account data
     */
    public static List<String> createData(String filePath, List<String> data) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);

            for (int i = 1; i <= data.size(); i++) {
                fileWriter.write(data.get(i - 1));
                if (i != data.size()) {
                    fileWriter.write(",");
                } else {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * delete account, appointment and feedback
     * 
     * @param filePath
     * @param id
     * @return new data
     */
    public static List<List<String>> deleteData(String filePath, String id) {
        List<List<String>> oldData = scanFile(filePath);
        List<List<String>> newData = new ArrayList<List<String>>();

        for (List<String> line : oldData) {
            if (!line.get(0).equals(id)) {
                // add all into newData except the one that will be deleted
                newData.add(line);
            }
        }

        clearData(filePath);

        newData.forEach(line -> {
            createData(filePath, line);
        });

        return newData;
    }

    /**
     * display all data
     * 
     * @param filePath
     * @param id
     * @return all data in txt file
     */
    public static List<List<String>> listAllData(String filePath) {
        List<List<String>> data = scanFile(filePath);
        return data;
    }

    /**
     * update data
     * 
     * @param filePath
     * @param data
     * @return updated data
     */
    public static List<List<String>> updateData(String filePath, List<String> data) {
        List<List<String>> oldData = scanFile(filePath);
        List<List<String>> updatedData = new ArrayList<List<String>>();

        for (List<String> line : oldData) {
            if (line.get(0).equals(data.get(0))) {
                oldData.remove(line);
                updatedData.add(data);
            } else {
                updatedData.add(line);
            }
        }

        clearData(filePath);

        updatedData.forEach(line -> {
            createData(filePath, line);
        });

        return updatedData;
    }

    /**
     * search data
     * 
     * @param filePath
     * @param name
     * @return results
     */
    public static List<String> searchData(String filePath, String id) {
        List<List<String>> data = scanFile(filePath);

        for (List<String> line : data) {
            if (line.get(0).equals(id)) {
                return line;
            }
        }
        return Collections.emptyList();
    }

    // -------------------------------------------------------------

    public static List<String> searchById(String filePath, String id) {
        List<List<String>> data = scanFile(filePath);

        for (List<String> line : data) {
            if (line.get(4).equals(id)) {
                return line;
            }
        }
        return Collections.emptyList();
    }

}
