package ru.itis.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "enclosures")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enclosure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnclosureType type;

    @OneToMany(mappedBy = "enclosure")
    private List<Animal> animals = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "enclosure_keepers",
            joinColumns = @JoinColumn(name = "enclosure_id"),
            inverseJoinColumns = @JoinColumn(name = "keeper_id")
    )
    private List<Keeper> keepers = new ArrayList<>();

}
