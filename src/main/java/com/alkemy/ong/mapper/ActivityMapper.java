package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public Activity activityDTOtoEntity(ActivityDTO dto) {
        Activity entity = new Activity();
        entity.setName(dto.getName());
        entity.setContent(dto.getContent());
        entity.setImage(dto.getImage());
        return entity;
    }

    public ActivityDTO activityEntityToDTO(Activity entity) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setContent(entity.getContent());
        dto.setImage(entity.getImage());
        return dto;
    }
}
