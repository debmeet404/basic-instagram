package in.debmeetbanerjee.service;

import in.debmeetbanerjee.util.Constants;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Slf4j
@Component
public class SessionHelper {

    public void removeLoginMessageFromSession() {
        try {
            HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                    .getRequest().getSession();
            session.removeAttribute(Constants.MESSAGE);
        } catch (Exception e) {
            log.warn("Error in removing message attribute from session");
        }

    }

}
