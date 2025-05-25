package cl.maotech.course_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<Course> obtenerCursoPorId(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> guardarCurso(@RequestBody Course course) {
        Course nuevoCurso = courseService.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }
}
