package com.ertugrul.mypetclinic.services;

import com.ertugrul.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
