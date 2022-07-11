package az.pashabank.teacherservice.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Table(name = "tecaher_info_service")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private Long code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "institution", nullable = false)
    private String institution;

    @Column(name = "email", nullable = false)
    private String email;
}
