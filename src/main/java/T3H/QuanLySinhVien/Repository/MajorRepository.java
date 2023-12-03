package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.MajorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MajorRepository  extends JpaRepository<MajorDao,Integer> {
//    List<Major> getAllMajor();
//    List<Major> addMajor(Major major);
//    List<Major> updateMajor(Major major);
//    List<Major> deleteMajor(int id);
}
