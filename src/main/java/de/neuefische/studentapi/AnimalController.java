package de.neuefische.studentapi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {


    private final AnimalService animalService;

    @GetMapping()

    public List<ApiAnimal> getAnimals(){  // meisten mit DTO. APIAnimal ist wie unsere DTO
        List<Animal> animals= animalService.getAllAnimals();
        return animals.stream()
                .map(animal ->new ApiAnimal(animal.id(), animal.name(), animal.age()))
                .toList();

        //return animalService.getAllAnimals();
    }

    @PostMapping()

    public Animal createAnimal(@RequestBody Animal animal){
        Animal newanimal = new Animal(UUID.randomUUID().toString(), animal.name(), animal.age(),200);
        return animalService.saveAnimal(newanimal);
    }

    /*@PutMapping("/{id}")
    public Animal updateAnimal(@RequestBody UUID uuid, Animal animal){


    }*/
}
