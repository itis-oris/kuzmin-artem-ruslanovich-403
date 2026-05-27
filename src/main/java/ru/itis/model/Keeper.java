package ru.itis.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "keepers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String position;

    private String phone;

    @ManyToMany(mappedBy = "keepers")
    private List<Enclosure> enclosures = new ArrayList<>();

}
