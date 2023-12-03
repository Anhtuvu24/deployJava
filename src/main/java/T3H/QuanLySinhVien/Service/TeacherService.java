package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.TeacherDao;
import T3H.QuanLySinhVien.Entities.dto.TeacherDto;
import T3H.QuanLySinhVien.Mapper.TeacherMapper;
import T3H.QuanLySinhVien.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public List<TeacherDto> getAllTeacher()
    {
        List<TeacherDto> list=new ArrayList<>();
        for (TeacherDao teacherDao:teacherRepository.findAll())
        {
            list.add(TeacherMapper.mapTeacher(teacherDao));
        }
        return list;

    }
//    public List<Teacher> addTeacher(Teacher teacher)
//    {
//        return teacherRepository.addTeacher(teacher);
//    }
//
//    public List<Teacher> deleteTeacher(int id)
//    {
//        return teacherRepository.deleteTeacher(id);
//    }
}
