package az.pashabank.teacherservice.service;

import az.pashabank.teacherservice.dao.entity.Message;
import az.pashabank.teacherservice.model.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Service
public interface TeacherInfoService {

    TeacherDto save(TeacherDto teacherInfoDto);

    Long generateTeacherCode(TeacherDto teacherInfoDto);

    String generateMail(TeacherDto teacherInfoDto, Long teacherCode);

    List<TeacherDto> getAll();

    Message deleteById(Long id);

    TeacherDto findByTeacherCode(Long teacherCode);

    TeacherDto updateTeacherInfo(TeacherDto teacherInfoDto, Long code);

    Long findTeacherId(Long code);
}
