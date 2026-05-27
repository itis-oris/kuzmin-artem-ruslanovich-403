package ru.itis.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.form.EnclosureCreateForm;
import ru.itis.handler.exception.NotFoundException;
import ru.itis.model.Enclosure;

import ru.itis.model.Keeper;
import ru.itis.repository.EnclosureRepository;
import ru.itis.repository.KeeperRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnclosureService {

    private final EnclosureRepository enclosureRepository;
    private final KeeperRepository keeperRepository;

    public List<Enclosure> findAll() {
        return enclosureRepository.findAll();
    }

    public Enclosure findById(Long id) {
        return enclosureRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Вольер с id " + id + " не найден"));
    }

    @Transactional
    public void create(EnclosureCreateForm form) {
        Enclosure enclosure = Enclosure.builder()
                .name(form.getName())
                .type(form.getType())
                .keepers(new ArrayList<>())
                .build();

        if (form.getKeeperIds() != null && !form.getKeeperIds().isEmpty()) {
            List<Keeper> keepers = keeperRepository.findAllById(form.getKeeperIds());

            for (Keeper keeper : keepers) {
                enclosure.getKeepers().add(keeper);
                keeper.getEnclosures().add(enclosure);
            }
        }

        enclosureRepository.save(enclosure);
    }

    public List<Enclosure> findOverLoadedEnclosures() {

        return enclosureRepository.findOverLoadedEnclosures();
    }

}
