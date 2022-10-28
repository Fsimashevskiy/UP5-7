package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=30, message = "Country should be from 1 to 30 symbols")
    private String country;

    @Size(min=1, max=30, message = "City should be from 1 to 30 symbols")
    private String city;

    @Size(min=1, max=30, message = "Street should be from 1 to 30 symbols")
    private String street;

    @Size(min=1, max=10, message = "House should be from 1 to 10 symbols")
    private String house;

    @OneToOne(mappedBy = "address")
    private Client client;
}
