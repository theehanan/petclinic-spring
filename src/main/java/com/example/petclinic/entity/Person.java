package com.example.petclinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;

@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "firstname")
    @NotEmpty
    private String firstName;
    @Column(name = "lastname")
    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
