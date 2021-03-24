package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRopository;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRopository petRopository;

    public PetSDJpaService(PetRopository petRopository) {
        this.petRopository = petRopository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRopository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRopository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRopository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRopository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRopository.deleteById(aLong);
    }
}
