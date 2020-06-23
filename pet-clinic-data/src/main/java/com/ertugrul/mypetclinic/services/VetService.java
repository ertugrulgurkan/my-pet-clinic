package com.ertugrul.mypetclinic.services;

import com.ertugrul.mypetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
