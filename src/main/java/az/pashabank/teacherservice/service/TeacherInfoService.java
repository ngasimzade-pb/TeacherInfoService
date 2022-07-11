package az.pashabank.teacherservice.service;

import az.pashabank.teacherservice.dao.entity.Message;
import az.pashabank.teacherservice.model.dto.TeacherInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Service
public interface TeacherInfoService {

    TeacherInfoDto save(TeacherInfoDto teacherInfoDto);

    Long generateTeacherCode(TeacherInfoDto teacherInfoDto);

    String generateMail(TeacherInfoDto teacherInfoDto, Long teacherCode);

    List<TeacherInfoDto> getAll();

    Message deleteById(Long id);

    TeacherInfoDto findByTeacherCode(Long teacherCode);

    TeacherInfoDto updateTeacherInfo(TeacherInfoDto teacherInfoDto, Long code);

    Long findTeacherId(Long code);
}
