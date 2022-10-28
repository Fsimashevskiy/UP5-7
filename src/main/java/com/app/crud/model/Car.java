package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=30, message = "Brand should be from 1 to 30 symbols")
    private String brand;

    @Size(min=1, max=30, message = "Model should be from 1 to 30 symbols")
    private String model;

    @NotNull
    @Min(value = 1800, message = "Year must be more than 1800")
    @Max(value = 2022, message = "Year must be less than 2023")
    private int year;

    @NotNull
    @Min(value = 100, message = "Cost must be more than 100")
    private float cost;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
