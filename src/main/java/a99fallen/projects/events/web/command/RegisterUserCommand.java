package a99fallen.projects.events.web.command;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterUserCommand {
    @Email @NotBlank
    private String username;
    @NotBlank @Size(min = 4, max = 24)
    private String password;
}
