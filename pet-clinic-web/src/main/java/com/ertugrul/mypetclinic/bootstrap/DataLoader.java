package com.ertugrul.mypetclinic.bootstrap;

import com.ertugrul.mypetclinic.model.*;
import com.ertugrul.mypetclinic.services.OwnerService;
import com.ertugrul.mypetclinic.services.PetTypeService;
import com.ertugrul.mypetclinic.services.SpecialityService;
import com.ertugrul.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");


        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedDentistry = specialityService.save(dentistry);
        petTypeService.save(dog);
        petTypeService.save(cat);

        System.out.println("Loaded PetTypes....");
        Owner o1 = new Owner();
        o1.setFirstName("Ertuğrul");
        o1.setLastName("Gürkan");
        o1.setAddress("123 Çankaya");
        o1.setCity("Ankara");
        o1.setTelephone("1231231234");

        Owner o2 = new Owner();
        o2.setFirstName("Betül");
        o2.setLastName("Çiftçi");
        o2.setAddress("123 Çankaya");
        o2.setCity("Ankara");
        o2.setTelephone("1231231234");

        Pet ourPet = new Pet();
        ourPet.setPetType(dog);
        ourPet.setOwner(o1);
        ourPet.setBirthDate(LocalDate.now());
        ourPet.setName("Rosco");
        o1.getPets().add(ourPet);

        Pet ourCat = new Pet();
        ourCat.setName("Just Cat");
        ourCat.setOwner(o2);
        ourCat.setBirthDate(LocalDate.now());
        ourCat.setPetType(cat);
        o2.getPets().add(ourCat);

        ownerService.save(o1);
        ownerService.save(o2);

        System.out.println("Loaded Owners....");

        Vet v1 = new Vet();
        v1.setFirstName("Eray");
        v1.setLastName("Gürkan");
        v1.getSpecialities().add(savedDentistry);

        Vet v2 = new Vet();
        v2.setFirstName("Arda");
        v2.setLastName("Semerci");
        v2.getSpecialities().add(savedSurgery);

        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vets....");
    }
}
