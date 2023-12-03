package T3H.QuanLySinhVien.Converter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Module_subject {
    private int module_subject_id;
    private String subject_name;
    private int current_student;
    private String fullname;

    private LocalDate start_at;

    private LocalDate end_at;
    private LocalDateTime created_at;

}
