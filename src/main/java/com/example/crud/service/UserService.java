package com.example.crud.service;

import com.example.crud.dto.request.UserRequest;
import com.example.crud.dto.response.UserResponse;
import com.example.crud.entity.Repository;
import com.example.crud.entity.User;
import com.example.crud.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final Repository repository;
    public UserResponse readData(Long id) {
        User user = repository.findById(id)
                .orElseThrow(NotFoundException::new);
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public void createData(UserRequest userRequest) {
        repository.save(User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build());
    }

    public void deleteData(Long id) {
        repository.delete(repository.findById(id).orElseThrow(NotFoundException::new));
    }

    public void updateData(UserRequest userRequest, Long id) {
        User user = repository.findById(id).orElseThrow(NotFoundException::new);
        user.update(userRequest.getName(), userRequest.getPassword(), userRequest.getEmail());
        repository.save(user);
    }
}
