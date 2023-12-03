package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.ClassroomDao;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Mapper.ClassroomMapper;
import T3H.QuanLySinhVien.Repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    public List<ClassroomDto> getAllClassroom()
    {
        List<ClassroomDto> list = new ArrayList<>();
        for (ClassroomDao classroomDao : classroomRepository.findAll()) {
            list.add(ClassroomMapper.mapClassroom(classroomDao));
        }
        return list;
    }
//    public List<Classroom> addClassroom(Classroom classroom)
//    {
//        return classroomRepository.addClassroom(classroom);
//    }
//    public List<Classroom> updateClassroomById(Classroom classroom)
//    {
//        return classroomRepository.updateClassroomById(classroom);
//    }
//    public List<Classroom> deleteClassroomById(int id)
//    {
//        return classroomRepository.deleteClassroomById(id);
//    }


}
