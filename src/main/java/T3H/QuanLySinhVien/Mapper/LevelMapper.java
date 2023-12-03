package T3H.QuanLySinhVien.Mapper;

import T3H.QuanLySinhVien.Entities.dao.LevelDao;
import T3H.QuanLySinhVien.Converter.Level;

public class LevelMapper {
    public static Level mapLevel(LevelDao levelDao)
    {
        return new Level(
          levelDao.getLevel_id(),
          levelDao.getLevel_name(),
          levelDao.getCreated_at(),
          levelDao.getUpdated_at()
        );
    }
}
