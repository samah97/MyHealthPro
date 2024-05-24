package com.sd.myhealthpro.professional.service;


import com.sd.myhealthpro.professional.dto.ProfessionalDTO;
import com.sd.myhealthpro.professional.entity.ProfessionalEntity;
import com.sd.myhealthpro.professional.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ModelMapper modelMapper = new ModelMapper();;

    long create(ProfessionalDTO dto){
        ProfessionalEntity professional = modelMapper.map(dto, ProfessionalEntity.class);
        professional = professionalRepository.save(professional);
        return professional.getId();
    }

}
