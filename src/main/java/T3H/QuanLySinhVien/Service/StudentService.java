package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.StudentDao;
import T3H.QuanLySinhVien.Entities.dto.StudentDto;
import T3H.QuanLySinhVien.Mapper.StudentMapper;
import T3H.QuanLySinhVien.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDto> getAllStudent()
    {
        List<StudentDto> list=new ArrayList<>();
        for (StudentDao studentDao:studentRepository.findAll())
        {
            list.add(StudentMapper.mapStudent(studentDao));
        }
        return list;
    }
//    public List<Student> addStudent(Student student)
//    {
//        return studentRepository.addStudent(student);
//    }
//    public List<Student> deleteStudent(int id)
//    {
//        return studentRepository.deleteStudent(id);
//    }
//    public List<Student> updateStudent(Student student)
//    {
//        return studentRepository.updateStudent(student);
//    }

}
