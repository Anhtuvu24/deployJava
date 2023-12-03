package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.ResultDao;
import T3H.QuanLySinhVien.Mapper.ResultMapper;
import T3H.QuanLySinhVien.Converter.Result;
import T3H.QuanLySinhVien.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    ResultRepository resultRepository;

    public List<Result> getAllResult()
    {
        List<Result> list=new ArrayList<>();
        for (ResultDao resultDao:resultRepository.findAll())
        {
            list.add(ResultMapper.mapResult(resultDao));
        };
       return list;
    }
//    public List<Result> addResult(Result result)
//    {
//        return resultRepository.addResult(result);
//    }
//    public List<Result> updateResult(Result result)
//    {
//        return resultRepository.updateResult(result);
//
//    }
//    public List<Result> deleteResult(int id)
//    {
//        return resultRepository.deleteResult(id);
//    }
}
