package com.example.crud.controller;

import com.example.crud.dto.request.UserRequest;
import com.example.crud.dto.response.UserResponse;
import com.example.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final UserService userService;

    @GetMapping("/{id}") // Read
    public UserResponse getResponse(@PathVariable Long id) {
        return userService.readData(id);
    }

    @PostMapping // Create
    public void writeRequest(@RequestBody @Valid UserRequest userRequest) {
        userService.createData(userRequest);
    }

    @PutMapping("/{id}") // Update
    public void updateData(@RequestBody @Valid UserRequest userRequest, @PathVariable Long id) {
        userService.updateData(userRequest, id);
    }

    @DeleteMapping("/{id}") // Delete
    public void removeData(@PathVariable Long id) {
        userService.deleteData(id);
    }

}
