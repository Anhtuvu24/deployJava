package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Level;
import T3H.QuanLySinhVien.Converter.Student;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.*;
import T3H.QuanLySinhVien.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("/teacher")
    public String getAllTeacher(Model model)
    {
        String sql="SELECT t.teacher_id,i.fullname, i.date_of_birth,i.gender,i.address,i.phone_number,i.email,l.level_name " +
                "FROM teachers t " +
                "LEFT OUTER JOIN infors i ON t.infor_id=i.infor_id " +
                "LEFT OUTER JOIN accounts a ON t.account_id=a.account_id" +
                " LEFT OUTER JOIN levels l ON l.level_id=a.level_id";
        String sql2="SELECT * FROM levels";
        model.addAttribute("levelList",namedParameterJdbcTemplate.query(sql2,new BeanPropertyRowMapper<>(Level.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Teacher.class)));
        return "ManagerTeacher/index";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute("teacher") TeacherDto teacherDto,
                             @ModelAttribute("account") AccountDto accountDto,
                             @ModelAttribute("infor") InforDto inforDto)
    {
        String infors="INSERT INTO infors( fullname, address, phone_number, email, date_of_birth, gender, created_at, updated_at)" +
                "VALUES ( :fullname, :address, :phone_number, :email, :date_of_birth, :gender, :created_at, :updated_at)";
        MapSqlParameterSource nameParameters3=new MapSqlParameterSource()
                .addValue("fullname",inforDto.getFullname())
                .addValue("address",inforDto.getAddress())
                .addValue("phone_number",inforDto.getPhone_number())
                .addValue("email",inforDto.getEmail())
                .addValue("date_of_birth",inforDto.getDate_of_birth())
                .addValue("gender",inforDto.getGender())
                .addValue("created_at",LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(infors,nameParameters3,keyHolder);
        int infor_id= keyHolder.getKey().intValue();

        String accounts="INSERT INTO accounts (username, password, level_id, created_at, updated_at)" +
                "VALUES (:username, :password, :level_id,  :created_at, :updated_at)";
        MapSqlParameterSource nameParameters2=new MapSqlParameterSource()
                .addValue("username",accountDto.getUsername())
                .addValue("password",accountDto.getPassword())
                .addValue("level_id",accountDto.getLevel_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(accounts,nameParameters2);
        int account_id= keyHolder.getKey().intValue();

        String sql= "INSERT INTO teachers ( account_id, infor_id, created_at, updated_at) " +
                "VALUES (:account_id, :infor_id, :created_at, :updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("account_id",account_id)
                .addValue("infor_id",infor_id)
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);


        return "redirect:/teacher"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }
    @PostMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam int id)
    {
        String sql="delete t,a,i" +
                " from teachers t " +
                "inner join accounts a " +
                "on a.account_id=t.account_id" +
                " inner join infors i on t.infor_id=i.infor_id" +
                " where t.teacher_id=:teacher_id";

        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("teacher_id",id);
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/teacher";
    }
    @GetMapping("/update-teacher/{id}")
    public String getUpdateTeacher(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM teachers " +
                "inner join infors on teachers.infor_id = infors.infor_id WHERE teacher_id =:teacher_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("teacher_id", id);
        List<Teacher> teachers = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Teacher.class));
        model.addAttribute("teacher",teachers.get(0));
//        String s = "SELECT s.student_id, i.fullname,i.email,i.phone_number,i.address,i.gender,i.date_of_birth" +
//                " FROM students s " +
//                " left outer join infors i On s.infor_id = i.infor_id";
//        model.addAttribute("studentList",namedParameterJdbcTemplate.query(s,new BeanPropertyRowMapper<>(Student.class)));
        return "ManagerTeacher/update";
    }

    @PostMapping("/updateTeacher")
    public String updateStudent(@ModelAttribute("teacher") TeacherDto teacherDto,
                                @ModelAttribute("infor") InforDto inforDto)
    {
        String sql="UPDATE infors i " +
                "inner join teachers t on t.infor_id=i.infor_id " +
                "SET i.fullname=:fullname,i.phone_number=:phone_number,i.email=:email," +
                "i.date_of_birth=:date_of_birth,i.address=:address,i.gender=:gender,i.updated_at=:updated_at" +
                " WHERE teacher_id=:teacher_id";
        MapSqlParameterSource nameParameters1=new MapSqlParameterSource()
                .addValue("teacher_id",teacherDto.getTeacher_id())
                .addValue("infor_id",inforDto.getInfor_id())
                .addValue("fullname",inforDto.getFullname())
                .addValue("phone_number",inforDto.getPhone_number())
                .addValue("email",inforDto.getEmail())
                .addValue("date_of_birth",inforDto.getDate_of_birth())
                .addValue("address",inforDto.getAddress())
                .addValue("gender",inforDto.getGender())
                .addValue("updated_at",LocalDateTime.now    ());
        namedParameterJdbcTemplate.update(sql,nameParameters1);
        return "redirect:/teacher";
    }
}
