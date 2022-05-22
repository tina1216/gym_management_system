package project.server.domain.entity;

import project.server.domain.dto.TrainerDto;
import project.server.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends User {

    private final static String TRAINER_FILE_PATH = "src/resources/trainer.txt";

    private final String level;

    public Trainer(User user, String trainerLevel) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getFullName(), user.getGender(), user.getPhoneNumber(), user.getEmail(), user.getAccountType());
        this.level = trainerLevel;
    }

    public Trainer(TrainerDto dto) {
        super(dto);
        this.level = dto.getLevel();
    }

    public void save() {
        super.save();
        FileUtils.insert(TRAINER_FILE_PATH, toRawData());
    }

    public List<String> toRawData() {
        List<String> rawData = new ArrayList<>();
        rawData.add(this.getId());
        rawData.add(this.getLevel());
        return rawData;
    }

    public String getLevel() {
        return level;
    }
}
