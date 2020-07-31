package com.ertugrul.mypetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

}
