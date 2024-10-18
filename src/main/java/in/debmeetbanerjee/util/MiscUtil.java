package in.debmeetbanerjee.util;

import in.debmeetbanerjee.entity.User;
import in.debmeetbanerjee.pojo.UserRegisterFormData;

import java.util.UUID;

public class MiscUtil {

    public static String getRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public static User getUserFromFormData(UserRegisterFormData formData) {
        return User.builder()
                .email(formData.getEmail())
                .name(formData.getName())
                .password(formData.getPassword())
                .build();
    }

}
