package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("dashboard")
    public String getDashboard(Model model)
    {
        String countDepartment="SELECT COUNT(*) AS CountDepartment FROM departments";
        String countMajor="SELECT COUNT(*) AS CountMajor FROM majors";
        String countTeacher="SELECT COUNT(*) AS CountTeacher FROM teachers";
        String countStudent="SELECT COUNT(*) AS CountStudent FROM students";
        String countSubject="SELECT COUNT(*) AS CountSbuject FROM subjects";
        model.addAttribute("countDepartment", jdbcTemplate.queryForObject(countDepartment,Integer.class));
        model.addAttribute("countMajor", jdbcTemplate.queryForObject(countMajor,Integer.class));
        model.addAttribute("countTeacher", jdbcTemplate.queryForObject(countTeacher,Integer.class));
        model.addAttribute("countStudent", jdbcTemplate.queryForObject(countStudent,Integer.class));
        model.addAttribute("countSubject", jdbcTemplate.queryForObject(countSubject,Integer.class));
        return "Dashboard/index";
    }


}
