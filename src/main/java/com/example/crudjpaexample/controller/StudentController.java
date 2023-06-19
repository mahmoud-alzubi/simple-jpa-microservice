package com.example.crudjpaexample.controller;

import com.example.crudjpaexample.dao.StudentDaoImpl;
import com.example.crudjpaexample.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentDaoImpl studentDao;

    @Autowired
    public StudentController(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }


    /////////////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") int id) {
        return studentDao.findById(id);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentDao.findAll();
    }


    @GetMapping("find-by-name/{name}")
    public List<Student> findAllByName(@PathVariable("name") String name) {
        return studentDao.findAllByName(name);
    }

    ////////////////////////////////////////////////////////////////////

    /**
     * @param student
     * @return
     */
    @PostMapping
    public Boolean saveStudent(@RequestBody Student student) {
        boolean status = false;
        try {
            studentDao.save(student);
            status = true;
        } catch (Exception e) {
            status = false;
        } finally {
            return status;
        }
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Student updatedStudent = studentDao.update(student, id);
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable("id") int id) {
        studentDao.removeById(id);
    }
}
