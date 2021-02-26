package guru.springframework.sfgpetclinic.service;


import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetSevice {
    Vet findById(long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
