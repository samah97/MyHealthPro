package com.sd.myhealthpro.professional.entity;


import com.sd.myhealthpro.speciality.entity.SpecialityEntity;
import com.sd.myhealthpro.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "professional")
@Getter
@Setter
public class ProfessionalEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany
            @JoinTable(name = "professional_speciality")
    Set<SpecialityEntity> specialities;

}
