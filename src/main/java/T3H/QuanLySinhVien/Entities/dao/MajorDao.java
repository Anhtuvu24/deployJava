package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name="majors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private int major_id;
    private String major_name;
    private int department_id;
    private int teacher_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
