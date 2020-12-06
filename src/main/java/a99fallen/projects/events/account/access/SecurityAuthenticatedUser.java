package a99fallen.projects.events.account.access;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticatedUser implements AuthenticatedUser {

    @Override
    public String getUsername() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
}
