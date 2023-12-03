package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.Module_subjectDao;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;

public class Module_subjectMapper {
    public static Module_subjectDto mapModule_subject(Module_subjectDao moduleSubjectDao)
    {
        return new Module_subjectDto(
                moduleSubjectDao.getModule_subject_id(),
                moduleSubjectDao.getSubject_id(),
                moduleSubjectDao.getCurrent_student(),
                moduleSubjectDao.getMaximum_student(),
                moduleSubjectDao.getTeacher_id(),
                moduleSubjectDao.getStart_at(),
                moduleSubjectDao.getEnd_at(),
                moduleSubjectDao.getCreated_at(),
                moduleSubjectDao.getUpdated_at()
        );
    }
}
