package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.StudentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<StudentDao,Integer> {
//    List<Student> getAllStudent();
//    List<Student> addStudent(Student student);
//    List<Student> deleteStudent(int id);
//    List<Student> updateStudent(Student student);
}
