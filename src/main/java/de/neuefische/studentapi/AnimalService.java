package de.neuefische.studentapi;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal){
        Animal newAnimal = new Animal(UUID.randomUUID().toString(),animal.name(),animal.age(),300);
        return animalRepository.save(newAnimal);
    }
}
