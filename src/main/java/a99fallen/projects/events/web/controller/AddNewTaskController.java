package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.sevice.TaskService;
import a99fallen.projects.events.web.command.CreateTaskCommand;
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
@RequestMapping("/task")
@Slf4j
@RequiredArgsConstructor
public class AddNewTaskController {

    private final TaskService taskService;

    @GetMapping("/add")
    public String getAddTaskPage(Model model) {
        model.addAttribute(new CreateTaskCommand());
        return "/task/add";
    }

    @PostMapping("/add")
    public String processAddTask(@Valid CreateTaskCommand createTaskCommand, BindingResult bindings) {
        log.debug("Dane do utworzenia zadania: {}", createTaskCommand);
        if(bindings.hasErrors()) {
            log.debug("Dane zawierają błędy: {}", bindings.getAllErrors());
            return "add";
        }

        try {
            taskService.add(createTaskCommand);
            log.debug("Utworzono zadanie");
            return "redirect:/task/tasks";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Błąd podczas tworzenia zadania", re);
            bindings.rejectValue(null, null, "Wystąpił błąd");
            return "addd";
        }
    }
}
