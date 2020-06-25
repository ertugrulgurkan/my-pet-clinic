package com.ertugrul.mypetclinic.bootstrap;

import com.ertugrul.mypetclinic.model.Owner;
import com.ertugrul.mypetclinic.model.Vet;
import com.ertugrul.mypetclinic.services.OwnerService;
import com.ertugrul.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args){

        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Ertugrul");
        o1.setLastName("Gurkan");

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Betul");
        o2.setLastName("Cıftcı");

        ownerService.save(o1);
        ownerService.save(o2);

        System.out.println("Loaded Owners....");

        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Eray");
        v1.setLastName("Gurkan");

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Arda");
        v2.setLastName("Semerci");

        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vets....");

    }
}
