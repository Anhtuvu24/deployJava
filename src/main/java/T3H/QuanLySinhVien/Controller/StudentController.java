package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Classroom;
import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Student;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.*;
import T3H.QuanLySinhVien.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("/student")
    public String getAllStudent(Model model)
    {
        String sql="SELECT s.student_id,i.fullname,i.date_of_birth,i.gender,i.address,i.phone_number,i.email,s.gpa,c.class_name\n" +
                "FROM students s\n" +
                "LEFT OUTER JOIN infors i ON s.infor_id=i.infor_id\n" +
                "left outer join class_rooms c on s.class_id=c.class_id" +
                " ORDER BY s.student_id";
        String classrooms="SELECT * FROM class_rooms";
        model.addAttribute("classroomList",namedParameterJdbcTemplate.query(classrooms,new BeanPropertyRowMapper<>(Classroom.class)));
        model.addAttribute("studentList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class)));
        return "ManagerStudent/index";
    }
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") StudentDto studentDto,
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
                .addValue("level_id",4)
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(accounts,nameParameters2);
        int account_id= keyHolder.getKey().intValue();

        String sql= "INSERT INTO students ( account_id, infor_id, class_id, created_at, updated_at) " +
                "VALUES (:account_id, :infor_id, :class_id, :created_at, :updated_at)";

        MapSqlParameterSource nameParameters1=new MapSqlParameterSource()
                .addValue("account_id", account_id)
                .addValue("infor_id", infor_id)
                .addValue("class_id", studentDto.getClass_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());


        namedParameterJdbcTemplate.update(sql,nameParameters1);

        return "redirect:/student"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }
    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int id)
    {
        String sql="delete s,a,i" +
                " from students s " +
                "inner join accounts a " +
                "on a.account_id=s.account_id" +
                " inner join infors i on s.infor_id=i.infor_id" +
                " where s.student_id=:student_id";

        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("student_id",id);
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/student";
    }

    @GetMapping("/update-student/{id}")
    public String getUpdateStudent(@PathVariable Integer id, Model model) throws ParseException {
        String sql = "SELECT * FROM students inner join infors on students.infor_id = infors.infor_id WHERE student_id =:student_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("student_id", id);
        List<Student> students = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Student.class));
        model.addAttribute("student", students.get(0));
        return "ManagerStudent/update";
    }
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") StudentDto studentDto,
                                @ModelAttribute("infor") InforDto inforDto)
    {
        String sql="UPDATE infors i " +
                "inner join students s on s.infor_id=i.infor_id " +
                "SET i.fullname=:fullname,i.phone_number=:phone_number,i.email=:email," +
                "i.date_of_birth=:date_of_birth,i.address=:address,i.gender=:gender,i.updated_at=:updated_at" +
                " WHERE student_id=:student_id";
        MapSqlParameterSource nameParameters1=new MapSqlParameterSource()
                .addValue("student_id",studentDto.getStudent_id())
                .addValue("infor_id",inforDto.getInfor_id())
                .addValue("fullname",inforDto.getFullname())
                .addValue("phone_number",inforDto.getPhone_number())
                .addValue("email",inforDto.getEmail())
                .addValue("date_of_birth",inforDto.getDate_of_birth())
                .addValue("address",inforDto.getAddress())
                .addValue("gender",inforDto.getGender())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters1);
        return "redirect:/student";
    }
}
