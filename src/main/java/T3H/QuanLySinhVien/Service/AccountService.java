package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Entities.dao.AccountDao;
import T3H.QuanLySinhVien.Mapper.AccountMapper;
import T3H.QuanLySinhVien.Converter.Account;
import T3H.QuanLySinhVien.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts()
    {
        List<Account> list=new ArrayList<>();
        for (AccountDao accountDao:accountRepository.findAll())
        {
            list.add(AccountMapper.mapAccount(accountDao));
        }
        return list;
    }
//    public List<Account> addAccount(Account account)
//    {
//       return accountRepository.addAccount(account);
//    }
//    public List<Account> deleteAccountByIdForAdmin(int id)
//    {
//        return accountRepository.deleteAccountByIdForAdmin(id);
//    }
//    public List<Account> updateAccountById(Account account) {
//        return accountRepository.updateAccountById(account);
//    }
}
