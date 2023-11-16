package com.dmadev.springJPAHiber.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name="Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min=2,max=30,message = "Name should be between 2 and 30 characters")
    @Column(name="name")
    private String name;

    @Min(value = 0,message = "Age should be greater than 0")
    @Column(name="age")
    private int age;

    @Column(name="email")
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name="language")
    private Lang language;


    @OneToMany(mappedBy = "owner")
    private List<Item>items;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    @OneToOne(mappedBy = "person")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private IdenticalCode identicalCode;

    public Person(String name, int age, Gender gender, Lang language) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.language = language;
    }

    public Person() {
    }

    public String getEmail() {
        return email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public IdenticalCode getIdenticalCode() {
        return identicalCode;
    }

    public void setIdenticalCode(IdenticalCode identicalCode) {
        this.identicalCode = identicalCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang language) {
        this.language = language;
    }
}
