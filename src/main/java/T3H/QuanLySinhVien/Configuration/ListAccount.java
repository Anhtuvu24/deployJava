package T3H.QuanLySinhVien.Configuration;

import T3H.QuanLySinhVien.Converter.Account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListAccount {
    public static List<Account> getList()
    {
        ArrayList<Account> listAccount=new ArrayList<>();
        listAccount.add(new Account(1,"Nguyen","1",1,"Nguyen 1", LocalDateTime.now(),LocalDateTime.now()));
        listAccount.add(new Account(2,"Long","1",1,"Nguyen 1",LocalDateTime.now(),LocalDateTime.now()));
        listAccount.add(new Account(3,"Tai","1",1,"Nguyen 1",LocalDateTime.now(),LocalDateTime.now()));
        listAccount.add(new Account(4,"Dat","1",1,"Nguyen 1",LocalDateTime.now(),LocalDateTime.now()));
        listAccount.add(new Account(5,"Nam","1",1,"Nguyen 1",LocalDateTime.now(),LocalDateTime.now()));
        return  listAccount;
    }

}
