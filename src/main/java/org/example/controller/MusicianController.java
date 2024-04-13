package org.example.controller;

import org.springframework.ui.Model;
import org.example.service.MusicianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicianController {
    private final MusicianService musicianService;

    public MusicianController (MusicianService musicianService) {
        this.musicianService = musicianService;
    }

    @RequestMapping("/mainpage/musicians")
    public String allMusicians(Model model) {
        var musicians = musicianService.getAllMusician();
        model.addAttribute("musicians", musicians);

        return "AllMusicians.html";
    }
}
