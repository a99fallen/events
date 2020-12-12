package a99fallen.projects.events.sevice;

import a99fallen.projects.events.converter.UserConverter;
import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.domain.repository.UserRepository;
import a99fallen.projects.events.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public Long create(RegisterUserCommand registerUserCommand){
        User userToCreate = userConverter.from(registerUserCommand);
        userRepository.save(userToCreate);
        return userToCreate.getId();
    }
    public Boolean checkIfUserAlreadyExists(String username){
        return userRepository.existsUserByUsername(username);
    }
}
