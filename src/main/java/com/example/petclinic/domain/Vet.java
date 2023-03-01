package com.example.petclinic.domain;

import com.example.petclinic.entity.Person;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "vet")
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "speciality", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialitySet;

    public Set<Speciality> getSpecialitySet() {
        return specialitySet;
    }

    public void setSpecialitySet(Set<Speciality> specialitySet) {
        this.specialitySet = specialitySet;
    }

    public void addSpeciality(Speciality speciality) {
        this.specialitySet.add(speciality);
    }
}
