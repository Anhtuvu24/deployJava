package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Account;
import T3H.QuanLySinhVien.Converter.Student;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.AccountDto;
import T3H.QuanLySinhVien.Entities.dto.InforDto;
import T3H.QuanLySinhVien.Entities.dto.TeacherDto;
import T3H.QuanLySinhVien.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//@RestController // Dùng cho app springboot, trả về Json
@Controller // Dùng cho app MVC, mỗi API endpoint trả về tên file html
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/account")
    public String getUpdateTeacher( Model model)
    {
        String sql = "SELECT * FROM teachers t " +
                "inner join accounts a on t.account_id=a.account_id " +
                "inner join infors i on t.infor_id = i.infor_id WHERE teacher_id =:teacher_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("teacher_id", 1);
        List<Teacher> teachers = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Teacher.class));
        model.addAttribute("teacher",teachers.get(0));

        return "Dashboard/infor";
    }
    @PostMapping("/updateAccount")
    public String updateAccount(@ModelAttribute("infor") InforDto inforDto,
                                @ModelAttribute("account") AccountDto accountDto)
    {
        String sql="UPDATE infors i " +
                "inner join teachers t on t.infor_id=i.infor_id " +
                "inner join accounts a on t.account_id=a.account_id " +
                "SET i.fullname=:fullname,i.phone_number=:phone_number,i.email=:email," +
                "i.date_of_birth=:date_of_birth,i.address=:address,i.gender=:gender,a.password=:password,i.updated_at=:updated_at" +
                " WHERE teacher_id=:teacher_id";
        MapSqlParameterSource nameParameters1=new MapSqlParameterSource()
                .addValue("teacher_id",1)
                .addValue("infor_id",inforDto.getInfor_id())
                .addValue("fullname",inforDto.getFullname())
                .addValue("phone_number",inforDto.getPhone_number())
                .addValue("email",inforDto.getEmail())
                .addValue("date_of_birth",inforDto.getDate_of_birth())
                .addValue("address",inforDto.getAddress())
                .addValue("gender",inforDto.getGender())
                .addValue("password",accountDto.getPassword())
                .addValue("updated_at", LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters1);
        return "redirect:/account";
    }

//    @GetMapping("/account")
//    public String getAllAccounts(Model model) {
//        List<Account> result = accountService.getAllAccounts();
//        model.addAttribute("accountList", result);
//        return "ManagerClass/index";
//    }

//    @PostMapping("/account")
//    public ResponseEntity<List<Account>> addAccount(@RequestBody Account account) {
//        List<Account> result = accountService.addAccount(account);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//
//    @DeleteMapping("/account/{id}")
//    public ResponseEntity<List<Account>> deleteAccountByIdForAdmin(@PathVariable int id) {
//        List<Account> result = accountService.deleteAccountByIdForAdmin(id);
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/account/{id}")
//    public ResponseEntity<List<Account>> updateAccountById(@RequestBody Account account) {
//        List<Account> result = accountService.updateAccountById(account);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
//    }


}
