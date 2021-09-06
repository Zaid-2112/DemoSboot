package com.student.demo.repositries;

import com.student.demo.pojo.College;
import com.student.demo.pojo.StudentPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo, Long> {

    Optional<StudentPojo> findById(@Param("studentId") Long studentId);

    List<StudentPojo> findByDob(@Param("dob")  Date dob);
    List<StudentPojo> findAll();

    @Query("SELECT e FROM StudentPojo e WHERE e.deleted=false")
    List<StudentPojo> getAll();

    //@Query("SELECT e.device_detail_id FROM StudentPojo e WHERE e.deleted=false")
    StudentPojo findByFatherName(String fatherName);

}
