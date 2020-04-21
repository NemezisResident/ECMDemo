package com.nemezis.users.controllers;

import com.nemezis.models.UserDto;
import com.nemezis.models.Wrapper;
import com.nemezis.users.entity.User;
import com.nemezis.users.services.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class UserController {

    @Autowired private UserService userService;
    @Autowired private MapperFacade mapperFacade;

    // Documents
    @GetMapping("/")
    public Wrapper<List<UserDto>> getDocuments() {
        return Wrapper.create(mapperFacade.mapAsList(userService.getUsers(), UserDto.class));
    }

    @GetMapping("/{id}")
    public Wrapper<UserDto> getDocumentById(@PathVariable Long id) {
        return Wrapper.create(mapperFacade.map(userService.getUserById(id), UserDto.class));
    }

    @PutMapping("/")
    public ResponseEntity putDocument(@RequestBody UserDto UserDto) {
        return ResponseEntity.ok(userService.saveUser(mapperFacade.map(UserDto, User.class)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDocumentById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}