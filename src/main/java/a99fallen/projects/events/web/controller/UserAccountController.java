package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.sevice.TaskService;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import a99fallen.projects.events.web.command.EditTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j @RequiredArgsConstructor
@RequestMapping
public class UserAccountController {

    private final TaskService taskService;
    private String selectedTaskName;

    @GetMapping("/account")
    public String getUserAccount(Model model) {
        model.addAttribute("userTasks", taskService.findUserTasks());
        model.addAttribute("userTask", new EditTaskCommand());
        return "user/account";
    }

    @GetMapping("/account/{name}")
    public String getUserAccountAndTask(@PathVariable("name") String name, Model model) {
        selectedTaskName =name;
        model.addAttribute("userTasks", taskService.findUserTasks());
        EditTaskCommand oneTask = taskService.getTaskByName(name);
        if (oneTask != null) {
            log.debug("ZADANIE: {}", oneTask);
            model.addAttribute("userTask", oneTask);
            return "user/account";
        }
        return "user/account";
    }


    @GetMapping("/add")
    public String getAddTaskPage(Model model) {
        model.addAttribute(new CreateTaskCommand());
        return "/user/account";
    }

    @PostMapping("/account")
    public String editTask(@Valid EditTaskCommand editTaskCommand) {
        log.debug("Dane do edycji taska: {}", editTaskCommand);
        try {
            boolean success = taskService.edit(editTaskCommand, selectedTaskName);
            log.debug("Udana edycja danych? {}", success);
            return "redirect:/account";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Błąd przy edycji danych", re);
        }
        return "redirect:/account";
    }
    @PostMapping("account/deleteTask")
        public String deleteTask(@Valid EditTaskCommand editTaskCommand){
            taskService.deleteTask(selectedTaskName);
        return "redirect:/account";
    }
}
