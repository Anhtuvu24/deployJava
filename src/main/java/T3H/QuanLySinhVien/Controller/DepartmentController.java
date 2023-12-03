package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Major;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Entities.dto.DepartmentDto;
import T3H.QuanLySinhVien.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/department")
    public String getAllDepartment(Model model)
    {
        String sql="SELECT d.department_id, d.department_name, i.fullname, d.created_at, d.updated_at" +
                " FROM departments d" +
                " LEFT OUTER JOIN teachers t ON d.teacher_id = t.teacher_id" +
                " LEFT OUTER JOIN infors i on t.infor_id = i.infor_id";
        String teachers = "SELECT t.teacher_id, i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Department.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));

        return "ManagerDepartment/index";
    }
    @PostMapping("/addDepartment")
    public String addDepartment(@ModelAttribute("department") DepartmentDto departmentDto)
    {
        String sql="INSERT INTO departments ( department_name, teacher_id, created_at, updated_at)" +
                " VALUES (:department_name,:teacher_id,:created_at,:updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("department_name",departmentDto.getDepartment_name())
                .addValue("teacher_id",departmentDto.getTeacher_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/department";
    }

    @PostMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam int id)
    {
        String sql="DELETE FROM departments" +
                " WHERE department_id=:department_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("department_id",id);
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/department";
    }
    @GetMapping("/update-department/{id}")
    public String getUpdateDepartment(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM departments WHERE department_id = :department_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("department_id", id);
        List<DepartmentDto> departments = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(DepartmentDto.class));
        model.addAttribute("department", departments.get(0));
        String teachers = "SELECT t.teacher_id, i.email,i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        return "ManagerDepartment/update";
    }
    @PostMapping("/updateDepartment")
    public String updateClassroom(@ModelAttribute("department") DepartmentDto departmentDto)
    {
        String sql="UPDATE departments "+
                "SET department_name=:department_name,teacher_id=:teacher_id,updated_at=:updated_at " +
                "WHERE department_id=:department_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("department_id",departmentDto.getDepartment_id())
                .addValue("department_name",departmentDto.getDepartment_name())
                .addValue("teacher_id",departmentDto.getTeacher_id())
                .addValue("updated_at", LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/department";
    }
//    @PutMapping("/deparment")
//    public ResponseEntity<Integer> updateDepartment(@RequestBody DepartmentDto departmentDto)
//    {
//        String sql="UPDATE departments" +
//                " SET department_name=:deparment_name,teacher_id=:teacher_id,updated_at=:updated_at" +
//                " WHERE department_id=:department_id";
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
//                .addValue("department_id",departmentDto.getDepartment_id())
//                .addValue("deparment_name",departmentDto.getDepartment_name())
//                .addValue("teacher_id",)
//    }

}
