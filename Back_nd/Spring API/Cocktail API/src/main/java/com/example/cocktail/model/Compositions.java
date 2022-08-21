package com.example.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Compositions {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail;
    @OneToMany
    @JoinTable(
            name = "Drinks_Compositions",
            joinColumns = @JoinColumn(name = ""),
            inverseJoinColumns = @JoinColumn(name = "")
    )
    private List<Drinks> drinks;
}