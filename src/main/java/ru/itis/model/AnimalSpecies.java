package ru.itis.model;


import lombok.Getter;

@Getter
public enum AnimalSpecies {
    MAMMAL("Млекопитающее"),
    BIRD("Птица"),
    REPTILE("Рептилия"),
    AMPHIBIAN("Земноводное"),
    FISH("Рыба");

    private final String displayValue;

    AnimalSpecies(String displayValue) {
        this.displayValue = displayValue;
    }
}
