package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.web.command.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@Slf4j
@RequiredArgsConstructor
public class AddNewTaskController {

    @GetMapping
    public String getAddTaskPage(Model model) {
        model.addAttribute(new CreateTaskCommand());
        return "/tasks/add";
    }
}
