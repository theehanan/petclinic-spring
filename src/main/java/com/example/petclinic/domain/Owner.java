package com.example.petclinic.domain;

import com.example.petclinic.entity.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends Person {
    @Column(name = "address")
    @NotEmpty
    private String address;
    @Column(name = "phonenumber")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        if (!pet.isNew())
            getPets().add(pet);
        pet.setOwner(this);
    }
}
