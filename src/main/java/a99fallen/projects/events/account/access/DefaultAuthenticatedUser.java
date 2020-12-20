package a99fallen.projects.events.account.access;

import a99fallen.projects.events.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("local")
@RequiredArgsConstructor
public class DefaultAuthenticatedUser implements AuthenticatedUser{

    private final UserRepository userRepository;

    @Override
    public String getUsername() {
        return userRepository.getUserByAnyUsername();
    }
}
