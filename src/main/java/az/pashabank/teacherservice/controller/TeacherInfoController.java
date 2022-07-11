package az.pashabank.teacherservice.controller;

import az.pashabank.teacherservice.dao.entity.Message;
import az.pashabank.teacherservice.model.dto.TeacherInfoDto;
import az.pashabank.teacherservice.service.impl.TeacherInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
public class TeacherInfoController {

    private final TeacherInfoServiceImpl teacherInfoService;

    public TeacherInfoController(TeacherInfoServiceImpl teacherInfoService) {
        this.teacherInfoService = teacherInfoService;
    }

    @PostMapping
    public TeacherInfoDto createAndCollectData(@RequestBody TeacherInfoDto teacherInfoDto) {
        return teacherInfoService.save(teacherInfoDto);
    }

    @GetMapping("/")
    public List<TeacherInfoDto> getAll() {
        return teacherInfoService.getAll();
    }

    @GetMapping("/info/{code}")
    public TeacherInfoDto getTeacherByCode(@PathVariable Long code) {
        return teacherInfoService.findByTeacherCode(code);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Message deleteById(@PathVariable Long id) {
        return teacherInfoService.deleteById(id);
    }


    @PatchMapping("/info/edit/{code}")
    public ResponseEntity<TeacherInfoDto> updateData(@PathVariable Long code,
                                                     @RequestBody TeacherInfoDto teacherInfoDto) {
        var response = teacherInfoService.updateTeacherInfo(teacherInfoDto, code);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
