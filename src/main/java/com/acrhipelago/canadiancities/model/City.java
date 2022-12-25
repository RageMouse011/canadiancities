package com.acrhipelago.canadiancities.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
    @Column(name = "area")
    private float area;
}
