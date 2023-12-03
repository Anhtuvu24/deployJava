package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.ResultDao;
import T3H.QuanLySinhVien.Converter.Result;

public class ResultMapper {
    public static Result mapResult(ResultDao resultDao)
    {
        return new Result(
                resultDao.getResult_id(),
                resultDao.getCourse_registration_id(),
                resultDao.getPoint(),
                resultDao.getCreated_at(),
                resultDao.getUpdated_at()
        );
    }
}
