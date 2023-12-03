package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Major;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dao.ClassroomDao;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Converter.Classroom;
import T3H.QuanLySinhVien.Service.ClassroomService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @GetMapping("/classroom")
    public String getAllClassroom(Model model)
    {
        String sql= "SELECT "
                    +" c.class_id,"
                    +" c.class_name,"
                    +" c.quantity,"
                    +" m.major_name,"
                    +" d.department_name,"
                    +" i.fullname,"
                    +" i.phone_number"
            +" FROM class_rooms c"
                    +" LEFT OUTER JOIN teachers t ON c.teacher_id = t.teacher_id"
                    +" LEFT OUTER JOIN infors i ON t.infor_id = i.infor_id"
                    +" LEFT OUTER JOIN majors m ON c.major_id = m.major_id"
                    +" LEFT OUTER JOIN departments d ON m.department_id=d.department_id";

//        String departments = "SELECT * FROM departments";
        String majors = "SELECT * FROM majors";
        String teachers = "SELECT t.teacher_id, i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
//        Classroom classroom=new Classroom();
//        SqlParameterSource nameParameters=new BeanPropertySqlParameterSource(classroom);
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource();
//        namedParameterJdbcTemplate.queryForObject(sql,nameParameters,new BeanPropertyRowMapper<>(Classroom.class));
        model.addAttribute("classroomList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Classroom.class)));
//        model.addAttribute("departmentList",namedParameterJdbcTemplate.query(departments,new BeanPropertyRowMapper<>(Department.class)));
        model.addAttribute("majorList",namedParameterJdbcTemplate.query(majors,new BeanPropertyRowMapper<>(Major.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));

        return "ManagerClass/index";
    }



    @PostMapping("/addClassroom")
    public String addClassroom(@ModelAttribute("classroom") ClassroomDto classroomDto) {

        String sql= "INSERT INTO class_rooms (class_name, quantity, major_id, teacher_id, created_at, updated_at) " +
                "VALUES (:class_name,:quantity,:major_id,:teacher_id,:created_at,:updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("class_name",classroomDto.getClass_name())
                .addValue("quantity",classroomDto.getQuantity())
                .addValue("major_id",classroomDto.getMajor_id())
                .addValue("teacher_id",classroomDto.getTeacher_id())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/classroom"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }

    @PostMapping("/deleteClassroom")
    public String deleteClassroom(@RequestParam int id)
    {
        String sql="DELETE from class_rooms " +
                "WHERE class_id=:class_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("class_id",id);
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/classroom";
    }
    @GetMapping("/update-classroom/{id}")
    public String getUpdateClassroom(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM class_rooms WHERE class_id = :class_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("class_id", id);
        List<ClassroomDto> classrooms = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(ClassroomDto.class));
        model.addAttribute("classroom", classrooms.get(0));
        String majors = "SELECT * FROM majors";
        String teachers = "SELECT t.teacher_id, i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("majorList",namedParameterJdbcTemplate.query(majors,new BeanPropertyRowMapper<>(Major.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        return "ManagerClass/update";
    }
    @PostMapping("/updateClassroom")
    public String updateClassroom(@ModelAttribute("classroom") ClassroomDto classroomDto)
    {
        String sql="UPDATE class_rooms " +
                "SET class_name=:class_name,quantity=:quantity,major_id=:major_id,teacher_id=:teacher_id,updated_at=:updated_at " +
                "WHERE class_id=:class_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("class_id",classroomDto.getClass_id())
                .addValue("class_name",classroomDto.getClass_name())
                .addValue("quantity",classroomDto.getQuantity())
                .addValue("major_id",classroomDto.getMajor_id())
                .addValue("teacher_id",classroomDto.getTeacher_id())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/classroom";
    }
//    @PostMapping("/classroom")
//    public ResponseEntity<Integer> addClassroom(@RequestBody ClassroomDto classroomDto)
//    {
//        String sql= "INSERT INTO class_rooms (class_name, quantity, major_id, teacher_id, created_at, updated_at) " +
//                "VALUES (:class_name,:quantity,:major_id,:teacher_id,:created_at,:updated_at)";
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
//                .addValue("class_name",classroomDto.getClass_name())
//                .addValue("quantity",classroomDto.getQuantity())
//                .addValue("major_id",classroomDto.getMajor_id())
//                .addValue("teacher_id",classroomDto.getTeacher_id())
//                .addValue("created_at", LocalDateTime.now())
//                .addValue("updated_at",LocalDateTime.now());
//        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//    @PutMapping("/updateClassroom")
//    public ResponseEntity<Integer> updateClassroom(@RequestBody ClassroomDto classroomDto)
//    {
//        String sql="UPDATE class_rooms " +
//                "SET class_name=:class_name,quantity=:quantity,major_id=:major_id,teacher_id=:teacher_id,updated_at=:updated_at " +
//                "WHERE class_id=:class_id";
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
//                .addValue("class_id",classroomDto.getClass_id())
//                .addValue("class_name",classroomDto.getClass_name())
//                .addValue("quantity",classroomDto.getQuantity())
//                .addValue("major_id",classroomDto.getMajor_id())
//                .addValue("teacher_id",classroomDto.getTeacher_id())
//                .addValue("updated_at",LocalDateTime.now());
//        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
//    }
//    @DeleteMapping("/classroom/{id}")
//    public ResponseEntity<Integer> deleteClassroom(@PathVariable int id)
//    {
//        String sql="DELETE from class_rooms " +
//                "WHERE class_id=:class_id";
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
//                .addValue("class_id",id);
//        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
//        return ResponseEntity.ok(result);
//    }


}
