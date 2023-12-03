package T3H.QuanLySinhVien.Converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int account_id;
    private String username;
    private String password;
    private int level_id;
    private String remember_token;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
