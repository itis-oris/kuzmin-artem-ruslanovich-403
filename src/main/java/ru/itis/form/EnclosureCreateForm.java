package ru.itis.form;

import lombok.Data;
import ru.itis.model.EnclosureType;

import java.util.List;

@Data
public class EnclosureCreateForm {
    private String name;
    private EnclosureType type;
    private List<Long> keeperIds;
}