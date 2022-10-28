package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=30, message = "Name should be from 1 to 30 symbols")
    private String name;

    @Size(min=1, max=30, message = "Surname should be from 1 to 30 symbols")
    private String surname;

    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date shouldnt be empty")
    private Date dateOfBirth;

    @Min(value = 10, message = "Salary must be more than 10")
    private float salary;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Phone> phones = new ArrayList<>();

}
