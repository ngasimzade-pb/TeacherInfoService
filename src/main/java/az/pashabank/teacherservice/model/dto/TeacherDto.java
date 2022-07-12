package az.pashabank.teacherservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    String name;
    String surname;
    String institution;
    String email;
}
