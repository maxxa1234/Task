package com.tech1.task.service;

import com.tech1.task.dto.UserDto;
import com.tech1.task.dto.UserNamesDto;
import com.tech1.task.entity.User;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.UserForm;

import java.util.List;

public interface UserService {

    User getUserById(Long id) throws UserNotFoundException;

    List<UserDto> getUsersWhereAgeIsGrater(int age);

    UserNamesDto getUsersWithArticles();

    void saveUser(UserForm userForm);

    User getUserByLogin(String login) throws UserNotFoundException;
}
