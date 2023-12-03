package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.MajorDao;
import T3H.QuanLySinhVien.Entities.dto.MajorDto;

public class MajorMapper {
    public static MajorDto mapMajor(MajorDao majorDao)
    {
        return new MajorDto(
                majorDao.getMajor_id(),
                majorDao.getMajor_name(),
                majorDao.getDepartment_id(),
                majorDao.getTeacher_id(),
                majorDao.getCreated_at(),
                majorDao.getUpdated_at()
        );
    }
}
