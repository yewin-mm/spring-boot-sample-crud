package com.yewin.springbootsamplecrud.repository;

import com.yewin.springbootsamplecrud.model.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Ye Win.
 * @CreatedDate 10/03/2019.
 * @Description This class is to implement database operation which will do create, retrieve (select), update, delete.
 */

@Repository // this annotation '@' Repository declare to spring framework that interface will work as database operation.
// Here we will extends JpaRepository to get spring query method features (and etc..)
// And there we need to connect Database Table and Our Entity Class by adding entity class name eg. Student and primary key in parameter.
public interface StudentRepository extends JpaRepository <Student, Long> {



    /**
     * Here we will use JPA query method 'findByStudentId'. and if you want to use with @Query annotation, you can use query like below. You can use with anyways, all are fine.
     *
     * @Query(nativeQuery = true, value = "select * from student where student_id=:sId")
     * List<Student> findByStudentId(@Param("sId") String stuId);
     *
     */
    // method -> findBy follow by the field name (with initial capital letter) which declare in entity class eg. StudentId or StudentName
    // findByStudentId must return with List data type because we are retrieving data with student id instead of id (id is primary key (not duplicate)
    // So, retrieving with id must return only one row and we can declare return type with Student not with List<Student> but here is not retrieving with id.
    // So, we must need to define return type with List<Student>.
    List<Student> findByStudentId(String stuId);




    /**
     * Here we will use JPA query method 'findByStudentName'. and if you want to use with @Query annotation, you can use query like below. You can use with anyways, all are fine.
     *
     * @Query(nativeQuery = true, value = "select * from student where student_name=:name")
     * List<Student> findByStudentName(@Param("name") String stuName);
     *
     */
    // findbyStudentName logic is same with above 'findByStudentId' method and return will be list data type.
    // So, please reference above 'findByStudenId' method comment.
    List<Student> findByStudentName(String stuName);




    /**
     * This is the update query sample and if you don't want to use save method from UserService class to update, you can call this below method to update student. All ways are fine.
     * Here, you can set void return or you can set int datatype return to know how many row are effected (success).
     */

    @Modifying // you need this annotation '@' Modifying when update, that means tell spring framework to this below query is update operation
    @Query(nativeQuery = true, value = "update student set student_id=:stuId, student_name=:stuName, phone_no=:phNo, address=:addr, current_edu_year=:curEduYrs where id=:id")
    void updateStudentById(@Param("id") Long id, @Param("stuId") String studentId, @Param("stuName") String sName, @Param("phNo") String ph, @Param("addr") String addr, @Param("curEduYrs") String curYrs);



    // you can write other query method in below eg. findByAddress, etc... that is up to your application requirement.



}
