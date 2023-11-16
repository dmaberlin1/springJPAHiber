package com.dmadev.springJPAHiber.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id") //в таблице Car -person_id в первичной id
    private Person owner;

    @Column(name="model")
    private String model;

    @Column(name = "engine_capacity")
    private int engineCapacity;

    @Column(name = "electric")
    private boolean electric;

    public boolean getElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type_body")
    private TypeBodyCar typeBody;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private ColorCar color;

    public Car() {

    }

    public Car(Person owner, String model, int engineCapacity, boolean electric, TypeBodyCar typeBody, ColorCar color) {
        this.owner = owner;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.electric = electric;
        this.typeBody = typeBody;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (engineCapacity != car.engineCapacity) return false;
        if (electric != car.electric) return false;
        if (!Objects.equals(owner, car.owner)) return false;
        if (!Objects.equals(model, car.model)) return false;
        if (typeBody != car.typeBody) return false;
        return color == car.color;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + engineCapacity;
        result = 31 * result + (electric ? 1 : 0);
        result = 31 * result + (typeBody != null ? typeBody.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }



    public TypeBodyCar getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(TypeBodyCar typeBody) {
        this.typeBody = typeBody;
    }

    public ColorCar getColor() {
        return color;
    }

    public void setColor(ColorCar color) {
        this.color = color;
    }
}
