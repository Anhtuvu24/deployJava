package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Account;
import T3H.QuanLySinhVien.Converter.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("")
    public String getLogin(Model model)
    {
//        model.addAttribute("error", null);
        return "Auth/login";
    }
    @PostMapping("/login")
    public String checkLogin(@RequestParam String username,@RequestParam String password, Model model)
    {

        String sql="SELECT COUNT(*) FROM accounts WHERE username = :username AND password = :password";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("username",username)
                .addValue("password",password);
        int count = namedParameterJdbcTemplate.queryForObject(sql, nameParameters, Integer.class);
        if (count>0) return "redirect:/dashboard";

        model.addAttribute("error", "Tài khoản hoặc mật khẩu sai");
        return "Auth/login";
    }
}
