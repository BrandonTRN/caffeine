package com.brtn.traine.caffeine.controller;

import com.brtn.traine.caffeine.dto.UserDTO;
import com.brtn.traine.caffeine.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brtn/v1/cache")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/example-cache/{username}")
    public ResponseEntity<UserDTO> getUserByUserName(@PathVariable("username") String userName) {
        return new ResponseEntity<>(this.userService.findByUserName(userName), HttpStatus.OK);
    }

}
