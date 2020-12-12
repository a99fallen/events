package a99fallen.projects.events.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
@Slf4j @RequiredArgsConstructor
public class TaskListContoller {

    @GetMapping("/tasks")
    public String getTaskList() {
        return "/task/tasks";
    }
}
