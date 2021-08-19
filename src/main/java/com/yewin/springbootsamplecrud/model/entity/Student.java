package com.yewin.springbootsamplecrud.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author Ye Win.
 * @CreatedDate 10/03/2019.
 * @Description This class is to create entity and bind with database table.
 */


//@Getter
//@Setter
//@ToString
// We can use @Data instead of @Getter, @Setter and @ToString. Because @Data include those features and which provide by Lombok (we already add in pom.xml and need to add lombok plugin in our IDE)
// So, by using Data, we don't need to build get, set method and toString method anymore.
@Data // To get getter and setter method feature and that @Data was provide by Lombok.
@Entity // that annotation '@' Entity tell spring framework that class will connect with database table.
@Table(name ="student") // if not define, it still ok. Table will auto create by entity class name
public class Student {

    @Id // declare below field 'Long id' as primary key in table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the id will auto generate and so, no need to put id value when saving into database.
    Long id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name") // if not define, it still ok. Column will auto create by studentName field.
    private String studentName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "address")
    private String address;

    @Column(name = "current_edu_year")
    private String currentEduYear;


    /**
     * Here we can create get and set method like below, but we don't need to create that by using Lombok @Data annotation.
     */
    /*public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }*/



    /**
     * Here we can create toString() method below, but we don't need to create that by using Lombok @Data annotation.
     */

}
