package org.example.dto;

public class AlbumDto {
    private String name;

    private Long musician;

    public AlbumDto(){

    }

    public AlbumDto(String name, Long musician) {
        this.name = name;
        this.musician = musician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMusician() {
        return musician;
    }

    public void setMusician(Long musician) {
        this.musician = musician;
    }

    public AlbumDto(String name){
        this.name = name;
    }
}
