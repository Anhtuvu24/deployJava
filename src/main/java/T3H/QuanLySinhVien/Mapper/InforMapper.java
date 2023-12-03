package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.InforDao;
import T3H.QuanLySinhVien.Converter.Infor;
import T3H.QuanLySinhVien.Entities.dto.InforDto;


public class InforMapper {
    public static InforDto mapInfor (InforDao inforDao)
    {
        return new InforDto(
                inforDao.getInfor_id(),
                inforDao.getFullname(),
                inforDao.getAddress(),
                inforDao.getPhone_number(),
                inforDao.getEmail(),
                inforDao.getDate_of_birth(),
                inforDao.getGender(),
                inforDao.getCreated_at(),
                inforDao.getUpdated_at()
        );
    }

}
