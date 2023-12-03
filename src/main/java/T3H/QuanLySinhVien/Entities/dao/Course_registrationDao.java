package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="course_registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_registrationDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_registration_id")
    private int course_registration_id;
    private int student_id;
    private int module_subject_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


}
