package com.example.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "drinks_id")
    private Drinks drinks;
}
