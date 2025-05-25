package cl.maotech.course_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cl.maotech.course_service.model.Course;
import cl.maotech.course_service.repository.CourseRepository;

import java.util.List;

@Service
@Transactional

public class CourseService {

    @Autowired 
    private CourseRepository courseRepository;

    /*Obtiene una lista de los cursos registrados */
    public List<Course>getAllCourses() { 
        return courseRepository.findAll();
    }

    /* Obtiene un curso por id */
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    /*Crea y Guarda un curso en el sistema */
    public Course saveCourse(Course course) {
        Course coursePorCodigo = courseRepository.findByCodigo(course.getCodigo());

        if (course.getCodigo() != null && coursePorCodigo != null) {
            return coursePorCodigo;
        }

        return courseRepository.save(course);
    }

    /*Elimina curso por id */
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
    

}
