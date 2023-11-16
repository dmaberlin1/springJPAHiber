package com.dmadev.springJPAHiber.models;

import jakarta.persistence.*;

@Entity
@Table(name="IdenticalCode")
public class IdenticalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name="code_number")
    private int codeNumber;

    public IdenticalCode(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    public IdenticalCode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }
}
