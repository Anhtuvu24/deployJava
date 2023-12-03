//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListResult;
//import T3H.QuanLySinhVien.Model.Result;
//import T3H.QuanLySinhVien.Repository.ResultRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public class ResultRepositoryImpl implements ResultRepository {
//    @Override
//    public List<Result> getAllResult() {
//        List<Result> results= ListResult.getList();
//
//        return results;
//    }
//
//    @Override
//    public List<Result> addResult(Result result) {
//        List<Result> results=ListResult.getList();
//        results.add(result);
//        return results;
//    }
//
//    @Override
//    public List<Result> deleteResult(int id) {
//        List<Result> results=ListResult.getList();
//        for (Result re:results)
//        {
//            if (re.getResult_id()==id)
//            {
//                results.remove(re);
//                break;
//            }
//        }
//        return results;
//    }
//    @Override
//    public List<Result> updateResult(Result result) {
//        List<Result> results=ListResult.getList();
//        for (Result re:results)
//        {
//            if (re.getResult_id()==result.getResult_id())
//            {
//                re.setPoint(result.getPoint());
//                break;
//            }
//        }
//        return results;
//    }
//}
