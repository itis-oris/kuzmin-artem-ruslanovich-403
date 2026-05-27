package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Keeper;

public interface KeeperRepository extends JpaRepository<Keeper, Long> {
}
