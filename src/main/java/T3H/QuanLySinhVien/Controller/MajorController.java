package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Major;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Entities.dto.MajorDto;
import T3H.QuanLySinhVien.Service.MajorService;
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
public class MajorController {
    @Autowired
    MajorService majorService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("/major")
    public String getAllMajor(Model model)
    {
        String sql="SELECT m.major_id,m.major_name,d.department_name,i.fullname,m.created_at,m.updated_at" +
                " FROM majors m" +
                " LEFT OUTER JOIN departments d ON d.department_id = m.department_id" +
                " LEFT OUTER JOIN teachers t ON m.teacher_id = t.teacher_id" +
                " LEFT OUTER JOIN infors i on t.infor_id = i.infor_id";
        String departments = "SELECT * FROM departments";
        String teachers = "SELECT t.teacher_id, i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("majorList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Major.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(departments,new BeanPropertyRowMapper<>(Department.class)));
        return "ManagerMajor/index";
    }
    @PostMapping("/addMajor")
    public String addMajor(@ModelAttribute("major") MajorDto majorDto) {

        String sql= "INSERT INTO majors (major_name,department_id, teacher_id, created_at, updated_at) " +
                "VALUES (:major_name,:department_id,:teacher_id,:created_at,:updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("major_name",majorDto.getMajor_name())
                .addValue("department_id",majorDto.getMajor_id())
                .addValue("teacher_id",majorDto.getTeacher_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/major"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }

    @PostMapping("/deleteMajor")
    public String deleteMajor(@RequestParam int id)
    {
        String sql="DELETE from majors " +
                "WHERE major_id=:major_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("major_id",id);
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/major";
    }

    @GetMapping("/update-major/{id}")
    public String getUpdateMajor(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM majors WHERE major_id =:major_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("major_id", id);
        List<MajorDto> majors = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(MajorDto.class));
        model.addAttribute("major", majors.get(0));
        String departments = "SELECT * FROM departments";
        String teachers = "SELECT t.teacher_id, i.fullname,i.email" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(departments,new BeanPropertyRowMapper<>(Department.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        return "ManagerMajor/update";
    }
    @PostMapping("/updateMajor")
    public String updateMajor(@ModelAttribute("major") MajorDto majorDto)
    {
        String sql="UPDATE majors " +
                "SET major_name=:major_name,department_id=:department_id,teacher_id=:teacher_id,updated_at=:updated_at " +
                "WHERE major_id=:major_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("major_id",majorDto.getMajor_id())
                .addValue("department_id",majorDto.getDepartment_id())
                .addValue("major_name",majorDto.getMajor_name())
                .addValue("teacher_id",majorDto.getTeacher_id())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/major";
    }
}
