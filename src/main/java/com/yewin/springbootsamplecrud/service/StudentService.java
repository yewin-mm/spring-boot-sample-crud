package com.yewin.springbootsamplecrud.service;

import com.yewin.springbootsamplecrud.model.entity.Student;
import com.yewin.springbootsamplecrud.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Ye Win.
 * @CreatedDate 10/03/2019.
 * @Description This class is to implement Business Logic which will do application requirement logic.
 */

@Service // this annotation '@' Service declare to spring framework that class will do business operation.
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class); // here we don't use System.out.println() and we will use this logger for logging.

    @Autowired
    private StudentRepository studentRepository; // here we need to declare object which will do for Database operation by Injection with @Autowired annotation which provide by Spring Framework.

    // this method is to save (create) student data to database.
    public String saveStudent(String studentId, String studentName, String phoneNo, String address, String currentEduYear) {

        Student student = new Student(); // create student object to save into database

        /**
         * here we don't add id value into student object because that id value will auto generate (we already add GenerationType in our Student Entity class).
         * so, let skip adding value into id field of Student object and now it will be null.
         */

        // before insert into db, you can validate input value as your logic.
        // eg. if(phoneNo.length() < 7 || phoneNo.length() > 13) return "Phone no length is wrong.";
        // eg. if(!studentId.startWith("stu") return "Wrong student Id format");
        // something like that above code, you can do as your requirement logic.

        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setPhoneNo(phoneNo);
        student.setAddress(address);
        student.setCurrentEduYear(currentEduYear);

        logger.info("Before inserting into database: {}", student); // print out student data before save into database by using logger.

        /**
         * We can call save() method which provide from JpaRepository interface and we already extends that interface in StudentRepository interface.
         * So, we don't need to write sql query like 'insert into Student value ... ;' anymore.
         */

        student = studentRepository.save(student); // save into database and get return value which include id value from database (auto generate id from database)

        // here we got id back from database even we don't add while saving. because we catch return value as Student in above save method.
        String message = "Successfully save student into database with id: " + student.getId();

        return message; // return message;

    }

    // this method is to get all student data from database.
    public List<Student> getAllStudent() {

        /**
         * We can call findAll() method which provide from JpaRepository interface and we already extends that interface in StudentRepository interface.
         * So, we don't need to write sql query like 'select * from Student;' anymore.
         */
        List<Student> studentList = studentRepository.findAll();

        logger.info("Database response size: {}", studentList.size()); // print out response size from database by using logger.

        return studentList; // return student list data which retrieve from database.

    }

    // this method is to get student data by id from database.
    public Student findById(long id) {

        /**
         * We can call findById() method which provide from JpaRepository interface and we already extends that interface in StudentRepository interface.
         * So, we don't need to write sql query like 'select * from Student where id = {input parameter id};' anymore.
         * FindById method return with Optional datatype.
         * We can also get specific return type (eg. Student instead of Optional<Student>) by name query with '@Query' annotation instead of build-in method query like findById().
         * And if we want get return value as specific type, can write sql statement in repository interface (eg. @Query("select * from users where id= {param id}")) in there.
         * but, here I just use build-in findById method which return value is Optional.
         */
        Optional<Student> optionalStudent = studentRepository.findById(id);

        Student student; // declare student object, no need to create/initialize object like Student student = new Student(), because repository interface will return created object.

        // check findById method is getting data or not, if not, we need to request valid student id again which existed in DB or we need to check in DB for at least one student data is existed or not.
        // If not existed any Student data, we need to call save student Api first.
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get(); // get student object from Optional <Student> object.
        } else {
            logger.warn("Can't find Student by Id: {}", id);

            return null; // return null because we can't find.
        }

        return student;

    }

    // this method is to get student data by student id from database.
    public List<Student> findByStudentId(String stuId) {

        /**
         * We can call findByStudentId() method which already create in StudentRepository interface and catch return type as per method which is from StudentRepository Interface.
         */

        // there can have many rows because finding by student id instead of finding with Id (which is primary key <not duplciate> and must have only one rows),
        // so catch with List data type and you must return List data type from StudenRepository for that.
        List<Student> studentList = studentRepository.findByStudentId(stuId);
        logger.info("Database response size: {}", studentList);

        // check findByStudentName method is getting data or not, if not, we need to request valid student name again which existed in DB or we need to check in DB for at least one student data is existed or not.
        // If not existed any Student data, we need to call save student Api first.
        if (studentList.isEmpty()) {

            logger.warn("Can't find Student by studentId: {}", stuId);

            List<Student> list = new ArrayList<>();

            // return new empty list because can't find any student data by name.
            return list;  // we can return directly eg. return new ArrayList<>();

        } else {
            return studentList;
        }

    }


    // this method is to get student data by name from database.
    public List<Student> findByStudentName(String name) {

        /**
         * We can call findByStudentName() method which already create in StudentRepository interface and catch return type as per method which is from StudentRepository Interface.
         */
        // there can have many rows because finding by student name instead of finding with Id (which is primary key <not duplciate> and must have only one rows),
        // so catch with List data type and you must return List data type from StudenRepository for that.
        List<Student> studentList = studentRepository.findByStudentName(name);
        logger.info("Database response size: {}", studentList);

        // check findByStudentName method is getting data or not, if not, we need to request valid student name again which existed in DB or we need to check in DB for at least one student data is existed or not.
        // If not existed any Student data, we need to call save student Api first.
        if (studentList.isEmpty()) {
            logger.warn("Can't find Student by name: {}", name);
            return new ArrayList<>(); // return new empty list because can't find any student data by name.

        } else {
            return studentList;
        }

    }

    // this method is to update student data as per user input data.
    public String updateStudent(Student userInputStudent) {

        try {

            // check the whole object is null or not. if we miss to validate that object, it can get null pointer exception when getting field value from that object.
            if (userInputStudent != null) {

                // check student id is null or not, because we can't select query when id is null.
                if (userInputStudent.getId() != null) {

                    Optional<Student> optionalStudent = studentRepository.findById(userInputStudent.getId());

                    // check db response data is existed or not.
                    if (optionalStudent.isPresent()) {

                        Student dbResponseStudent = optionalStudent.get(); // get student object from Optional <Student> object.

                        logger.info("Database data: {}", dbResponseStudent);
                        logger.info("user input data: {}", userInputStudent);

                        // to count at least one data was existed. if all student data (name, etc) were null or empty, we don't update into database.
                        // if you don't want to use count, you need to add condition for all fields again.
                        int count = 0;


                        /**
                         * add user input student updated data into db response student data.
                         * here we checked for input student data is not null or not empty
                         * and checked for db data and user input data is same or not.
                         * If same, we don't do update because that data is already in db.
                         * eg. if student name from database is 'Mg Mg' and user input student name is 'Mg Mg', so, we don't do update for that field (student name).
                         *
                         * So, we will do update only if not Same value, not Null value and not Empty.
                         */

                        if (userInputStudent.getStudentId() != null && !userInputStudent.getStudentId().trim().equals("") &&
                                !dbResponseStudent.getStudentId().equals(userInputStudent.getStudentId())) {

                            count = 1; // set 1 value to count, this is for just note and if count is 1, we can assume that at least input data one field is existed.
                            dbResponseStudent.setStudentId(userInputStudent.getStudentId()); // update (replace) user input student id to existing db response student id, when user input student id is not equal null or empty.

                            // before update into db, you can validate input value as your logic.
                            // eg. if(!dbResponseStudent.getStudentId.startWith("stu") return "Wrong student Id format");

                        }

                        if (userInputStudent.getStudentName() != null && !userInputStudent.getStudentName().trim().equals("") &&
                                !dbResponseStudent.getStudentName().equals(userInputStudent.getStudentName())) {
                            count = 1;
                            dbResponseStudent.setStudentName(userInputStudent.getStudentName());
                        }

                        if (userInputStudent.getAddress() != null && !userInputStudent.getAddress().trim().equals("") &&
                                !dbResponseStudent.getAddress().equals(userInputStudent.getAddress())) {
                            count = 1;
                            dbResponseStudent.setAddress(userInputStudent.getAddress());
                        }

                        if (userInputStudent.getPhoneNo() != null && !userInputStudent.getPhoneNo().trim().equals("") && !dbResponseStudent.getPhoneNo().equals(userInputStudent.getPhoneNo())) {
                            count = 1;
                            dbResponseStudent.setPhoneNo(userInputStudent.getPhoneNo());

                            // before update into db, you can validate input value as your logic.
                            // eg. if(dbResponseStudent.getPhoneNo().length() < 7 || dbResponseStudent.getPhoneNo().length() > 13) return "Phone no length is wrong.";

                        }

                        if (userInputStudent.getCurrentEduYear() != null && !userInputStudent.getCurrentEduYear().trim().equals("") &&
                                !dbResponseStudent.getCurrentEduYear().equals(userInputStudent.getCurrentEduYear())) {
                            count = 1;
                            dbResponseStudent.setCurrentEduYear(userInputStudent.getCurrentEduYear());
                        }


                        /**
                         * We checked count is 0 or not.
                         * 0 means, all fields from user input student objects is null or empty.
                         * 1 mean, at least one field is changed because we set 1 into count in above if desire field is not equal null or empty.
                         * So, if 1, we can assume at least one field has data.
                         * if 1 -> we will do update and if 0 -> we don't do update.
                         */
                        if (count == 0) {

                            String errorMsg = "User input is null or empty or same with database value for id: " + userInputStudent.getId();
                            return errorMsg; // here, when we return back, the process will not do below code cause of return keyword. So, don't call Save method anymore if user input is empty or same with db.

                        }


                        /********* now dbResponseStudent object got updated data. So, we will save into db *********/


                        logger.info("Before Updating into Student table: {}", dbResponseStudent); // print update data and you can check in console.


                        // here we use save method to update and JPA will not be new insert row for Save method because there has id in student object which already existed in Table.
                        // but, if student object id is null, jpa save method will create as new rolw in Table.
                        studentRepository.save(dbResponseStudent);


                        /**
                         * if you don't want to use above Save method to update, you can call like below and updateStudentById method is already created in StudentRepository.
                         * Please find below updateStudentById in StudentRepository.
                         */
                    /*studentRepository.updateStudentById(dbResponseStudent.getId(), dbResponseStudent.getStudentId(),
                                                                dbResponseStudent.getStudentName(), dbResponseStudent.getPhoneNo(),
                                                                    dbResponseStudent.getAddress(), dbResponseStudent.getCurrentEduYear());*/


                        // assume all are save and there is no error. So, we will return back as Successfully Updated.
                        return "Successfully updated.";

                    } else { // condition from there is not record found from database (empty Optional)

                        String errorMessage = "There is no student record found in Database as per user input id: " + userInputStudent.getId() + ". Please type valid Id.";
                        return errorMessage;
                    }

                } else { // condition from user input Id case.

                    String errorMessage = "Input Id is null or empty. Please type id field.";
                    return errorMessage;
                }

            } else { // condition from user input object is null.

                String errorMessage = "User input object is null.";
                return errorMessage;
            }

        } catch (Exception e) { // we need to catch error by try and catch, because there can be error when saving into db (eg. can't connect to db, etc)
            e.printStackTrace(); // print error trace log.
            logger.error(e.getMessage()); // print error log.
            return "Something went wrong, Please contact to your administrator"; // return general error message.
        }


    }

    // this method is to delete student data by id.
    public String deleteById(long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        // check db response data is existed or not.
        if (optionalStudent.isPresent()) {

            /**
             * Normally, I don't recommend to permanently delete the row inside table.
             * Instead of deleting row, we can create new column call isDeleted in Entity class and Table and databype is with boolean.
             * And we can set 'true' value to that column when user want to delete as per id for that row.
             * And when we find the data, we need to query filter like where isDeleted is 'false' in findAll, findByid, etc methods.
             * So, user may think record were deleted if they can't find in response data because we already filter in all of find methods by isDeleted is 'false'.
             * It mean, virtually delete by set 'isDelete' column to 'true', but not physically delete and we can show the user that value by setting isDeleted to 'false' back.
             * But here, I will do permanently delete as for delete sample.
             */

            // if you don't want to permanently delete the row,
            // here we can update isDeleted to 'true' by calling 'Save' method and add one field (boolean isDeleted) in entity class instead of calling deletedById.
            studentRepository.deleteById(id); // but here, I will do permanently delete as for delete sample.

            return "Successfully deleted student data for id: " + id;

        } else {
            return "We can't find any data with input id: " + id;
        }


    }


}
