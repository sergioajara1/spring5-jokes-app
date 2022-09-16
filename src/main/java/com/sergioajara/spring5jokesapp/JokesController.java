package com.sergioajara.spring5jokesapp;

import com.sergioajara.spring5jokesapp.services.JokesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokesService jokesService;

    public JokesController(@Qualifier("jokesServiceImpl") JokesService jokes) {
        this.jokesService = jokes;
    }

    @RequestMapping("/")
    String getJokes(Model model) {
        model.addAttribute("joke", jokesService.getJoke());
        return "index";
    }
}
