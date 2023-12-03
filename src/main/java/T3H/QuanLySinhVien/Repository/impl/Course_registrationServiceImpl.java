//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListCourse_registration;
//import T3H.QuanLySinhVien.Model.Course_registration;
//import T3H.QuanLySinhVien.Repository.Course_registrationRepository;
//import T3H.QuanLySinhVien.Service.Course_registrationService;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class Course_registrationServiceImpl implements Course_registrationRepository {
//    @Override
//    public List<Course_registration> getAllCourse_registration() {
//        return ListCourse_registration.getList();
//    }
//
//    @Override
//    public List<Course_registration> addCourse_registration(Course_registration courseRegistration) {
//        List<Course_registration> course_registrationList=ListCourse_registration.getList();
//        course_registrationList.add(courseRegistration);
//        return course_registrationList;
//    }
//
//    @Override
//    public List<Course_registration> deleteCourse_registration(int id) {
//        List<Course_registration> course_registrationList=ListCourse_registration.getList();
//        for (Course_registration cour:course_registrationList)
//        {
//            if (cour.getCourse_registration_id()==id)
//            {
//                course_registrationList.remove(cour);
//                break;
//            }
//        }
//        return course_registrationList;
//    }
//}
