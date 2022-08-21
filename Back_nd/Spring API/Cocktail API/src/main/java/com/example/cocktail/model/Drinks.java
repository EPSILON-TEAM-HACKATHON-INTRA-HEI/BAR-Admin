package com.example.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Drinks implements Serializable {
    @Id
    private Integer id;
    @Column(name = "drink_name",nullable = false)
    private String name;
    @Column(name = "unite_price")
    private Long price;
    @OneToOne
    @JoinColumn(name = "fk_category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "compositions_id")
    private Compositions compositions;
}
