package com.example.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Category implements Serializable {
    @Id
    private Integer id;
    @Column(name = "category_name")
    private String name;
    @OneToMany
    @JoinTable(
            name="Drinks_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private List<Drinks> drinks = new ArrayList<>();
}
