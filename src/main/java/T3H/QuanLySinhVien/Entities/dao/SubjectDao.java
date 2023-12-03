package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;
    private String subject_name;
    private int credit_hour;
    private int department_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
