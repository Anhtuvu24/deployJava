package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.TeacherDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeacherRepository extends JpaRepository<TeacherDao,Integer>
{
//    List<Teacher> getAllTeacher();
//    List<Teacher> addTeacher(Teacher teacher);
//    List<Teacher> deleteTeacher(int id);

}
