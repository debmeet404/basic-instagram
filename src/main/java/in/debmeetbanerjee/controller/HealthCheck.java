package in.debmeetbanerjee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// Specialized version of @Controller used for RESTful web services.
// It combines @Controller and @ResponseBody, meaning it automatically serializes the response body to JSON or XML
public class HealthCheck {

    public static final String UP_AND_RUNNING = "OK";

    @GetMapping("/health")
    public String healthCheck() {
        log.info("/health hit");
        return UP_AND_RUNNING;
    }
}
