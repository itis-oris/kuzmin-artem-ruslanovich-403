package ru.itis.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.form.KeeperCreateForm;
import ru.itis.model.Keeper;
import ru.itis.repository.KeeperRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeeperService {

    private final KeeperRepository keeperRepository;

    public List<Keeper> findAll() {
        return keeperRepository.findAll();
    }


    @Transactional
    public void create(KeeperCreateForm form) {
        Keeper keeper = Keeper.builder()
                .fullName(form.getFullName())
                .position(form.getPosition())
                .phone(form.getPhone())
                .build();
        keeperRepository.save(keeper);
    }
}
