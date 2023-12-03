package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.SubjectDao;
import T3H.QuanLySinhVien.Entities.dto.SubjectDto;
import T3H.QuanLySinhVien.Mapper.SubjectMapper;
import T3H.QuanLySinhVien.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository  subjectRepository;
    public List<SubjectDto> getAllSubject()
    {
        List<SubjectDto> list=new ArrayList<>();
        for (SubjectDao subjectDao:subjectRepository.findAll())
        {
            list.add(SubjectMapper.mapSubject(subjectDao));
        }
        return list;
    }
//    public List<Subject> addSubject(Subject subject)
//    {
//        return subjectRepository.addSubject(subject);
//
//    }
//    public List<Subject> deleteSubject(int id)
//    {
//        return subjectRepository.deleteSubject(id);
//    }
//    public List<Subject> updateSubject(Subject subject)
//
//    {
//        return subjectRepository.updateSubject(subject);
//    }
}
