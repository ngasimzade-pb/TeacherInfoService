package az.pashabank.teacherservice.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Nabat Gasimzada
 * @since : 7/10/2022, Sun
 **/

@Table(name = "journeyed_account")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    // TODO: 7/10/2022      --ADD USER-LOGIC TO PROJECT

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "code", nullable = false)
    private Long code;

    @Column(name = "pcode", nullable = false)
    private String promotionCode;

    @Column(name = "created_at", nullable = false)
    private String createdAt;
}
