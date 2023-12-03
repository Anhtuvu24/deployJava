package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Entities.dao.DepartmentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDao,Integer> {
//    List<Department> getAllDepartment();
//    List<Department> addDepartment(Department department);
//    List<Department> updateDepartment(Department department);
//    List<Department> deleteDepartment(int id);

}
