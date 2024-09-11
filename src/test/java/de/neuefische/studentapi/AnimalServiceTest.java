package de.neuefische.studentapi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnimalServiceTest {
    private final AnimalRepository animalRepository = mock(AnimalRepository.class);
    private final AnimalService animalService=new AnimalService(animalRepository);

    @Test
    void getAllAnimals() {

        Animal animal = new Animal("1","max" ,5,300);
        animalRepository.save(animal);

        when(animalRepository.findAll()).thenReturn(List.of(animal));
        List<Animal> animals=animalService.getAllAnimals();
        assertEquals(animal,animals.get(0));
    }

    @Test
    void saveAnimal() {
        Animal animal = new Animal(UUID.randomUUID().toString(),"Eric",5,541);
        animalRepository.save(animal);

        when(animalRepository.save(any(Animal.class))).thenReturn(animal);
        Animal savedAnimal=animalService.saveAnimal(animal);
        assertEquals(animal,savedAnimal);
    }
}