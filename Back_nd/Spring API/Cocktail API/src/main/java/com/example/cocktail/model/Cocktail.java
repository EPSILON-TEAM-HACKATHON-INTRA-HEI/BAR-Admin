package com.example.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cocktail implements Serializable {
    @Id
    private Integer id;
    @Column(name = "cocktail_name",nullable = false,unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "compositions_id")
    private Compositions compositions;
}
