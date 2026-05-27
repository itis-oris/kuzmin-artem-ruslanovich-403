package ru.itis.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itis.model.Animal;
import ru.itis.model.Enclosure;
import ru.itis.model.Keeper;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class EnclosureRepositoryCriteriaImpl implements EnclosureRepositoryCriteria {

    private final EntityManager entityManager;

    @Override
    public List<Enclosure> findOverLoadedEnclosures() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Enclosure> query = cb.createQuery(Enclosure.class);

        Root<Enclosure> enclosure = query.from(Enclosure.class);

        Join<Enclosure, Animal> animal = enclosure.join("animals");

        Join<Enclosure, Keeper> keeper = enclosure.join("keepers");

        query.groupBy(enclosure.get("id"));

        Expression<Long> animalCount = cb.countDistinct(animal.get("id"));
        Expression<Long> keeperCount = cb.countDistinct(keeper.get("id"));

        query.having(cb.and(cb.greaterThan(animalCount, 10L),
                cb.greaterThanOrEqualTo(keeperCount, 2L)));

        return entityManager.createQuery(query).getResultList();
    }


}
