package net.kutomi.kutomis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/about")
@RestController
public class AboutController {

    @GetMapping
    public String about() {
        return "API dos Kutomis";
    }

}
