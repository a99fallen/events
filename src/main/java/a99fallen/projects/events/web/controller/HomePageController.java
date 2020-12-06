package a99fallen.projects.events.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j @RequiredArgsConstructor
public class HomePageController {

    @GetMapping
    public String getHomepage() {
        return "/";
    }
}
