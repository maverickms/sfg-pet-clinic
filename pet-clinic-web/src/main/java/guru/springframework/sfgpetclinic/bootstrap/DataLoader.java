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

        Owner rahul = new Owner();
        rahul.setFirstName("Rahul");
        rahul.setLastName("Dravid");
        rahul.setAddress("121 Firenze Terrace");
        rahul.setCity("San Jose");
        rahul.setTelephone("213123123");

        Pet rahulsPet = new Pet();
        rahulsPet.setPetType(savedDogPetType);
        rahulsPet.setName("Tillu");
        rahulsPet.setBirthDate(LocalDate.now());
        rahulsPet.setOwner(rahul);
        rahul.getPets().add(rahulsPet);

        ownerService.save(rahul);

        Owner viru = new Owner();
        viru.setFirstName("Virendra");
        viru.setLastName("Sehwag");
        viru.setAddress("333 Susa Terrace");
        viru.setCity("Union City");
        viru.setTelephone("112113114");

        Pet virusPet = new Pet();
        virusPet.setPetType(savedDogPetType);
        virusPet.setName("Dhamaka");
        virusPet.setBirthDate(LocalDate.now());
        virusPet.setOwner(viru);
        viru.getPets().add(virusPet);

        ownerService.save(viru);

        Owner roger = new Owner();
        roger.setFirstName("Roger");
        roger.setLastName("Federer");
        roger.setAddress("555 Via Lucca");
        roger.setCity("Newark");
        roger.setTelephone("2231234122");

        Pet rogersPet = new Pet();
        rogersPet.setPetType(savedCatPetType);
        rogersPet.setName("Ace");
        rogersPet.setBirthDate(LocalDate.now());
        rogersPet.setOwner(roger);
        roger.getPets().add(rogersPet);

        ownerService.save(roger);

        Owner rafa = new Owner();
        rafa.setFirstName("Rafael");
        rafa.setLastName("Nadal");
        rafa.setAddress("777 North 1st Street");
        rafa.setCity("San Jose");
        rafa.setTelephone("4123123155");

        Pet rafasPet = new Pet();
        rafasPet.setPetType(cat);
        rafasPet.setName("Raka");
        rafasPet.setBirthDate(LocalDate.now());
        rafasPet.setOwner(rafa);
        rafa.getPets().add(rafasPet);

        ownerService.save(rafa);

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

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(rafasPet);
        catVisit.setDescription("Sneezy Cat");
        visitService.save(catVisit);
        System.out.println("Loaded Visits ..");
    }
}
