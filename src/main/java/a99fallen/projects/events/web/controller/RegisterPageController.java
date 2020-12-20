package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.exception.UserAlreadyExistsException;
import a99fallen.projects.events.sevice.UserService;
import a99fallen.projects.events.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterPageController {
    private final UserService userService;

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute(new RegisterUserCommand());
        return "register";
    }

    @PostMapping
    public String processRegister(@Valid RegisterUserCommand registerUserCommand, BindingResult bindingResult){
        log.debug("Dane do utworzenia użytkownika: {}", registerUserCommand);
        if(bindingResult.hasErrors()) {
            log.debug("Błędne dane: {}", bindingResult.getAllErrors());
            return "register";
        }
            try{
                Long id = userService.create(registerUserCommand);
                log.debug("Dodano użytkownika o id: {}", id);
                return "redirect:/";
            } catch (UserAlreadyExistsException uaee) {
                bindingResult.rejectValue("username", null, "Użytkownik o takiej nazwie już istnieje");
                return "register";
            } catch (RuntimeException re) {
                bindingResult.rejectValue(null, null, "Wystąpił błąd");
                return "register";
        }
    }
}
