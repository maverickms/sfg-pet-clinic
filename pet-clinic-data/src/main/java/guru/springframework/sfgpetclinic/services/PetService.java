package guru.springframework.sfgpetclinic.services;


import guru.springframework.sfgpetclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long Id);
    Set<Pet> findAll();
    Pet save(Pet pet);

}
