package com.tech1.task.resource;

import com.tech1.task.dto.AuthUser;
import com.tech1.task.dto.UserDto;
import com.tech1.task.dto.UserNamesDto;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.UserForm;
import com.tech1.task.service.TokenService;
import com.tech1.task.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private UserServiceImpl userService;
    private TokenService tokenService;

    @Autowired
    public UserResource(UserServiceImpl userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUserByAge(@RequestParam(value = "age") int age) {
        return userService.getUsersWhereAgeIsGrater(age);
    }

    @RequestMapping(value ="/name", method = RequestMethod.GET)
    public UserNamesDto getUserNames() {
        return userService.getUsersWithArticles();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveUser(@RequestBody @Valid UserForm userForm) {
         userService.saveUser(userForm);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody AuthUser authUser) throws UserNotFoundException {
        if (!userService.getUserByLogin(authUser.getLogin()).getPassword().equals(authUser.getPassword())) {
            return "not authorized";
        }
        return tokenService.createToken(userService.getUserByLogin(authUser.getLogin()).getId());
    }
}
