package project.server.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileUtils {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * scan file
     *
     * @param filePath
     * @return lines
     */
    public static List<List<String>> scanFile(String filePath) {
        List<List<String>> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(Arrays.asList(line.trim().split("\\s*,\\s*")));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File was not found. Make sure the file exist.");
            System.err.println("Message: " + e.getMessage());
        }
        return lines;
    }

    /**
     * Insert
     *
     * @param filePath
     * @param data
     * @return inserted data
     */
    public static List<String> insert(String filePath, List<String> data) {
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
     * delete
     *
     * @param filePath
     * @param id
     * @return remain data
     */
    public static List<List<String>> delete(String filePath, String id) {
        List<List<String>> newData = scanFile(filePath) //
                .stream().filter(line -> !line.get(0).equals(id)).collect(Collectors.toList());

        truncate(filePath);

        newData.forEach(line -> insert(filePath, line));

        return newData;
    }

    /**
     * update
     *
     * @param filePath
     * @param data
     * @return updated data
     */
    public static List<String> update(String filePath, List<String> data) {
        List<List<String>> updatedData = scanFile(filePath) //
                .stream().map(line -> line.get(0).equals(data.get(0)) ? data : line).collect(Collectors.toList());

        truncate(filePath);

        updatedData.forEach(line -> insert(filePath, line));
        return data;
    }

    /**
     * truncate
     *
     * @param filePath
     */
    private static void truncate(String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
