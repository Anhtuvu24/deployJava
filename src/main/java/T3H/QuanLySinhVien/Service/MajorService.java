package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.MajorDao;
import T3H.QuanLySinhVien.Entities.dto.MajorDto;
import T3H.QuanLySinhVien.Mapper.MajorMapper;
import T3H.QuanLySinhVien.Repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {
    @Autowired
    MajorRepository majorRepository;

    public List<MajorDto> getAllMajor()
    {
        List<MajorDto> list=new ArrayList<>();
        for (MajorDao majorDao:majorRepository.findAll())
        {
            list.add(MajorMapper.mapMajor(majorDao));
        }
        return list;
    }
//    public List<Major> addMajor(Major major)
//    {
//        return majorRepository.addMajor(major);
//    }
//    public List<Major> updateMajor(Major major)
//    {
//        return majorRepository.updateMajor(major);
//    }
//    public List<Major> deleteMajor(int id)
//    {
//        return majorRepository.deleteMajor(id);
//    }
}
