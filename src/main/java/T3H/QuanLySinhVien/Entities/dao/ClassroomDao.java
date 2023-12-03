package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "class_rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class_id")
    private int class_id;
    private String class_name;
    private int quantity;
    private int major_id;
    private int teacher_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
