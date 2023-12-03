package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.StudentDao;
import T3H.QuanLySinhVien.Entities.dto.StudentDto;

public class StudentMapper {
    public static StudentDto mapStudent(StudentDao studentDao)
    {
        return new StudentDto(
                studentDao.getStudent_id(),
                studentDao.getAccount_id(),
                studentDao.getInfor_id(),
                studentDao.getClass_id(),
                studentDao.getGpa(),
                studentDao.getCreated_at(),
                studentDao.getUpdated_at()
        );
    }
}
