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
public class Department {
    private int department_id;
    private String department_name;
    private String fullname;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
