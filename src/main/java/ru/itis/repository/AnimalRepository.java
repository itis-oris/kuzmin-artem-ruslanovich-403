package ru.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Animal;
import ru.itis.model.AnimalSpecies;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAllBySpecies(AnimalSpecies species);
}
