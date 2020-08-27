package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

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
        rahulsPet.setOwner(owner1);
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
        virusPet.setOwner(owner2);
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
        rogersPet.setOwner(owner3);
        owner3.getPets().add(rogersPet);

        ownerService.save(owner3);

        Visit catVisit = new Visit();
        catVisit.setPet(rogersPet);
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Visits ..");

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
        rafasPet.setOwner(owner4);
        owner4.getPets().add(rogersPet);

        ownerService.save(owner4);

        System.out.println("Loaded Owners ..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Shambhu");
        vet1.setLastName("Nath");
        vet1.getSpecialities().add(radiology);
        vet1.getSpecialities().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Chiraunjee");
        vet2.setLastName("Lal");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets ..");
    }
}
