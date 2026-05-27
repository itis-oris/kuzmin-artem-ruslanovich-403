package ru.itis.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.model.AnimalSpecies;

@Data
public class AnimalCreateForm {
    private String nickname;
    private AnimalSpecies species;
    private Long enclosureId;
    private MultipartFile image;


}