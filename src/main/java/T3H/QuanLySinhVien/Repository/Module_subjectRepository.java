package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.Module_subjectDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Module_subjectRepository extends JpaRepository<Module_subjectDao,Integer> {
//    List<Module_subject> getAllModule_subject();
//    List<Module_subject> addModule_subject(Module_subject moduleSubject);
//    List<Module_subject> updateModule_subject(Module_subject moduleSubject);
//    List<Module_subject> deleteModule_subject(int id);
}
