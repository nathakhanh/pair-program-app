package com.thd.pairprogram.controller;


import com.thd.pairprogram.dto.GenericResponse;
import com.thd.pairprogram.dto.User;
import com.thd.pairprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
//@CrossOrigin()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/add", method = POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse addUser(@RequestParam(value = "name") String name, @RequestParam(value = "location", defaultValue = "default") String location,  @RequestParam(value = "tab") String tab) {
        GenericResponse response = userService.addUser(name, location, tab);
        return response;
    }

    @RequestMapping(value = "/update", method = PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse updateUser(@RequestParam(value = "name") String name, @RequestParam(value = "location") String location, @RequestParam(value = "id") String id, @RequestParam(value = "tab") String tab) {
        GenericResponse response = userService.updateUser(name, location, id, tab);
        return response;
    }


    @RequestMapping(value = "/delete", method = POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse deleteUser(@RequestParam(value = "name") String name) {
        GenericResponse response = userService.deleteUser(name);
        return response;
    }
}
