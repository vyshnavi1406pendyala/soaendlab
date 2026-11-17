
package soa;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(101, "Sowmya"));
        students.add(new Student(102, "Pavan"));
        students.add(new Student(103, "Charan"));

        return students;
    }
}