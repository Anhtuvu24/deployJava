package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.DepartmentDao;
import T3H.QuanLySinhVien.Entities.dto.DepartmentDto;
import T3H.QuanLySinhVien.Mapper.DepartmentMapper;
import T3H.QuanLySinhVien.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public List<DepartmentDto> getAllDepartment()
    {
        List<DepartmentDto> list=new ArrayList<>();
        for (DepartmentDao departmentDao: departmentRepository.findAll())
        {
            list.add(DepartmentMapper.mapDepartment(departmentDao));
        }
        return list;
    }
//    public List<Department> addDepartment(Department department)
//    {
//        return departmentRepository.addDepartment(department);
//    }
//    public List<Department> updateDepartment(Department department)
//    {
//        return departmentRepository.updateDepartment(department);
//    }
//    public List<Department> deleteDepartment(int id)
//    {
//        return departmentRepository.deleteDepartment(id);
//    }
}
