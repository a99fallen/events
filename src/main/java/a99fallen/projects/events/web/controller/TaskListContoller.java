package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.sevice.TaskService;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
@Slf4j @RequiredArgsConstructor
public class TaskListContoller {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        model.addAttribute("userTasks", taskService.findUserTasks());
        return "task/tasks";
    }
}