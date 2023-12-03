package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Department;
import T3H.QuanLySinhVien.Converter.Module_subject;
import T3H.QuanLySinhVien.Converter.Subject;
import T3H.QuanLySinhVien.Converter.Teacher;
import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;
import T3H.QuanLySinhVien.Entities.dto.MajorDto;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;
import T3H.QuanLySinhVien.Service.Module_subjectService;
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
public class Module_subjectController {
    @Autowired
    Module_subjectService moduleSubjectService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/module_subject")
    public String getAllModule_subject(Model model)
    {
        String sql="SELECT m.module_subject_id, s.subject_name, m.current_student,i.fullname,m.start_at,m.end_at,m.created_at\n" +
                "FROM module_subjects m\n" +
                "LEFT OUTER JOIN subjects s ON s.subject_id=m.subject_id\n" +
                "LEFT OUTER JOIN teachers t on m.teacher_id=t.teacher_id\n" +
                "LEFT OUTER JOIN infors i on t.infor_id=i.infor_id\n";
        String teachers = "SELECT t.teacher_id, i.fullname" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        String subject="SELECT * FROM subjects";

        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        model.addAttribute("subjectList",namedParameterJdbcTemplate.query(subject,new BeanPropertyRowMapper<>(Subject.class)));
        model.addAttribute("module_subjectList",namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Module_subject.class)));
        return "ManagerModule_subject/index";
    }

    @PostMapping("/addModule_subject")
    public String addModule_subject(@ModelAttribute("module_subject") Module_subjectDto module_SubjectDto) {

        String sql= "INSERT INTO module_subjects ( subject_id, current_student, maximum_student, teacher_id, start_at, end_at, created_at, updated_at) " +
                "VALUES (:subject_id, :current_student, :maximum_student, :teacher_id, :start_at, :end_at, :created_at, :updated_at)";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("subject_id",module_SubjectDto.getSubject_id())
                .addValue("current_student",module_SubjectDto.getCurrent_student())
                .addValue("maximum_student",module_SubjectDto.getMaximum_student())
                .addValue("teacher_id",module_SubjectDto.getTeacher_id())
                .addValue("start_at",module_SubjectDto.getStart_at())
                .addValue("end_at",module_SubjectDto.getEnd_at())
                .addValue("created_at", LocalDateTime.now())
                .addValue("updated_at",LocalDateTime.now());
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/module_subject"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }

    @PostMapping("/deleteModule_subject")
    public String deleteModule_subject(@RequestParam int id)
    {
        String sql="DELETE from module_subjects " +
                "WHERE module_subject_id=:module_subject_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("module_subject_id",id);
        int result = namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/module_subject";
    }
    @GetMapping("/update-module_subject/{id}")
    public String getUpdateModule_subject(@PathVariable Integer id, Model model)
    {
        String sql = "SELECT * FROM module_subjects WHERE module_subject_id =:module_subject_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("module_subject_id", id);
        List<Module_subjectDto> module_subjects = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Module_subjectDto.class));
        model.addAttribute("module_subject", module_subjects.get(0));
        String modulesubject = "SELECT * FROM module_subjects";
        String subjects="SELECT * FROM subjects";
        String teachers = "SELECT t.teacher_id, i.fullname,i.email" +
                " FROM teachers t " +
                " LEFT OUTER JOIN infors i On t.infor_id = i.infor_id";
        model.addAttribute("module_subjectList",namedParameterJdbcTemplate.query(modulesubject,new BeanPropertyRowMapper<>(Module_subject.class)));
        model.addAttribute("teacherList",namedParameterJdbcTemplate.query(teachers,new BeanPropertyRowMapper<>(Teacher.class)));
        model.addAttribute("subjectList",namedParameterJdbcTemplate.query(subjects,new BeanPropertyRowMapper<>(Subject.class)));
        return "ManagerModule_subject/update";
    }
    @PostMapping("/updateModule_subject")
    public String updateModule_subject(@ModelAttribute("module_subject") Module_subjectDto module_subjectDto)
    {
        String sql="UPDATE module_subjects " +
                "SET subject_id=:subject_id,maximum_student=:maximum_student," +
                "teacher_id=:teacher_id,start_at=:start_at,end_at=:end_at,updated_at=:updated_at " +
                "WHERE module_subject_id=:module_subject_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("module_subject_id",module_subjectDto.getModule_subject_id())
                .addValue("subject_id",module_subjectDto.getModule_subject_id())
                .addValue("maximum_student",module_subjectDto.getMaximum_student())
                .addValue("start_at",module_subjectDto.getStart_at())
                .addValue("end_at",module_subjectDto.getEnd_at())
                .addValue("teacher_id",module_subjectDto.getTeacher_id())
                .addValue("updated_at",LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
        return "redirect:/module_subject";
    }
}
