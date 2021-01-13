package com.tech1.task.resource;

import com.tech1.task.dto.AuthUser;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.service.TokenService;
import com.tech1.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource {

    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public AuthResource(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody AuthUser authUser) throws UserNotFoundException {
        if (!userService.getUserByLogin(authUser.getLogin()).getPassword().equals(authUser.getPassword())) {
            return "not authorized";
        }
        return tokenService.createToken(userService.getUserByLogin(authUser.getLogin()).getId());
    }
}
