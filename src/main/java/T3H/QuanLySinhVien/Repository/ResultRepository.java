package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.ResultDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResultRepository extends JpaRepository<ResultDao,Integer> {
//    List<Result> getAllResult();
//    List<Result> addResult(Result result);
//    List<Result> deleteResult(int id);
//    List<Result> updateResult(Result result);
}
