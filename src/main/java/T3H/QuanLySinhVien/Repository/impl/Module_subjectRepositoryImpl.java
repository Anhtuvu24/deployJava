//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListModule_subject;
//import T3H.QuanLySinhVien.Model.Module_subject;
//import T3H.QuanLySinhVien.Repository.Module_subjectRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class Module_subjectRepositoryImpl implements Module_subjectRepository {
//    @Override
//    public List<Module_subject> getAllModule_subject() {
//        List<Module_subject> module_subjects= ListModule_subject.getList();
//        return module_subjects;
//    }
//
//    @Override
//    public List<Module_subject> addModule_subject(Module_subject moduleSubject) {
//        List<Module_subject> module_subjects= ListModule_subject.getList();
//        module_subjects.add(moduleSubject);
//        return module_subjects;
//    }
//
//    @Override
//    public List<Module_subject> updateModule_subject(Module_subject moduleSubject) {
//        List<Module_subject> module_subjects= ListModule_subject.getList();
//        for (Module_subject module:module_subjects)
//        {
//            if (module.getModule_subject_id()==moduleSubject.getModule_subject_id())
//            {
//                module.setCurrent_student(moduleSubject.getCurrent_student());
//                module.setMaximum_student(moduleSubject.getMaximum_student());
//                module.setStart_at(moduleSubject.getStart_at());
//                module.setEnd_at(moduleSubject.getEnd_at());
//                break;
//            }
//        }
//        return module_subjects;
//    }
//
//    @Override
//    public List<Module_subject> deleteModule_subject(int id) {
//        List<Module_subject> module_subjects= ListModule_subject.getList();
//        for (Module_subject module:module_subjects)
//        {
//            if (module.getModule_subject_id()==id)
//            {
//                module_subjects.remove(module);
//                break;
//            }
//        }
//        return module_subjects;
//    }
//}
