package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private int department_id;
    private String department_name;
    private int teacher_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
