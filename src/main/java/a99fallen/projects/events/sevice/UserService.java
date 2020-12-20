package a99fallen.projects.events.sevice;

import a99fallen.projects.events.converter.UserConverter;
import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.domain.repository.UserRepository;
import a99fallen.projects.events.exception.UserAlreadyExistsException;
import a99fallen.projects.events.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long create(RegisterUserCommand registerUserCommand){
        log.debug("Dane użytkownika do zapisania: {}", registerUserCommand);
        User userToCreate = userConverter.from(registerUserCommand);
        log.debug("Uzysany obiekt użytkownika do zapisu: {}", userToCreate);
        if (userRepository.existsByUsername(userToCreate.getUsername())) {
            log.debug("Próba rejestracji na istniejącego użytkownika");
            throw new UserAlreadyExistsException(String.format("Użytkownik %s już istnieje", userToCreate.getUsername()));
        }
        userToCreate.setActive(Boolean.TRUE);
        userToCreate.setRoles(Set.of("ROLE_USER"));
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        userRepository.save(userToCreate);
        log.debug("Zapisany użytkownik: {}", userToCreate);
        return userToCreate.getId();
    }
}
