package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="results")
@NoArgsConstructor
@AllArgsConstructor

public class ResultDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="result_id")
    private int result_id;
    private int course_registration_id;
    private double point;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
