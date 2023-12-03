package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.SubjectDao;
import T3H.QuanLySinhVien.Entities.dto.SubjectDto;

public class SubjectMapper {
    public static SubjectDto mapSubject(SubjectDao subjectDao)
    {
        return new SubjectDto(
                subjectDao.getSubject_id(),
                subjectDao.getSubject_name(),
                subjectDao.getCredit_hour(),
                subjectDao.getDepartment_id(),
                subjectDao.getCreated_at(),
                subjectDao.getUpdated_at()
        );
    }
}
