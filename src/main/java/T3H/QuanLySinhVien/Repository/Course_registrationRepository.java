package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.Course_registrationDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course_registrationRepository  extends JpaRepository<Course_registrationDao,Integer> {
//    List<Course_registration> getAllCourse_registration();
//    List<Course_registration> addCourse_registration(Course_registration courseRegistration);
//    List<Course_registration> deleteCourse_registration(int id);

}
