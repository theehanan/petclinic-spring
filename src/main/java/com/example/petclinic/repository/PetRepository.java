package com.example.petclinic.repository;

import com.example.petclinic.domain.Pet;
import com.example.petclinic.domain.PetType;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PetRepository extends Repository<Pet, Integer> {
    @Transactional(readOnly = true)
    List<PetType> findPetTypes();

    @Transactional(readOnly = true)
    Pet findById(Integer id);

    void save(Pet pet);
}
