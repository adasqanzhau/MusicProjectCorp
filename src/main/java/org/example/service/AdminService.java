package org.example.service;

import org.example.dto.AdminDto;
import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public String addAdmin(AdminDto dto){
        try {
            Admin admin = new Admin();
            admin.setName(dto.getName());
            repository.save(admin);
        } catch (Exception e){
            return "Not Added" + e.getMessage();
        }
        return "Added";
    }

    public List<Admin> getAllAdmin(){
        return repository.findAll();
    }

    public Admin getAdminById(Long id){
        return repository.getById(id);
    }
}
