package com.teste.controller;

import com.teste.model.User;
import com.teste.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ApiOperation(value = "Salvar um usuário na API")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Usuário criado com sucesso."),
            @ApiResponse(code = 401, message = "Falha na autenticação")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

}
