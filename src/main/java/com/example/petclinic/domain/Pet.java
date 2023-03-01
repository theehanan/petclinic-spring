package com.example.petclinic.domain;

import com.example.petclinic.entity.NamedEntity;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

// Id AND Name are being implemented in entity package.
// We don't need to use define them here as Pet extends those packages
@Entity
@Table(name = "pet")
public class Pet extends NamedEntity {
    @Column(name = "dateofbirth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet_id", fetch = FetchType.EAGER)
    private Set<Visit> visitSet;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public void addVisit(Visit visit) {
        this.visitSet.add(visit);
    }
}
