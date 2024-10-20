package in.debmeetbanerjee.service;

import in.debmeetbanerjee.pojo.UserRegisterFormData;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static in.debmeetbanerjee.util.Constants.*;

@Slf4j
@Service
public class SignUpService {

    public void signUp(Model model) {
        model.addAttribute(USER_FORM_DATA_ATTR_VALUE, new UserRegisterFormData());
    }

    public void updateSession(HttpSession session) {
        session.setAttribute(MESSAGE, REGISTRATION_SUCCESSFUL);
        log.info("User Registration Success");
    }
}
