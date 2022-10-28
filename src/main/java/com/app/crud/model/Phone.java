package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "phones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=30, message = "Brand should be from 1 to 30 symbols")
    private String brand;

    @Size(min=1, max=30, message = "Model should be from 1 to 30 symbols")
    private String model;

    @Min(value = 100, message = "Cost must be more than 100")
    private int cost;

    @Size(min=1, max=30, message = "Colour should be from 1 to 30 symbols")
    private String colour;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
