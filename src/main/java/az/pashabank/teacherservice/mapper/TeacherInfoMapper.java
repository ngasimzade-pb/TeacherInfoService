package az.pashabank.teacherservice.mapper;

import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import az.pashabank.teacherservice.model.dto.TeacherInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/
@Mapper
public abstract class TeacherInfoMapper {

    public abstract TeacherEntity teacherInfoDtoToTeacherEntity(TeacherInfoDto teacherInfoDto, Long code);

    public abstract TeacherInfoDto teacherEntityToTeacherInfoDto(TeacherEntity teacherEntity);

    public abstract List<TeacherInfoDto> teacherEntitiesToTeacherInfoDtos(List<TeacherEntity> teacherEntities);

    public abstract void updateTeacherInfoFromDto(TeacherInfoDto teacherInfoDto, @MappingTarget TeacherEntity teacherEntity);

}

