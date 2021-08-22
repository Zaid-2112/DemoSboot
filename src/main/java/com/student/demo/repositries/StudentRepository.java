package com.student.demo.repositries;

import com.student.demo.pojo.StudentPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo, Long> {

    List<StudentPojo> findByDob(Date dob);
    List<StudentPojo> findAll();

}
