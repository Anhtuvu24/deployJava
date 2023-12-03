package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Course_registration;
import T3H.QuanLySinhVien.Service.Course_registrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Course_registrationController {

    @Autowired
    Course_registrationService course_registrationService;
    @GetMapping("/course_registration")
    public String getAllregistration(Model model)
    {
        List<Course_registration> result=course_registrationService.getAllCourse_registration();
        model.addAttribute("course_registrationList",result);
        return "ManagerCourse_registration/index";
    }

//    @PostMapping("/course_registration")
//    public ResponseEntity<List<Course_registration>> addCourse_registration(@RequestBody Course_registration course_registration) {
//        List<Course_registration> result = course_registrationService.addCourse_registration(course_registration);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//
//    @DeleteMapping("/course_registration/{id}")
//    public ResponseEntity<List<Course_registration>> deleteCourse_registration(@PathVariable int id) {
//        List<Course_registration> result = course_registrationService.deleteCourse_registration(id);
//        return ResponseEntity.ok(result);
//    }
}