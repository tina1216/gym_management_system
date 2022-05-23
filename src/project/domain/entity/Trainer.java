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
     * Constructor for reading in
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

    public Trainer(List<String> input) {
        this.id = input.get(0);
        this.username = input.get(1);
        this.password = input.get(2);
        this.fullName = input.get(3);
        this.gender = input.get(4);
        this.phoneNumber = input.get(5);
        this.email = input.get(6);
        this.role = input.get(7);
        this.trainer_level = Integer.parseInt(input.get(8));
    }

    /**
     * generateTrainer for new customer account
     * 
     * @param inputs
     */
    public Trainer generateTrainer(List<String> inputs) {
        Trainer trainer = new Trainer();

        trainer.id = UUID.randomUUID().toString();
        trainer.username = inputs.get(0);
        trainer.password = inputs.get(1);
        trainer.fullName = inputs.get(2);
        trainer.gender = inputs.get(3);
        trainer.phoneNumber = inputs.get(4);
        trainer.email = inputs.get(5);
        trainer.role = AccountType.TRAINER.getRole();
        trainer.trainer_level = Integer.parseInt(inputs.get(6));

        return trainer;
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
