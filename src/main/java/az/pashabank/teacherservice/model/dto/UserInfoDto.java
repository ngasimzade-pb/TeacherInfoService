package az.pashabank.teacherservice.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Nabat Gasimzada
 * @since : 7/10/2022, Sun
 **/

@Data
public class UserInfoDto {

    // TODO: 7/10/2022      --ADD USER-LOGIC TO PROJECT

    String username;
    String promotionCode;
    LocalDateTime availableUntil;
}
