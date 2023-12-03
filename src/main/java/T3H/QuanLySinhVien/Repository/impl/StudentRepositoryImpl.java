//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListStudent;
//import T3H.QuanLySinhVien.Model.Student;
//import T3H.QuanLySinhVien.Repository.StudentRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//
//public class StudentRepositoryImpl implements StudentRepository {
//    @Override
//    public List<Student> getAllStudent() {
//
//        return ListStudent.getList();
//    }
//
//    @Override
//    public List<Student> addStudent(Student student) {
//        List<Student> students=ListStudent.getList();
//        students.add(student);
//        return students;
//    }
//
//    @Override
//    public List<Student> deleteStudent(int id) {
//        List<Student> students=ListStudent.getList();
//        for (Student stu:students)
//        {
//            if (stu.getStudent_id()==id)
//            {
//                students.remove(stu);
//                break;
//            }
//        }
//        return students;
//    }
//
//    @Override
//    public List<Student> updateStudent(Student student) {
//        List<Student> students=ListStudent.getList();
//        for (Student stu:students)
//        {
//            if (stu.getStudent_id()==student.getStudent_id())
//            {
//                stu.setGpa(student.getGpa());
//                break;
//            }
//        }
//        return students;
//    }
//}
