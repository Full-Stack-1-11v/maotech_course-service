package cl.maotech.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.maotech.course_service.model.Course;
import java.util.List;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long>{

    public Course findByCodigo(String codigo);

    @Query(value = "SELECT * FROM cursos WHERE nombre = :nombre", nativeQuery = true)
    List<Course> findByNombreNative(String nombre);


}
