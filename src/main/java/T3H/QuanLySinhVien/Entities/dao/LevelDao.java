package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "levels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="level_id")
    private int level_id;
    private String level_name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
