package T3H.QuanLySinhVien.Converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Infor {
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
