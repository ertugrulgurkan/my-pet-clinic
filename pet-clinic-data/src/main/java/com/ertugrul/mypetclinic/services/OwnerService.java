package com.ertugrul.mypetclinic.services;

import com.ertugrul.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
