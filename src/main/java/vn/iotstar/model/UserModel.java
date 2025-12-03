package vn.iotstar.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long userId;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private String role;
    private Boolean active = true;
}
