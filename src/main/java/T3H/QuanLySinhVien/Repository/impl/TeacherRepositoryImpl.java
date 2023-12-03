//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListTeacher;
//import T3H.QuanLySinhVien.Model.Teacher;
//import T3H.QuanLySinhVien.Repository.TeacherRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class TeacherRepositoryImpl implements TeacherRepository {
//    @Override
//    public List<Teacher> getAllTeacher() {
//        return ListTeacher.getList();
//    }
//
//    @Override
//    public List<Teacher> addTeacher(Teacher teacher) {
//        List<Teacher> teachers=ListTeacher.getList();
//        teachers.add(teacher);
//        return teachers;
//    }
//
//    @Override
//    public List<Teacher> deleteTeacher(int id) {
//        List<Teacher> teachers=ListTeacher.getList();
//        for (Teacher tea:teachers)
//        {
//            if (tea.getTeacher_id()==id)
//            {
//                teachers.remove(tea);
//                break;
//            }
//        }
//        return teachers;
//    }
//
//}
