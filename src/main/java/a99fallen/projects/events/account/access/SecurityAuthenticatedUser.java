package a99fallen.projects.events.account.access;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component @Primary
public class SecurityAuthenticatedUser implements AuthenticatedUser {

    @Override
    public String getUsername() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
}
