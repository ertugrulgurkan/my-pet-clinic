package com.ertugrul.mypetclinic.repositories;

import com.ertugrul.mypetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
}
