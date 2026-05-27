package ru.itis.repository;

import ru.itis.model.Enclosure;

import java.util.List;

public interface EnclosureRepositoryCriteria {

    List<Enclosure> findOverLoadedEnclosures();
}
