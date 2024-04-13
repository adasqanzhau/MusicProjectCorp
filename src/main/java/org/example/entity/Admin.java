package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mp_admin")
public class Admin {

    public Admin(){
    }

    public Admin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "admin")
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
