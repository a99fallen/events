package a99fallen.projects.events.web.controller;

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
        return "form";
    }

    @PostMapping
    public String processRegister(@Valid RegisterUserCommand registerUserCommand, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        if(userService.checkIfUserAlreadyExists(registerUserCommand.getUsername())){
            bindingResult.rejectValue("username", null, "Użytkownik o takiej nazwie już istnieje");
            return "form";
        }else {

            Long id = userService.create(registerUserCommand);
            log.debug("User added, id: {}", id);
            return "redirect:/";
        }
    }

}
