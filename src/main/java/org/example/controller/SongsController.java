package org.example.controller;

import org.example.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongsController {
    private final SongService songService;

    public SongsController (SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/mainpage/songs")
    public String allSongs(Model model) {
        var songs = songService.getAllSong();
        model.addAttribute("songs", songs);

        return "AllSongs.html";
    }
}
