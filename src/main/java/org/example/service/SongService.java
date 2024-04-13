package org.example.service;

import org.example.dto.SongDto;
import org.example.entity.Musician;
import org.example.entity.Song;
import org.example.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository repository;

    private final MusicianService musicianService;

    public SongService(SongRepository repository, MusicianService musicianService) {
        this.repository = repository;
        this.musicianService = musicianService;
    }

    public String addSong(SongDto dto){
        if(!dto.getName().isBlank() && dto.getName().length() > 2){
            Song song = new Song();
            song.setName(dto.getName());

            if(dto.getMusician() != null){
                Musician musician = musicianService.getMusicianById(dto.getMusician());
                song.setMusician(musician);
            }else{
                song.setMusician(null);
            }

            repository.save(song);
        }
        return "Added";
    }

    public List<Song> getAllSong(){
        return repository.findAll();
    }
}
