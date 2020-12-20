package a99fallen.projects.events.converter;

import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public User from(RegisterUserCommand registerUserCommand){
        return User.builder()
                .username(registerUserCommand.getUsername())
                .password(registerUserCommand.getPassword())
                .build();
    }
}
