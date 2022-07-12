package az.pashabank.teacherservice.controller;

import az.pashabank.teacherservice.dao.entity.Message;
import az.pashabank.teacherservice.model.dto.TeacherDto;
import az.pashabank.teacherservice.service.impl.TeacherInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/12/2022, Tue
 **/
@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    private final TeacherInfoServiceImpl teacherInfoService;

    public TeacherController(TeacherInfoServiceImpl teacherInfoService) {
        this.teacherInfoService = teacherInfoService;
    }

    @PostMapping
    public TeacherDto create(@RequestBody TeacherDto teacherInfoDto) {
        return teacherInfoService.save(teacherInfoDto);
    }

    @GetMapping("/")
    public List<TeacherDto> getAll() {
        return teacherInfoService.getAll();
    }

    @GetMapping("/info/{code}")
    public TeacherDto getTeacherByCode(@PathVariable Long code) {
        return teacherInfoService.findByTeacherCode(code);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Message deleteById(@PathVariable Long id) {
        return teacherInfoService.deleteById(id);
    }


    @PutMapping
    public ResponseEntity<TeacherDto> updateData(@RequestBody Long code,
                                                 TeacherDto teacherInfoDto) {
        var response = teacherInfoService.updateTeacherInfo(teacherInfoDto, code);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
