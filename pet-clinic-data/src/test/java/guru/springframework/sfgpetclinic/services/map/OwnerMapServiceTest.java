package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

   OwnerMapService ownerMapService;
   final Long ownerID = 1L;
   final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
     Owner owner = ownerMapService.findById(ownerID);
     assertEquals(ownerID,owner.getId());
    }

    @Test
    void save() {
      Long id = 2L;
      Owner owner2= Owner.builder().id(id).build();
      Owner savedOwner = ownerMapService.save(owner2);
      assertEquals(savedOwner,owner2);
      assertEquals(id,savedOwner.getId());
    }


 @Test
 void saveNoId() {
     Owner savedOwner = ownerMapService.save(Owner.builder().build());
     assertNotNull(savedOwner);
     assertNotNull(savedOwner.getId());

 }
    @Test
    void delete(){
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
     ownerMapService.deleteById(ownerID);
     assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
     Owner smith = ownerMapService.findByLastName(lastName);
     assertNotNull(smith);
     assertEquals(lastName,smith.getLastName());
     assertEquals(ownerID,smith.getId());
    }
}