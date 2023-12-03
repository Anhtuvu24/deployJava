//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListCourse_registration;
//import T3H.QuanLySinhVien.Configuration.ListDepartment;
//import T3H.QuanLySinhVien.Model.Department;
//import T3H.QuanLySinhVien.Repository.DepartmentRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class DepartmentRepositoryImpl implements DepartmentRepository {
//    @Override
//    public List<Department> getAllDepartment() {
//        return ListDepartment.getList();
//    }
//
//    @Override
//    public List<Department> addDepartment(Department department) {
//        List<Department> departmentList=ListDepartment.getList();
//        departmentList.add(department);
//        return departmentList;
//    }
//
//    @Override
//    public List<Department> updateDepartment(Department department) {
//        List<Department> departmentList=ListDepartment.getList();
//        for (Department dp:departmentList)
//        {
//            if (dp.getDepartment_id()==department.getDepartment_id())
//            {
//                dp.setDepartment_name(department.getDepartment_name());
//                break;
//            }
//        }
//        return departmentList;
//    }
//
//    @Override
//    public List<Department> deleteDepartment(int id)
//    {
//        List<Department> departmentList=ListDepartment.getList();
//        for (Department dp:departmentList)
//        {
//            if (dp.getDepartment_id()==id)
//            {
//                departmentList.remove(dp);
//                break;
//            }
//        }
//        return departmentList;
//    }
//}
