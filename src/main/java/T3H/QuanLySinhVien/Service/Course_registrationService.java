package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.Course_registrationDao;
import T3H.QuanLySinhVien.Mapper.Course_registrationMapper;
import T3H.QuanLySinhVien.Converter.Course_registration;
import T3H.QuanLySinhVien.Repository.Course_registrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Course_registrationService {
    @Autowired
    Course_registrationRepository courseRegistrationRepository;

    public List<Course_registration> getAllCourse_registration()

    {
        List<Course_registration> list=new ArrayList<>();
        for (Course_registrationDao courseRegistrationDao:courseRegistrationRepository.findAll())
        {
            list.add(Course_registrationMapper.mapCourse_registration(courseRegistrationDao));
        }
        return list;
    }
//    public List<Course_registration> addCourse_registration(Course_registration courseRegistration)
//    {
//        return courseRegistrationRepository.addCourse_registration(courseRegistration);
//    }
//
//    public List<Course_registration> deleteCourse_registration(int id)
//    {
//        return courseRegistrationRepository.deleteCourse_registration(id);
//    }
}
