package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.Owner;
import guru.springframework.sfgpetclinic.models.Pet;
import guru.springframework.sfgpetclinic.models.PetType;
import guru.springframework.sfgpetclinic.models.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Rahul");
        owner1.setLastName("Dravid");
        owner1.setAddress("121 Firenze Terrace");
        owner1.setCity("San Jose");
        owner1.setTelephone("213123123");

        Pet rahulsPet = new Pet();
        rahulsPet.setPetType(savedDogPetType);
        rahulsPet.setName("Tillu");
        rahulsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(rahulsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Virendra");
        owner2.setLastName("Sehwag");
        owner2.setAddress("333 Susa Terrace");
        owner2.setCity("Union City");
        owner2.setTelephone("112113114");

        Pet virusPet = new Pet();
        virusPet.setPetType(savedDogPetType);
        virusPet.setName("Dhamaka");
        virusPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(virusPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Roger");
        owner3.setLastName("Federer");
        owner3.setAddress("555 Via Lucca");
        owner3.setCity("Newark");
        owner3.setTelephone("2231234122");

        Pet rogersPet = new Pet();
        rogersPet.setPetType(savedCatPetType);
        rogersPet.setName("Ace");
        rogersPet.setBirthDate(LocalDate.now());
        owner3.getPets().add(rogersPet);

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Rafael");
        owner4.setLastName("Nadal");
        owner4.setAddress("777 North 1st Street");
        owner4.setCity("San Jose");
        owner4.setTelephone("4123123155");

        Pet rafasPet = new Pet();
        rafasPet.setPetType(cat);
        rafasPet.setName("Raka");
        rafasPet.setBirthDate(LocalDate.now());
        owner4.getPets().add(rogersPet);

        ownerService.save(owner4);

        System.out.println("Loaded Owners ..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Shambhu");
        vet1.setLastName("Nath");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Chiraunjee");
        vet2.setLastName("Lal");

        vetService.save(vet2);

        System.out.println("Loaded Vets ..");
    }
}
