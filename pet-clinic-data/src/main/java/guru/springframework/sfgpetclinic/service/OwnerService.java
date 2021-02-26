package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findLastName (String lastname);

    Owner findById(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
