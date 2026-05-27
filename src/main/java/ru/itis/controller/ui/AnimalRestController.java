package ru.itis.controller.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.AnimalDto;
import ru.itis.model.AnimalSpecies;
import ru.itis.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalRestController {

    private final AnimalService animalService;


    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAll(@RequestParam(required = false) AnimalSpecies species) {
        List<AnimalDto> animals;
        
        if (species != null) {
            animals = animalService.findAllBySpecies(species);
        } else {
            animals = animalService.findAll();
        }
        
        return ResponseEntity.ok(animals);
    }
}