package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationDTO;
import com.alkemy.ong.dto.OrganizationUpdateDTO;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.mapper.OrganizationMapper;
<<<<<<< HEAD
import com.alkemy.ong.model.Activity;
=======
import com.alkemy.ong.mapper.SlideMapper;
>>>>>>> develop
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.model.Slides;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private SlidesRepository slidesRepository;

    @Autowired
    private SlideMapper slidesMapper;

    @Override
    @Transactional
    public OrganizationDTO addOrganization(OrganizationDTO organizationDto) {

        Organization organization = organizationMapper.organizationDto2Entity(organizationDto);
        Organization savedEntity = organizationRepository.save(organization);
        return organizationMapper.organizationEntity2DTO(savedEntity);

    }

    @Transactional(readOnly = true)
    @Override
    public OrganizationDTO getOrg() {

        Optional<Organization> org = organizationRepository.findAll().stream().findFirst();

        if (!org.isPresent()) {
            throw new NotFoundException("The organization ins't exist");
        }

        List<Slides> slides = slidesRepository.findAll();
        List<SlidesDTO> slidesDTOS = slides.stream().map(s -> slidesMapper.entitySlides2SlidesDto(s)).collect(Collectors.toList());

        OrganizationDTO orgDTO = organizationMapper.organizationEntity2DTOSlides(org.get(), slidesDTOS);

        return orgDTO;

    }

    @Override
    public Organization updateOrganizationDto(OrganizationUpdateDTO orgUpdate) throws NotFoundException {
        Optional<Organization> org = organizationRepository.findById(orgUpdate.getId());

        if (org.isEmpty()) {
            throw new NotFoundException("Organization id does not exist");
        } else {
            return organizationMapper.organizationUpdateDTO2Entity(orgUpdate, org.get());
        }
    }

    @Override
    public void updateOrganization(Organization org) {
        organizationRepository.save(org);
<<<<<<< HEAD
       }

    @Transactional
    @Override
    public OrganizationUpdateDTO updateId(Long id, OrganizationUpdateDTO organizationDTO) {
        Optional<Organization> entity = organizationRepository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("Organization with id provided not found");
        }
        this.organizationMapper.organizationEntityRefreshValues(entity.get(), organizationDTO);
        return this.organizationMapper.organizationEntityUpdateToDTO(organizationRepository.save(entity.get()));
    }


=======
    }
>>>>>>> develop
}
