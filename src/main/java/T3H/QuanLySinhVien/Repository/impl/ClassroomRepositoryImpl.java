//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListAccount;
//import T3H.QuanLySinhVien.Configuration.ListClassroom;
//import T3H.QuanLySinhVien.Model.Classroom;
//import T3H.QuanLySinhVien.Repository.ClassroomRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.management.loading.ClassLoaderRepository;
//import java.util.List;
//@Repository
//public class ClassroomRepositoryImpl implements ClassroomRepository {
//    @Override
//    public List<Classroom> getAllClassroom()
//    {
//        return ListClassroom.getList();
//    }
//
//    @Override
//    public List<Classroom> addClassroom(Classroom classroom) {
//        List<Classroom> classroomList=ListClassroom.getList();
//        classroomList.add(classroom);
//        return classroomList;
//    }
//
//    @Override
//    public List<Classroom> deleteClassroomById(int id) {
//        List<Classroom> classroomList=ListClassroom.getList();
//        for (Classroom clr:classroomList)
//        {
//            if (clr.getClass_id()==id)
//            {
//                classroomList.remove(clr);
//                break;
//            }
//        }
//        return classroomList;
//    }
//
//    @Override
//    public List<Classroom> updateClassroomById(Classroom classroom) {
//        List<Classroom> classroomList=ListClassroom.getList();
//        for (Classroom clr:classroomList)
//        {
//            if (clr.getClass_id()==classroom.getClass_id())
//            {
//                clr.setClass_name(classroom.getClass_name());
//                clr.setQuantity(classroom.getQuantity());
//                break;
//            }
//        }
//        return classroomList;
//    }
//}
