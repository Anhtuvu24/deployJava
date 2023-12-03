//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListSubject;
//import T3H.QuanLySinhVien.Model.Subject;
//import T3H.QuanLySinhVien.Repository.SubjectRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//
//public class SubjectRepositoryImpl implements SubjectRepository {
//    @Override
//    public List<Subject> getAllSubject() {
//        return ListSubject.getList();
//    }
//
//    @Override
//    public List<Subject> addSubject(Subject subject) {
//        List<Subject> subjects=ListSubject.getList();
//        subjects.add(subject);
//        return subjects;
//    }
//
//    @Override
//    public List<Subject> deleteSubject(int id) {
//        List<Subject> subjects=ListSubject.getList();
//        for (Subject sub:subjects)
//        {
//            if (sub.getSubject_id()==id)
//            {
//                subjects.remove(sub);
//                break;
//            }
//        }
//        return subjects;
//    }
//
//    @Override
//    public List<Subject> updateSubject(Subject subject) {
//        List<Subject> subjects=ListSubject.getList();
//        for (Subject sub:subjects)
//        {
//            if (sub.getSubject_id()==subject.getSubject_id())
//            {
//                sub.setSubject_name(subject.getSubject_name());
//                sub.setCredit_hour(subject.getCredit_hour());
//                break;
//            }
//        }
//        return subjects;
//    }
//}
