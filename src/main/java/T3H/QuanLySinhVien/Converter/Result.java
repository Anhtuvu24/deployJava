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
public class Result {
    private int result_id;
    private int courser_registration_id;
    private double point;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
