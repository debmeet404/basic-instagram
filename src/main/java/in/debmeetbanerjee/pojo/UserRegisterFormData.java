package in.debmeetbanerjee.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterFormData {
    private String name;
    private String password;
    private String email;
}
