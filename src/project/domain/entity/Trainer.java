package project.domain.entity;

import project.domain.enums.AccountType;
import java.util.*;

public class Trainer extends Person {

    private int trainer_level;

    public Trainer() {

    }

    public Trainer(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role, int trainer_level) {
        super(id, username, password, fullName, gender, phoneNumber, email, role);
        this.trainer_level = trainer_level;
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Trainer(String[] line) {
        this.id = line[0];
        this.username = line[1];
        this.password = line[2];
        this.fullName = line[3];
        this.gender = line[4];
        this.phoneNumber = line[5];
        this.email = line[6];
        this.role = line[7];
        this.trainer_level = Integer.parseInt(line[8]);
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Trainer(List<String> inputs) {
        this.id = UUID.randomUUID().toString();
        this.username = inputs.get(0);
        this.password = inputs.get(1);
        this.fullName = inputs.get(2);
        this.gender = inputs.get(3);
        this.phoneNumber = inputs.get(4);
        this.email = inputs.get(5);
        this.role = AccountType.TRAINER.getRole();
        this.trainer_level = Integer.parseInt(inputs.get(6));
    }

    // -------------------------------------------------------------
    public int getTrainer_level() {
        return trainer_level;
    }

    public void setTrainer_level(int trainer_level) {
        this.trainer_level = trainer_level;
    }

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(id, username, password, fullName, gender, phoneNumber, email, role,
                        String.valueOf(trainer_level))));
        return data;
    }

}
