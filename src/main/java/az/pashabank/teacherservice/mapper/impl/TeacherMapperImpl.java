package az.pashabank.teacherservice.mapper.impl;

import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import az.pashabank.teacherservice.mapper.TeacherMapper;
import az.pashabank.teacherservice.model.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/10/2022, Sun
 **/

@Mapper
@Component("customTeacherInfoMapperImpl")
@Primary
public class TeacherMapperImpl extends TeacherMapper {

    public TeacherMapperImpl() {
    }

    @Override
    public TeacherEntity teacherDtoToTeacherEntity(TeacherDto teacherDto, Long code) {
        if (code == null) {
            return null;
        }

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setCode(code);
        teacherEntity.setName(teacherDto.getName());
        teacherEntity.setSurname(teacherDto.getSurname());
        teacherEntity.setInstitution(teacherDto.getInstitution());
        teacherEntity.setEmail(teacherDto.getEmail());

        return teacherEntity;
    }

    @Override
    public TeacherDto teacherEntityToTeacherDto(TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName(teacherEntity.getName());
        teacherDto.setSurname(teacherEntity.getSurname());
        teacherDto.setInstitution(teacherEntity.getInstitution());
        teacherDto.setEmail(teacherEntity.getEmail());

        return teacherDto;
    }

    @Override
    public List<TeacherDto> teacherEntitiesToTeacherDtos(List<TeacherEntity> teacherEntities) {
        if (teacherEntities == null) {
            return null;
        }

        List<TeacherDto> teacherDtos = new ArrayList<>(teacherEntities.size());
        for (TeacherEntity teacherEntity : teacherEntities) {
            teacherDtos.add(teacherEntityToTeacherDto(teacherEntity));
        }

        return teacherDtos;
    }

    @Override
    public void updateTeacherFromDto(TeacherDto teacherDto, TeacherEntity teacherEntity) {
        teacherEntity.setName(teacherDto.getName());
        teacherEntity.setSurname(teacherDto.getSurname());
        teacherEntity.setInstitution(teacherDto.getInstitution());
        teacherEntity.setEmail(teacherDto.getEmail());
    }
}
