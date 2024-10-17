package in.debmeetbanerjee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//When you want to return a model and view (like a JSP or Thymeleaf page), you use @Controller.
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        log.info("/home hit");

        model.addAttribute("name", "Debmeet Banerjee");
        // Provide key-value pairs to Thymeleaf while rendering view.
        return "home";
    }
}
