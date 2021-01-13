package com.tech1.task.resource;

import com.tech1.task.dto.UserDto;
import com.tech1.task.dto.UserNamesDto;
import com.tech1.task.form.UserForm;
import com.tech1.task.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private UserServiceImpl userService;

    @Autowired
    public UserResource(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUserByAge(@RequestParam(value = "age") int age) {
        return userService.getUsersWhereAgeIsGrater(age);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public UserNamesDto getUserNames() {
        return userService.getUsersWithArticles();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveUser(@RequestBody @Valid UserForm userForm) {
        userService.saveUser(userForm);
    }


}
