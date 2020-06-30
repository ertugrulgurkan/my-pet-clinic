package com.ertugrul.mypetclinic.services.springdatajpa;

import com.ertugrul.mypetclinic.model.Vet;
import com.ertugrul.mypetclinic.repositories.OwnerRepository;
import com.ertugrul.mypetclinic.repositories.PetRepository;
import com.ertugrul.mypetclinic.repositories.PetTypeRepository;
import com.ertugrul.mypetclinic.repositories.VetRepository;
import com.ertugrul.mypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public VetSDJpaService(VetRepository vetRepository, OwnerRepository ownerRepository,
                           PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.vetRepository = vetRepository;
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
