package T3H.QuanLySinhVien.Converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course_registration {
    private int course_registration_id;
    private int student_id;
    private int module_subject_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
