package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.ClassroomDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomDao, Integer> {
//    List<Classroom> getAllClassroom();
//    List<Classroom> addClassroom(Classroom classroom);
//    List<Classroom> deleteClassroomById(int id);
//    List<Classroom> updateClassroomById(Classroom classroom);
}
