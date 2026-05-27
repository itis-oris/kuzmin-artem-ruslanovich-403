package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Enclosure;

public interface EnclosureRepository extends JpaRepository<Enclosure, Long>, EnclosureRepositoryCriteria{
}
