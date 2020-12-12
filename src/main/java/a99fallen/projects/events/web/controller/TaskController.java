package a99fallen.projects.events.web.controller;

import a99fallen.projects.events.domain.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j @RequiredArgsConstructor
public class TaskController {

    @PostMapping("/addTask")
    public String addTask() {
        return "/tasks";
    }
}
