package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.DepartmentDao;
import T3H.QuanLySinhVien.Entities.dto.DepartmentDto;


public class DepartmentMapper {
    public static DepartmentDto mapDepartment(DepartmentDao departmentDao)
    {
        return new DepartmentDto(
                departmentDao.getDepartment_id(),
                departmentDao.getDepartment_name(),
                departmentDao.getTeacher_id(),
                departmentDao.getCreated_at(),
                departmentDao.getUpdated_at()
        );
    }
}
