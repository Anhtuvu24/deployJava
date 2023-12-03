package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="module_subjects")
public class Module_subjectDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_subject_id")
    private int module_subject_id;
    private int subject_id;
    private int current_student;
    private int maximum_student;
    private int teacher_id;
    private LocalDate start_at;
    private LocalDate end_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
