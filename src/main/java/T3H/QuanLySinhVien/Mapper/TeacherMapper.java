package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.TeacherDao;
import T3H.QuanLySinhVien.Entities.dto.TeacherDto;

public class TeacherMapper {
    public static TeacherDto mapTeacher(TeacherDao teacherDao)
    {
        return new TeacherDto(
                teacherDao.getTeacher_id(),
                teacherDao.getAccount_id(),
                teacherDao.getInfor_id(),
                teacherDao.getCreated_at(),
                teacherDao.getUpdated_at()
        );
    }
}
