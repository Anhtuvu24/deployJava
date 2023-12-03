package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.Module_subjectDao;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;
import T3H.QuanLySinhVien.Mapper.Module_subjectMapper;
import T3H.QuanLySinhVien.Repository.Module_subjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Module_subjectService {
    @Autowired
    Module_subjectRepository moduleSubjectRepository;
    public List<Module_subjectDto> getAllModule_subject()
    {
        List<Module_subjectDto> list=new ArrayList<>();
        for (Module_subjectDao moduleSubjectDao:moduleSubjectRepository.findAll())
        {
            list.add(Module_subjectMapper.mapModule_subject(moduleSubjectDao));
        }
        return list;
    }
//    List<Module_subject> addModule_subject(Module_subject moduleSubject)
//    {
//        return moduleSubjectRepository.addModule_subject(moduleSubject);
//    }
//    List<Module_subject> deleteModule_subject(int id)
//    {
//        return moduleSubjectRepository.deleteModule_subject(id);
//    }
//    List<Module_subject> updateModule_subject(Module_subject moduleSubjectl)
//    {
//        return moduleSubjectRepository.updateModule_subject(moduleSubjectl);
//    }

}
