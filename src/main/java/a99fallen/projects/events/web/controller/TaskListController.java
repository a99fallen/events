package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.sevice.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
@Slf4j @RequiredArgsConstructor
public class TaskListController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        model.addAttribute("userTasks", taskService.findUserTasks());
        return "task/tasks";
    }
}