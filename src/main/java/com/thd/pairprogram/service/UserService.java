package com.thd.pairprogram.service;

import com.thd.pairprogram.dao.UserRepository;
import com.thd.pairprogram.dto.GenericResponse;
import com.thd.pairprogram.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }

        return users;
    }

    @Transactional
    public GenericResponse addUser(String name, String location, String tab) {
        GenericResponse response = new GenericResponse();
        try {
            userRepository.save(new User(name, location, tab));
            response.setStatus(HttpStatus.OK.value());
            response.setBody("User added successfully");
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.getMessage());
        }
        return response;
    }

    @Transactional
    public GenericResponse updateUser(String name, String location, String id, String tab) {
        GenericResponse response = new GenericResponse();
        try {
            userRepository.save(new User(name, location, id, tab));
            response.setStatus(HttpStatus.OK.value());
            response.setBody("User updated successfully");
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.getMessage());
        }
        return response;
    }

    @Transactional
    public GenericResponse deleteUser(String name) {
        GenericResponse response = new GenericResponse();
        try {
            userRepository.deleteByName(name);
            response.setStatus(HttpStatus.OK.value());
            response.setBody("User deleted successfully");
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.getMessage());
        }
        return response;
    }
}
