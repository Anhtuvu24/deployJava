//package T3H.QuanLySinhVien.Repository.impl;
//
//import T3H.QuanLySinhVien.Configuration.ListAccount;
//import T3H.QuanLySinhVien.Model.Account;
//import T3H.QuanLySinhVien.Repository.AccountRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class AccountRepositoryImpl implements AccountRepository {
//
//    @Override
//    public List<Account> getAllAccount()
//    {
//        return ListAccount.getList();
//    }
//    public List<Account> addAccount(Account account)
//    {
//        List<Account> accountList=ListAccount.getList();
//        accountList.add(account);
//        return  accountList;
//    }
//    @Override
//    public List<Account> deleteAccountByIdForAdmin(int id)
//    {
//        List<Account> accountList=ListAccount.getList();
//        for (Account acc: accountList)
//        {
//            if (acc.getAccount_id()==id&&acc.getLevel_id()==3) {
//                accountList.remove(acc);
//                break;
//            }
//        }
//        return  accountList;
//    }
//
//    @Override
//    public List<Account> updateAccountById(Account account)
//    {
//        int updateId=account.getAccount_id();
//        List<Account> accountList=ListAccount.getList();
//        for (Account acc: accountList)
//        {
//            if (acc.getAccount_id()==updateId)
//            {
//                acc.setPassword(account.getPassword());
//                acc.setUpdated_at(account.getUpdated_at());
//                break;
//            }
//        }
//        return accountList;
//    }
//}
