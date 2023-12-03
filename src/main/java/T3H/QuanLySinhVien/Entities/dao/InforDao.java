package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "infors")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InforDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "infor_id")
    private int infor_id;

    private String fullname;
    private String address;
    private String phone_number;
    private String email;
    private LocalDate date_of_birth;
    private int gender;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
