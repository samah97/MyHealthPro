package com.sd.myhealthpro.speciality.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "speciality")
@Getter
@Setter
public class SpecialityEntity {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
