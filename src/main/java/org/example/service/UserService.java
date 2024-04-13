package org.example.service;

import org.example.dto.UserDto;
import org.example.entity.Admin;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    private final AdminService adminService;

    public UserService(UserRepository repository, AdminService adminService) {
        this.repository = repository;
        this.adminService = adminService;
    }

    public String addUser(UserDto dto){
        if (!dto.getName().isBlank() && dto.getName().length() > 2){
            User user = new User();
            user.setName(dto.getName());

            if (dto.getAdmin() != null) {
                Admin admin = adminService.getAdminById(dto.getAdmin());
                user.setAdmin(admin);
            } else {
                user.setAdmin(null);
            }

            repository.save(user);
        }
        return "Added";
    }


    public List<User> getAllUser(){
        return repository.findAll();
    }
}
