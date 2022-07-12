package az.pashabank.teacherservice.mapper;

import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import az.pashabank.teacherservice.model.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/
@Mapper
public abstract class TeacherMapper {

    public abstract TeacherEntity teacherDtoToTeacherEntity(TeacherDto teacherDto, Long code);

    public abstract TeacherDto teacherEntityToTeacherDto(TeacherEntity teacherEntity);

    public abstract List<TeacherDto> teacherEntitiesToTeacherDtos(List<TeacherEntity> teacherEntities);

    public abstract void updateTeacherFromDto(TeacherDto teacherDto, @MappingTarget TeacherEntity teacherEntity);

}

