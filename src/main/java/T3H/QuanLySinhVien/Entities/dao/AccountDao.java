package T3H.QuanLySinhVien.Entities.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int account_id;

    private String username;
    private String password;
    private int level_id;
    private String remember_token;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
