package com.example.petclinic.domain;

import com.example.petclinic.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name = "speciality")
public class Speciality extends NamedEntity implements Serializable {}
