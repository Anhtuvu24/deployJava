package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class StudentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int student_id;
    private int account_id;
    private int infor_id;
    private int class_id;
    private double gpa;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
