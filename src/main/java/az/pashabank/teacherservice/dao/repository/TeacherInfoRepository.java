package az.pashabank.teacherservice.dao.repository;

import az.pashabank.teacherservice.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Nabat Gasimzada
 * @since : 7/9/2022, Sat
 **/

@Repository
public interface TeacherInfoRepository extends JpaRepository<TeacherEntity, Long>, CrudRepository<TeacherEntity, Long>{

    TeacherEntity findByCode(Long teacherCode);
}
