package org.example.controller;

import org.example.dto.*;
import org.example.entity.*;
import org.example.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    private final AdminService adminService;

    private final MusicianService musicianService;

    private final SongService songService;

    private final AlbumService albumService;

    public HomeController(UserService userService, AdminService adminService, MusicianService musicianService, SongService songService, AlbumService albumService) {
        this.userService = userService;
        this.adminService = adminService;
        this.musicianService = musicianService;
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getHome(){
        return "Hello!";
    }

    @GetMapping("/{name}")
    public String greetingToUser(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @PostMapping("/user")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
         return userService.getAllUser();
    }

    @PostMapping("/admin")
    public String addAdmin(@RequestBody AdminDto adminDto){
        return adminService.addAdmin(adminDto);
    }

    @GetMapping("/admin")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PostMapping("/song")
    public String addSong(@RequestBody SongDto songDto){
        return songService.addSong(songDto);
    }

    @GetMapping("/song")
    public List<Song> getAllSongs(){
        return songService.getAllSong();
    }

    @PostMapping("/album")
    public String addAlbum(@RequestBody AlbumDto albumDto){
        return albumService.addAlbum(albumDto);
    }

    @GetMapping("/album")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbum();
    }

    @PostMapping("/musician")
    public String addMusician(@RequestBody MusicianDto musicianDto){
        return musicianService.addMusician(musicianDto);
    }

    @GetMapping("/musician")
    public List<Musician> getAllMusician(){
        return musicianService.getAllMusician();
    }

}
