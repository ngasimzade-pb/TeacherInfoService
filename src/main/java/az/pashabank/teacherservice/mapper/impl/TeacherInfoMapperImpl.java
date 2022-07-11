package az.pashabank.teacherservice.mapper.impl;

import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import az.pashabank.teacherservice.mapper.TeacherInfoMapper;
import az.pashabank.teacherservice.model.dto.TeacherInfoDto;
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
public class TeacherInfoMapperImpl extends TeacherInfoMapper {

    public TeacherInfoMapperImpl() {
    }

    @Override
    public TeacherEntity teacherInfoDtoToTeacherEntity(TeacherInfoDto teacherInfoDto, Long code) {
        if (code == null) {
            return null;
        }

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setCode(code);
        teacherEntity.setName(teacherInfoDto.getName());
        teacherEntity.setSurname(teacherInfoDto.getSurname());
        teacherEntity.setInstitution(teacherInfoDto.getInstitution());
        teacherEntity.setEmail(teacherInfoDto.getEmail());

        return teacherEntity;
    }

    @Override
    public TeacherInfoDto teacherEntityToTeacherInfoDto(TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return null;
        }

        TeacherInfoDto teacherInfoDto = new TeacherInfoDto();
        teacherInfoDto.setName(teacherEntity.getName());
        teacherInfoDto.setSurname(teacherEntity.getSurname());
        teacherInfoDto.setInstitution(teacherEntity.getInstitution());
        teacherInfoDto.setEmail(teacherEntity.getEmail());

        return teacherInfoDto;
    }

    @Override
    public List<TeacherInfoDto> teacherEntitiesToTeacherInfoDtos(List<TeacherEntity> teacherEntities) {
        if (teacherEntities == null) {
            return null;
        }

        List<TeacherInfoDto> teacherInfoDtos = new ArrayList<>(teacherEntities.size());
        for (TeacherEntity teacherEntity : teacherEntities) {
            teacherInfoDtos.add(teacherEntityToTeacherInfoDto(teacherEntity));
        }

        return teacherInfoDtos;
    }

    @Override
    public void updateTeacherInfoFromDto(TeacherInfoDto teacherInfoDto, TeacherEntity teacherEntity) {
        teacherEntity.setName(teacherInfoDto.getName());
        teacherEntity.setSurname(teacherInfoDto.getSurname());
        teacherEntity.setInstitution(teacherInfoDto.getInstitution());
        teacherEntity.setEmail(teacherInfoDto.getEmail());
    }
}
