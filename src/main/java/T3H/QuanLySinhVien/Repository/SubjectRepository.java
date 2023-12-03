package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.SubjectDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubjectRepository  extends JpaRepository<SubjectDao,Integer> {
//    List<Subject> getAllSubject();
//    List<Subject> addSubject(Subject subject);
//    List<Subject> deleteSubject(int id);
//    List<Subject> updateSubject(Subject subject);
}
