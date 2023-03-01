package com.example.petclinic.domain;

import com.example.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetRepository petRepository;
    @Autowired
    public PetTypeFormatter(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = this.petRepository.findPetTypes();
        for (PetType type: petTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
