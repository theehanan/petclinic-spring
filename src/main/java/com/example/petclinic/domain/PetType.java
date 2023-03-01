package com.example.petclinic.domain;

import com.example.petclinic.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "type")
public class PetType extends NamedEntity {}
