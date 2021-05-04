package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    String lastName = "abc";
    Long idOfOwner = 1L;
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnedOwner;
    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().lastName(lastName).id(idOfOwner).build();

    }

    @Test
    void findByLastName() {
        Owner createOwner = Owner.builder().id(1L).lastName(lastName).build();

        when(ownerRepository.findByLastName(any())).thenReturn(createOwner);
        Owner smith = service.findByLastName(lastName);
        assertEquals(lastName,smith.getLastName());
        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> resultOwnersSet = service.findAll();
        assertNotNull(resultOwnersSet);
        assertEquals(resultOwnersSet.size(), returnOwnersSet.size());
        assertEquals(2, returnOwnersSet.size());

    }

    @Test
    void findById() {
        Owner createOwner2 = Owner.builder().id(1L).lastName(lastName).build();
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(createOwner2));
        Owner smith = service.findById(idOfOwner);
        assertEquals(idOfOwner, smith.getId());
    }

    @Test
    void save() {
        Owner createOwner3 = Owner.builder().id(3L).lastName("lastName").build();
        when(ownerRepository.save(any())).thenReturn(createOwner3);
        Owner smith = service.save(createOwner3);
        assertEquals(smith,createOwner3);
    }

    @Test
    void delete() {
       service.delete(returnedOwner);
       verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(idOfOwner);
        verify(ownerRepository).deleteById(anyLong());
        verify(ownerRepository).deleteById(idOfOwner);
    }
}