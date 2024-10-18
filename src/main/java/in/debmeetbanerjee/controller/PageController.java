package in.debmeetbanerjee.controller;

import in.debmeetbanerjee.entity.User;
import in.debmeetbanerjee.pojo.UserRegisterFormData;
import in.debmeetbanerjee.service.SignUpService;
import in.debmeetbanerjee.service.UserService;
import in.debmeetbanerjee.util.MiscUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//When you want to return a model and view (like a JSP or Thymeleaf page), you use @Controller.
public class PageController {

    private final SignUpService signUpService;

    private final UserService userService;

    @Autowired
    PageController(SignUpService signUpService, UserService userService) {
        this.signUpService = signUpService;
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        log.info("/home hit");

        model.addAttribute("name", "Debmeet Banerjee");
        // Provide key-value pairs to Thymeleaf while rendering view.
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        log.info("/login hit");

        model.addAttribute("name", "Debmeet Banerjee");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        log.info("/signup hit");

        signUpService.signUp(model);

        return "signup";
    }

    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute UserRegisterFormData userFormData) {
        log.info("/register-user hit from form");

        User user = userService.saveUser(MiscUtil.getUserFromFormData(userFormData));

        return "redirect:/signup";
    }
}
