package T3H.QuanLySinhVien.Converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Major {
    private int major_id;
    private String major_name;
    private String department_name;
    private String fullname;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
