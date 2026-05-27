package ru.itis.service;



import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.AnimalDto;
import ru.itis.form.AnimalCreateForm;
import ru.itis.handler.exception.NotFoundException;
import ru.itis.model.Animal;
import ru.itis.model.AnimalSpecies;
import ru.itis.model.Enclosure;
import ru.itis.repository.AnimalRepository;
import ru.itis.repository.EnclosureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;
    private final FileService fileService;


    @Transactional
    @CacheEvict(value = {"animals", "animalsBySpecies"}, allEntries = true)
    public void createAnimal(AnimalCreateForm form) {

        Enclosure enclosure = enclosureRepository.findById(form.getEnclosureId())
                .orElseThrow(() -> new NotFoundException("Вольер с ID " + form.getEnclosureId() + " не найден"));

        String imagePath = fileService.saveFile(form.getImage());

        Animal animal = Animal.builder()
                .nickname(form.getNickname())
                .species(form.getSpecies())
                .imagePath(imagePath)
                .enclosure(enclosure)
                .build();

        animalRepository.save(animal);

    }

    @Cacheable(value = "animals")
    public List<AnimalDto> findAll() {
        return animalRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    @Cacheable(value = "animalsBySpecies", key = "#species")
    public List<AnimalDto> findAllBySpecies(AnimalSpecies species) {
        return animalRepository.findAllBySpecies(species).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AnimalDto convertToDto(Animal animal) {
        return AnimalDto.builder()
                .id(animal.getId())
                .nickname(animal.getNickname())
                .speciesDisplay(animal.getSpecies().getDisplayValue())
                .imagePath(animal.getImagePath())
                .enclosureName(animal.getEnclosure() != null ? animal.getEnclosure().getName() : "Без вольера")
                .build();
    }



}
