package org.example.service;

import org.example.dto.MusicianDto;
import org.example.entity.Musician;
import org.example.repository.MusicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicianService {

    private final MusicianRepository repository;

    public MusicianService(MusicianRepository repository){
        this.repository = repository;
    }

    public String addMusician(MusicianDto dto){
        try {
            Musician musician = new Musician();
            musician.setName(dto.getName());
            repository.save(musician);
        } catch (Exception e){
            return "Not Added" + e.getMessage();
        }
        return "Added";
    }

    public List<Musician> getAllMusician(){
        return repository.findAll();
    }

    public Musician getMusicianById(Long id){
        return repository.getById(id);
    }

}
