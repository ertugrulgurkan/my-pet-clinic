package com.ertugrul.mypetclinic.repositories;

import com.ertugrul.mypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
