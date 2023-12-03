package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.InforDao;
import T3H.QuanLySinhVien.Entities.dto.InforDto;
import T3H.QuanLySinhVien.Mapper.InforMapper;
import T3H.QuanLySinhVien.Converter.Infor;
import T3H.QuanLySinhVien.Repository.InforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InforService {
    @Autowired
    private InforRepository inforRepository;
    public List<InforDto> getAllInfor()
    {
        List<InforDto> list=new ArrayList<>();
        for (InforDao inforDao:inforRepository.findAll())
        {
            list.add(InforMapper.mapInfor(inforDao));
        }
        return list;
    }
}
