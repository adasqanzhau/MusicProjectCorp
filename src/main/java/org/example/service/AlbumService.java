package org.example.service;

import org.example.dto.AlbumDto;
import org.example.entity.Album;
import org.example.entity.Musician;
import org.example.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AlbumService {

    private final AlbumRepository repository;

    private final MusicianService musicianService;

    public AlbumService(AlbumRepository repository, MusicianService musicianService) {
        this.repository = repository;
        this.musicianService = musicianService;
    }

    public String addAlbum(AlbumDto dto){
        if(!dto.getName().isBlank() && dto.getName().length() > 2){
            Album album = new Album();
            album.setName(dto.getName());

            if(dto.getMusician() != null){
                Musician musician = musicianService.getMusicianById(dto.getMusician());
                album.setMusician(musician);
            }else{
                album.setMusician(null);
            }

            repository.save(album);
        }
        return "Added";
    }

    public List<Album> getAllAlbum(){
        return repository.findAll();
    }
}
