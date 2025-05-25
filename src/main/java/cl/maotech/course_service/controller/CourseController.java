package cl.maotech.course_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.maotech.course_service.service.CourseService;
import cl.maotech.course_service.model.Course;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> LitarCourse() {
        List<Course> course = courseService.getAllCourses();
        return ResponseEntity.ok(course);
    }

}
