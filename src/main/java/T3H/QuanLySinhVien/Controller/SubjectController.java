package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Subject;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Entities.dto.MajorDto;
import T3H.QuanLySinhVien.Entities.dto.SubjectDto;
import T3H.QuanLySinhVien.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/subject")
    public String getAllSubject(Model model)
    {
        String sql="SELECT s.subject_id,s.subject_name,s.credit_hour,d.department_name" +
                " FROM subjects s" +
                " LEFT OUTER JOIN departments d ON d.department_id = s.department_id";
        String sql2="SELECT * from departments";
        model.addAttribute("subjectList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Subject.class)));
        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(sql2,new BeanPropertyRowMapper<>(Department.class)));


        return "ManagerSubject/index";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") SubjectDto subjectDto) {

        String sql= "INSERT INTO subjects (subject_name, credit_hour, department_id, created_at, updated_at) " +
                "VALUES (:subject_name, :credit_hour, :department_id, :created_at, :updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("subject_name",subjectDto.getSubject_name())
                .addValue("credit_hour",subjectDto.getCredit_hour())
                .addValue("department_id",subjectDto.getDepartment_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/subject"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }
    @PostMapping("/deleteSubject")
    public String deleteSubject(@RequestParam int id)
    {
        String sql="DELETE from subjects " +
                "WHERE subject_id=:subject_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("subject_id",id);
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/subject";
    }

    @GetMapping("/update-subject/{id}")
    public String getUpdateSubject(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM subjects WHERE subject_id =:subject_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("subject_id", id);
        List<SubjectDto> subjects = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(SubjectDto.class));
        model.addAttribute("subject", subjects.get(0));
        String departments = "SELECT * FROM departments";
        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(departments,new BeanPropertyRowMapper<>(Department.class)));
        return "ManagerSubject/update";
    }
    @PostMapping("/updateSubject")
    public String updateSubject(@ModelAttribute("major") SubjectDto subjectDto)
    {
        String sql="UPDATE subjects " +
                "SET subject_name=:subject_name,credit_hour=:credit_hour,department_id=:department_id,updated_at=:updated_at " +
                "WHERE subject_id=:subject_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("subject_id",subjectDto.getSubject_id())
                .addValue("subject_name",subjectDto.getSubject_id())
                .addValue("department_id",subjectDto.getDepartment_id())
                .addValue("credit_hour",subjectDto.getCredit_hour())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/subject";
    }
}
