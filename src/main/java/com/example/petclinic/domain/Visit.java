package com.example.petclinic.domain;

import com.example.petclinic.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {
    @Column(name = "visitdate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate visitDate;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private Integer petId;

    public Visit() {
        this.visitDate = LocalDate.now();
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }
}
