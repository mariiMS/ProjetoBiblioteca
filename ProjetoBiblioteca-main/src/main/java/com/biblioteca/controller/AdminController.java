package com.biblioteca.controller;

import com.biblioteca.model.Admin;
import com.biblioteca.repository.AdminRepository;
import com.biblioteca.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@Validated
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public ResponseEntity<ApiResponse> listarAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return ResponseEntity.ok(new ApiResponse("Lista de admins", admins));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> buscarAdmin(@PathVariable Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return ResponseEntity.ok(new ApiResponse("Admin encontrado", admin.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Admin não encontrado", null));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> inserirAdmin(@Valid @RequestBody Admin admin) {
        Admin novoAdmin = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Admin criado com sucesso", novoAdmin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarAdmin(@PathVariable Long id, @Valid @RequestBody Admin admin) {
        return adminRepository.findById(id)
                .map(adminExistente -> {
                    adminExistente.setNome(admin.getNome());
                    adminExistente.setUsername(admin.getUsername());
                    adminExistente.setSenha(admin.getSenha());
                    Admin adminAtualizado = adminRepository.save(adminExistente);
                    return ResponseEntity.ok(new ApiResponse("Admin atualizado com sucesso", adminAtualizado));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("Admin não encontrado", null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAdmin(@PathVariable Long id) {
        return adminRepository.findById(id)
                .map(admin -> {
                    adminRepository.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
