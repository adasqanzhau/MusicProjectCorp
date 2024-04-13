package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mp_musician")
public class Musician {

    public Musician(){
    }

    public Musician(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Song> getSongList(){
        return songList;
    }

    public void setSongList(List<Song> songList){
        this.songList = songList;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "musician")
    private List<Song> songList;

    @OneToMany(mappedBy = "musician")
    private List<Album> albumList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
