package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacher_id;
    private int account_id;
    private int infor_id;
    private LocalDateTime created_at;
    private LocalDateTime  updated_at;
}
