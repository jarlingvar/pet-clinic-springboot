package ru.springboot.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.springboot.petclinic.model.Owner;
import ru.springboot.petclinic.model.PetType;
import ru.springboot.petclinic.model.Vet;
import ru.springboot.petclinic.services.OwnerService;
import ru.springboot.petclinic.services.PetTypeService;
import ru.springboot.petclinic.services.VetService;


//component annotation means that spring framework will automatically detect it
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Igor");
        owner1.setLastName("Kurosaki");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kuchi");
        owner2.setLastName("Mushi");

        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
