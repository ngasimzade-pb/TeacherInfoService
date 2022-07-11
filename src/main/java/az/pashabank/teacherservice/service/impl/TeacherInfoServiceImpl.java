package az.pashabank.teacherservice.service.impl;

import az.pashabank.teacherservice.dao.entity.Message;
import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import az.pashabank.teacherservice.dao.repository.TeacherInfoRepository;
import az.pashabank.teacherservice.mapper.impl.TeacherInfoMapperImpl;
import az.pashabank.teacherservice.model.dto.TeacherInfoDto;
import az.pashabank.teacherservice.service.TeacherInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    public TeacherInfoRepository teacherInfoRepository;
    public TeacherInfoMapperImpl teacherInfoMapper;

    private final String SIGN = "@";
    private final String COUNTRY_CODE = ".az";

    public TeacherInfoServiceImpl(TeacherInfoRepository teacherInfoRepository, TeacherInfoMapperImpl teacherInfoMapper) {
        this.teacherInfoRepository = teacherInfoRepository;
        this.teacherInfoMapper = teacherInfoMapper;
    }

    @Override
    public TeacherInfoDto save(TeacherInfoDto teacherInfoDto) {

        Long code = generateTeacherCode(teacherInfoDto);
        teacherInfoDto.setEmail(generateMail(teacherInfoDto, code));

        TeacherEntity teacherEntity = teacherInfoMapper.teacherInfoDtoToTeacherEntity(teacherInfoDto, code);
        teacherEntity = teacherInfoRepository.save(teacherEntity);

        return teacherInfoMapper.teacherEntityToTeacherInfoDto(teacherEntity);
    }

    @Override
    public Long generateTeacherCode(TeacherInfoDto teacherInfoDto) {

        return ThreadLocalRandom.current().nextLong(0, 999999);
    }

    @Override
    public String generateMail(TeacherInfoDto teacherInfoDto, Long teacherCode) {

        String mail = String.valueOf(teacherInfoDto.getName().toLowerCase().charAt(0))
                                        .concat(teacherInfoDto.getSurname().toLowerCase()
                                        .concat(String.valueOf(teacherCode))
                                        .concat(SIGN)
                                        .concat(teacherInfoDto.getInstitution()).concat(COUNTRY_CODE));

        teacherInfoDto.setEmail(mail);

        return teacherInfoDto.getEmail();
    }

    @Override
    public List<TeacherInfoDto> getAll() {

        return teacherInfoRepository.findAll().stream()
                .map(teacherInfoMapper::teacherEntityToTeacherInfoDto)
                .collect(Collectors.toList());
    }

    @Override
    public Message deleteById(Long id) {
        teacherInfoRepository.deleteById(id);
        return new Message("User with {id = " + id + "} successfully deleted!");
    }

    @Override
    public TeacherInfoDto findByTeacherCode(Long code) {

        TeacherEntity entity = teacherInfoRepository.findByCode(code);

        return teacherInfoMapper.teacherEntityToTeacherInfoDto(entity);
    }

    @Override
    public TeacherInfoDto updateTeacherInfo(TeacherInfoDto teacherInfoDto, Long code) {
        teacherInfoDto.setEmail(generateMail(teacherInfoDto, code));

        TeacherEntity teacherEntity = teacherInfoMapper.teacherInfoDtoToTeacherEntity(findByTeacherCode(code), code);
        teacherEntity.setId(findTeacherId(code));

        teacherInfoMapper.updateTeacherInfoFromDto(teacherInfoDto, teacherEntity);
        teacherInfoRepository.save(teacherEntity);

        return teacherInfoDto;
    }

    @Override
    public Long findTeacherId(Long code) {
        return teacherInfoRepository.findByCode(code).getId();
    }
}
