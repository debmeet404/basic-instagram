package in.debmeetbanerjee.service;

import in.debmeetbanerjee.pojo.UserRegisterFormData;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SignUpService {

    public void signUp(Model model) {
        model.addAttribute("userFormData", new UserRegisterFormData());
    }

    public void processRegisterRequest(UserRegisterFormData userFormData) {

    }
}
