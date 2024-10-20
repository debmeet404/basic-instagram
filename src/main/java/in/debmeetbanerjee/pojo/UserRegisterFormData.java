package in.debmeetbanerjee.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterFormData {

    @NotBlank(message = "Name cannot be blank!")
    @Size(max = 100)
    private String name;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 6, max = 36, message = "Password length must be between 6 and 36 characters")
    private String password;
    @Email(message = "Please provide a valid email address")
    private String email;
}
