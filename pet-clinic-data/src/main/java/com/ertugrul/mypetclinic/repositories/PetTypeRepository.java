package com.ertugrul.mypetclinic.repositories;

import com.ertugrul.mypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
