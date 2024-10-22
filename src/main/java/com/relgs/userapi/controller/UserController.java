package com.relgs.userapi.controller;

import com.github.javafaker.Faker;
import com.relgs.userapi.Factories;
import com.relgs.userapi.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/user")
public class UserController {

    protected static final List<UserDTO> usuarios = new ArrayList<>();

    @PostConstruct
    public void initiateList() {
        IntStream.range(0, 200).forEach(i -> usuarios.add(Factories.generateUserDTO()));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        return usuarios
        .stream()
        .filter(UserDTO -> UserDTO.getCpf().equals(cpf))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("User not found."));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO inserir(@RequestBody @Valid UserDTO userDTO){
        userDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf){
        return usuarios
            .removeIf(userDTO -> userDTO.getCpf().equals(cpf));
}
}