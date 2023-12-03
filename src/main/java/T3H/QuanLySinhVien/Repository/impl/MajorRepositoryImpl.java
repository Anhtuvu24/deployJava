//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListMajor;
//import T3H.QuanLySinhVien.Model.Major;
//import T3H.QuanLySinhVien.Repository.MajorRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class MajorRepositoryImpl implements MajorRepository {
//    @Override
//    public List<Major> getAllMajor() {
//        List<Major> majorList= ListMajor.getList();
//        return majorList;
//    }
//
//    @Override
//    public List<Major> addMajor(Major major) {
//        List<Major> majorList=ListMajor.getList();
//        majorList.add(major);
//        return majorList;
//    }
//
//    @Override
//    public List<Major> updateMajor(Major major) {
//        List<Major> majorList=ListMajor.getList();
//        for (Major m:majorList)
//        {
//            if (m.getMajor_id()==major.getMajor_id())
//            {
//                m.setMajor_name(major.getMajor_name());
//                break;
//            }
//        }
//        return majorList;
//    }
//
//    @Override
//    public List<Major> deleteMajor(int id) {
//        List<Major> majorList=ListMajor.getList();
//        for (Major m:majorList)
//        {
//            if (m.getMajor_id()==id)
//            {
//                majorList.remove(m);
//                break;
//            }
//        }
//        return majorList;
//    }
//}
