package ru.komarov.springmvchiber.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min=2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min=2, max = 30, message = "Lastname should be between 2 and 30 characters")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    public User(long id, String name, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }
}
