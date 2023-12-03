package T3H.QuanLySinhVien.Converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    private int class_id;
    private String class_name;
    private int quantity;
    private String major_name;
    private int major_id;
    private String  fullname;
    private String department_name;
    private String phone_number;

}
