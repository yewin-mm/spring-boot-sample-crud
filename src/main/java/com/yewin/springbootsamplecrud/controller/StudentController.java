package com.yewin.springbootsamplecrud.controller;

import com.yewin.springbootsamplecrud.model.entity.Student;
import com.yewin.springbootsamplecrud.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Ye Win.
 * @CreatedDate 10/03/2019.
 * @Description This class is to implement api endpoint which can manage data from the Outside or to the Outside as response.
 */

@RestController // this annotation '@' RestController is declare to spring framework that class will work as the controller layer (destination point or entrance for outside application)
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class); // here we don't use System.out.println() and we will use this logger for logging.

    @Autowired
    StudentService studentService; // here we need to declare this object which will do for business logic by Injection with @Autowired annotation which provide by Spring Framework.


    @PostMapping("/saveStudent") // we use http Post method to save student.
    public ResponseEntity saveStudent(@RequestParam String studentId, @RequestParam String studentName, @RequestParam String phoneNo,
                                           @RequestParam String address, @RequestParam String currentEduYear){ // we request with request param, so, need to add data from with request param (?fieldname=value) follow by api link when calling this api.

        logger.info("==================== Start save student method!!! ===================="); // we use logger instead of System.out.println().

        logger.info("Request - studentId: {}, studentName: {}, phone no: {}, address: {}, currentEduYear: {}", studentId, studentName, phoneNo, address, currentEduYear);

        // declare response entity object for response,
        // here we don't create/initialize object by adding like ResponseEntity responseEntity = new ResponseEntity();
        // we will create/initialize that variable in below.
        ResponseEntity responseEntity;

        try{

            if(studentId != null && !studentId.trim().equals("") && studentName != null && !studentName.trim().equals("") &&
                address != null && !address.trim().equals("") && currentEduYear != null && !currentEduYear.trim().equals(""))
            {

                String message = studentService.saveStudent(studentId, studentName, phoneNo, address, currentEduYear); // call and get return value from student service class
                responseEntity = new ResponseEntity(message, HttpStatus.OK); // create/initialize responseEntity variable.
            }
            else {
                responseEntity = new ResponseEntity("Value is null or empty. Please type all value.", HttpStatus.NOT_FOUND); // create with status not found (404).
            }


        }catch (Exception e){ // we need to catch error by try and catch, because there can be error when saving into db (eg. can't connect to db, or others error or etc..)
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR); // return general error.
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End save student method!!! ====================");

        return responseEntity;
    }


    @GetMapping("/getAllStudent") // we use http Get method to get all student.
    public ResponseEntity getAllStudent(){ // get all student request no parameter

        logger.info("==================== Start getAllStudent method!!! ====================");

        // declare response entity object for response,
        // here we don't create/initialize object by adding like ResponseEntity responseEntity = new ResponseEntity();
        // we will create/initialize that variable in below.
        ResponseEntity responseEntity;

        try{

            List<Student> studentList = studentService.getAllStudent();// call and get return value from student service class
            responseEntity = new ResponseEntity(studentList, HttpStatus.OK); // create/initialize responseEntity variable.

        }catch (Exception e){ // we need to catch error by try and catch, because there can be error when saving into db (eg. can't connect to db, or others error or etc..)
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR); // return general error.
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End getAllStudent method!!! ====================");

        return responseEntity;
    }

    @GetMapping("/findById/{id}") // we use http Get method to get student by id and use pathvariable to request
    public ResponseEntity findById(@PathVariable long id){ // need @PathVariable to bind with above @GetMapping parameter {id}, so, need to add data follow by api link when calling this api.

        logger.info("==================== Start findById method!!! ====================");

        ResponseEntity responseEntity;

        try{
            Student student = studentService.findById(id);

            // check no record found or not because we return back null if no record was found from findById() method of studentService class
            if(student == null ){
                String msg = "There is no record found in database by input id: "+id;
                responseEntity = new ResponseEntity(msg, HttpStatus.OK);
            }else {
                responseEntity = new ResponseEntity(student, HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End findById method!!! ====================");

        return responseEntity;
    }

    @GetMapping("/findByStudentId/{studentId}") // we use http Get method to get student by studentId and use pathvariable to request
    public ResponseEntity findByStudentId(@PathVariable String studentId){ // need @PathVariable to bind with above @GetMapping parameter {studentId}, so, need to add data follow by api link when calling this api.

        logger.info("==================== Start findByStudentId method!!! ====================");

        ResponseEntity responseEntity;

        try{

            List<Student> studentList = studentService.findByStudentId(studentId);

            // here we can check no record found by condition eg. if(studentList.isEmpty())
            // and can return back customize response message like above find by Id method.

            responseEntity = new ResponseEntity(studentList, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End findByStudentId method!!! ====================");

        return responseEntity;
    }

    @GetMapping("/findByStudentName/{studentName}") // we use http Get method to get student by studentName and use pathvariable to request
    public ResponseEntity findByStudentName(@PathVariable String studentName){ // need @PathVariable to bind with above @GetMapping parameter {studentName}, so, need to add data follow by api link when calling this api.

        logger.info("==================== Start findByStudentName method!!! ====================");

        ResponseEntity responseEntity;

        try{

            List<Student> studentList = studentService.findByStudentName(studentName);

            // here we can check no record found by condition eg. if(studentList.isEmpty())
            // and can return back customize response message like above find by Id method.

            responseEntity = new ResponseEntity(studentList, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End findByStudentName method!!! ====================");

        return responseEntity;
    }

    @PostMapping("/updateStudent") // we use http Post method to update student, we can use http PUT method too.
    public ResponseEntity updateStudent(@RequestBody Student student){ // we will request with request body to update student, so, need to add data from body when calling this api.

        logger.info("==================== Start updateStudent method!!! ====================");


        // here we don't do try catch and try catch already did in service class and below code can't got error. So, we will remove that.

        String message = studentService.updateStudent(student); // call method and get return value from student service class.
        ResponseEntity responseEntity = new ResponseEntity(message, HttpStatus.OK); // declare and create/initialize responseEntity variable

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End updateStudent method!!! ====================");

        return responseEntity;
    }

    @GetMapping("/deleteById/{id}") // we use http Get method (we can use http DELETE method too) to delete student by id and use pathvariable to request.
    public ResponseEntity deleteById(@PathVariable long id){ // need @PathVariable to bind with above @GetMapping parameter {id}, so, need to add data follow by api link when calling this api.

        logger.info("==================== Start deleteById method!!! ====================");

        ResponseEntity responseEntity;

        try{

            String message = studentService.deleteById(id);
            responseEntity = new ResponseEntity(message, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity("Something went wrong. Please contact to your administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("Response- body: {}, status: {}", responseEntity.getBody(), responseEntity.getStatusCode());
        logger.info("==================== End deleteById method!!! ====================");

        return responseEntity;
    }


}
